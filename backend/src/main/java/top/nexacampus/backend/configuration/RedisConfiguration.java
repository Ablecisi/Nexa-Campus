package top.nexacampus.backend.configuration;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.configuration <br>
 * Redis数据库配置类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:51
 **/
@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public <K, V> RedisTemplate<K, V> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("开始创建RedisTemplate对象");
        RedisTemplate<K, V> redisTemplate = new RedisTemplate<>();
        // 设置redis连接工厂对象
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // 设置键的序列化器
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Object.class)); // 设置值的序列化器
        // 设置RedisTemplate对象
        redisTemplate.afterPropertiesSet(); // 初始化
        log.info("RedisTemplate对象创建成功");
        return redisTemplate;
    }
}
