package top.nexacampus.backend.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Nexa Campus
 * top.nexacampus.backend.common.properties <br>
 * jwt属性注入类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:12
 **/
@Component
@ConfigurationProperties(prefix = "nc.jwt")
@Data
public class JwtProperties {

    /**
     * 管理端员工生成jwt令牌相关配置
     */
    private String adminSecretKey; // 管理端员工生成jwt令牌的密钥
    private long adminTtl; // 管理端员工生成jwt令牌的有效时间
    private String adminTokenName; // 管理端员工生成jwt令牌的名称

    /**
     * 用户端微信用户生成jwt令牌相关配置
     */
    private String userSecretKey; // 用户端微信用户生成jwt令牌的密钥
    private long userTtl; // 用户端微信用户生成jwt令牌的有效时间
    private String userTokenName; // 用户端微信用户生成jwt令牌的名称

}
