package top.nexacampus.backend.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nexacampus.backend.common.constant.JwtClaimsConstant;
import top.nexacampus.backend.common.constant.MessageConstant;
import top.nexacampus.backend.common.exception.BaseException;
import top.nexacampus.backend.common.properties.JwtProperties;
import top.nexacampus.backend.common.properties.WeChatProperties;
import top.nexacampus.backend.common.utils.HttpClientUtil;
import top.nexacampus.backend.common.utils.JwtUtil;
import top.nexacampus.backend.mapper.AuthMapper;
import top.nexacampus.backend.mapper.RoleUserMapper;
import top.nexacampus.backend.pojo.dto.UserLoginDTO;
import top.nexacampus.backend.pojo.entity.User;
import top.nexacampus.backend.pojo.vo.UserLoginVO;
import top.nexacampus.backend.service.AuthService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.service.impl <br>
 * 身份认证服务实现类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 20:57
 **/
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;
    private final JwtProperties jwtProperties;
    private final RoleUserMapper roleUserMapper;
    private final WeChatProperties weChatProperties;

    @Autowired
    public AuthServiceImpl(AuthMapper authMapper, JwtProperties jwtProperties, RoleUserMapper roleUserMapper, WeChatProperties weChatProperties) {
        this.authMapper = authMapper;
        this.jwtProperties = jwtProperties;
        this.roleUserMapper = roleUserMapper;
        this.weChatProperties = weChatProperties;
    }

    /**
     * 用户登录
     *
     * @param userLoginDTO 用户登录数据传输对象
     * @return UserLoginVO 用户登录结果
     */
    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        if (userLoginDTO.getCode() == null || userLoginDTO.getCode().isEmpty()) {
            // 如果code不为空，说明是微信登录
            return webLogin(userLoginDTO);
        } else {
            // 否则是Web登录
            return wxLogin(userLoginDTO);
        }
    }

    private UserLoginVO webLogin(UserLoginDTO userLoginDTO) {
        User user = new User();
        BeanUtils.copyProperties(userLoginDTO, user);

        // 调用Mapper进行登录验证
        user = authMapper.getUserByUser(user);
        if (user == null || !userLoginDTO.getPassword().equals(user.getPassword())) throw new BaseException(MessageConstant.PASSWORD_OR_ACCOUNT_ERROR);
        // 查出用户角色
        Long roleId = roleUserMapper.getRoleIdByUserId(user.getUserId());

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getUserId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        // 返回登录结果
        return UserLoginVO.builder()
                .userId(user.getUserId())
                .studentNo(user.getStudentNo())
                .realName(user.getRealName())
                .roleId(roleId)
                .token(token)
                .build();
    }

    // 微信登录接口地址
    private static final String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session";

    private UserLoginVO wxLogin(UserLoginDTO userLoginDTO) {
        // 1.调用微信接口服务获得当前用户的openid
        String openid = getOpenID(userLoginDTO.getCode());
        System.out.println("获取到的openid: " + openid);

        // 2.判断openid是否为空，如果为空，抛出异常
        if (openid == null) {
            // 2.1 如果openid为空，抛出异常
            throw new BaseException(MessageConstant.LOGIN_FAILED);
        }

        // 3.判断当前的微信用户是否是一个新用户，如果是新用户，保存到数据库中
        User user = authMapper.getUserByOpenId(openid);

        // 4.如果是新用户，自动完成注册
        if (user == null) {
            user = User.builder()
                    .wechatOpenid(openid)
                    .realName("新用户"+ UUID.randomUUID())
                    .createTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build();
            authMapper.insert(user);
        }

        //TODO 5.如果是新用户，自动完成注册后，插入用户角色
        //roleUserMapper.insert();

        // 查出用户角色
        Long roleId = roleUserMapper.getRoleIdByUserId(user.getUserId());

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getUserId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        // 返回登录结果
        return UserLoginVO.builder()
                .userId(user.getUserId())
                .studentNo(user.getStudentNo())
                .realName(user.getRealName())
                .roleId(roleId)
                .token(token)
                .wechatOpenid(openid)
                .build();
    }

    /**
     * 调用微信接口服务获得当前用户的openid
     * @param code 微信登录凭证
     * @return openid
     */
    private String getOpenID(String code) {
        // 1.1 拼接请求参数
        Map<String, String> claims = new HashMap<>();
        claims.put("appid", weChatProperties.getAppid());
        claims.put("secret", weChatProperties.getSecret());
        claims.put("js_code", code);
        claims.put("grant_type", "authorization_code");
        String responseJson = HttpClientUtil.doGet(WX_LOGIN, claims);
        JSONObject jsonObject = JSON.parseObject(responseJson);
        // 1.2 获取openid
        return jsonObject.getString("openid");
    }
}
