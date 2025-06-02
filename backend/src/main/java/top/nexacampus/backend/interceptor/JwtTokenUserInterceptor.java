package top.nexacampus.backend.interceptor;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.nexacampus.backend.common.constant.JwtClaimsConstant;
import top.nexacampus.backend.common.context.BaseContext;
import top.nexacampus.backend.common.context.MessageConstant;
import top.nexacampus.backend.common.properties.JwtProperties;
import top.nexacampus.backend.common.utils.JwtUtil;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.interceptor <br>
 * jwt令牌校验的拦截器
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:55
 **/
@Component
@Slf4j
public class JwtTokenUserInterceptor implements HandlerInterceptor {

    private final JwtProperties jwtProperties;

    @Autowired
    public JwtTokenUserInterceptor(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    /**
     * 校验jwt
     *
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return 是否通过
     */
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            log.info("当前拦截到的不是动态方法，直接放行");
            return true;
        }

        //1、从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getUserTokenName());

        //2、校验令牌
        try {
            log.info("jwt校验:{}", token);

            if (token == null || token.isEmpty()) {
                //2、没有令牌，响应状态码401
                response.setStatus(401);
                response.getWriter().write(MessageConstant.USER_NOT_LOGIN);
                return false;
            }

            Claims claims = JwtUtil.parseJWT(jwtProperties.getUserSecretKey(), token);
            Long userId = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
            log.info("当前用户id：{}", userId);

            // 将当前登录用户的id存入ThreadLocal中
            BaseContext.setCurrentId(userId);

            //3、通过，放行
            System.out.println("jwt校验通过 userId:"+userId);
            return true;
        } catch (Exception ex) {
            //4、不通过，响应状态码401
            response.setStatus(401);
            log.info("jwt校验失败{}", ex.getMessage());
            return false;
        }
    }
}
