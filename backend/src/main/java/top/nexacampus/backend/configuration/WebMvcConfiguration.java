package top.nexacampus.backend.configuration;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.nexacampus.backend.common.json.JacksonObjectMapper;
import top.nexacampus.backend.interceptor.JwtTokenAdminInterceptor;
import top.nexacampus.backend.interceptor.JwtTokenUserInterceptor;

import java.util.List;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.configuration <br>
 * 配置类，注册web层相关组件
 *
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:52
 **/
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private final JwtTokenAdminInterceptor jwtTokenAdminInterceptor;
    private final JwtTokenUserInterceptor jwtTokenUserInterceptor;

    @Autowired
    public WebMvcConfiguration(JwtTokenAdminInterceptor jwtTokenAdminInterceptor, JwtTokenUserInterceptor jwtTokenUserInterceptor) {
        this.jwtTokenAdminInterceptor = jwtTokenAdminInterceptor;
        this.jwtTokenUserInterceptor = jwtTokenUserInterceptor;
    }

    /**
     * 注册自定义拦截器
     *
     * @param registry 拦截器注册对象
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义管理端拦截器...");
        registry.addInterceptor(jwtTokenAdminInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/employee/login");
        log.info("开始注册用户端拦截器...");
        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/*/**")
                .excludePathPatterns("/auth/login");
    }

    /**
     * 扩展消息转换器
     *
     * @param converters 消息转换器列表
     */
    @Override
    protected void extendMessageConverters(@NonNull List<HttpMessageConverter<?>> converters) {
        log.info("开始扩展消息转换器...");
        // 创建一个消息转换器
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // 需要为转换器设置一个对象映射器
        JacksonObjectMapper jacksonObjectMapper = new JacksonObjectMapper();
        // 设置对象映射器
        converter.setObjectMapper(jacksonObjectMapper);
        // 将转换器添加到转换器列表的第一个位置
        converters.addFirst(converter);
        log.info("扩展消息转换器完成");
    }
}
