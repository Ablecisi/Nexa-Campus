package top.nexacampus.backend.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
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
@RequestMapping("/auth")
@Slf4j
@Api(value = "AuthController", tags = "身份认证控制器")
public class AuthController {
}
