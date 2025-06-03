package top.nexacampus.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.configuration <br>
 *
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 22:48
 **/
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // 关闭 CSRF，兼容 6.1+
            .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll()
            //.requestMatchers("/auth/login", "/swagger-ui.html", "/v3/api-docs/**").permitAll()
            //.anyRequest().authenticated()
            );
        return http.build();
    }
}
