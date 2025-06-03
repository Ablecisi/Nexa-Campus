package top.nexacampus.backend.service;

import top.nexacampus.backend.pojo.dto.UserLoginDTO;
import top.nexacampus.backend.pojo.vo.UserLoginVO;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.service <br>
 * 身份认证服务接口
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 20:56
 **/
public interface AuthService {

    /**
     * 用户登录
     * @param userLoginDTO 用户登录数据传输对象
     * @return UserLoginVO 用户登录结果
     */
    UserLoginVO login(UserLoginDTO userLoginDTO);
}
