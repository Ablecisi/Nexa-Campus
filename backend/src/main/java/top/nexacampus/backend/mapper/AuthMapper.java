package top.nexacampus.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.nexacampus.backend.pojo.entity.User;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.mapper <br>
 * 身份认证数据访问层接口
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 20:57
 **/
@Mapper
public interface AuthMapper {
    /**
     * 根据用户信息获取用户
     *
     * @param user 用户实体
     * @return User 用户实体
     */
    User getUserByUser(User user);

    /**
     * 根据微信OpenID获取用户
     *
     * @param openid 微信用户唯一标识
     * @return User 用户实体
     */
    User getUserByOpenId(String wechatOpenid);

    /**
     * 插入新用户
     *
     * @param user 用户实体
     */
    void insert(User user);
}
