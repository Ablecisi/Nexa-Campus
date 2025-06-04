package top.nexacampus.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.nexacampus.backend.common.result.Result;
import top.nexacampus.backend.pojo.dto.UserLoginDTO;
import top.nexacampus.backend.pojo.vo.UserLoginVO;
import top.nexacampus.backend.service.AuthService;

/**
 * backend
 * Nexa Campus <br>
 * top.nexacampus.backend.controller <br>
 * 身份认证控制器
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 19:29
 **/
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 身份验证
     *
     * @param userLoginDTO 用户登录数据传输对象
     * @return UserLoginVO 用户登录结果
     */
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录请求: {}", userLoginDTO.getCode() == null ? userLoginDTO.getStudentNo() : userLoginDTO.getCode());
        // 调用服务层进行登录验证
        return Result.success("登陆成功",authService.login(userLoginDTO));
    }

}
