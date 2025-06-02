package top.nexacampus.backend.common.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Nexa Campus
 * top.nexacampus.backend.configuration <br>
 * 阿里云OSS属性注入类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:07
 **/
@Component
@ConfigurationProperties(prefix = "nc.alioss")
@Data
public class AliOssProperties {
    private String endpoint; // OSS地域节点
    private String accessKeyId; // OSS访问Key
    private String accessKeySecret; // OSS访问密钥
    private String bucketName; // OSS存储空间
    private String folderName; // OSS文件夹名称
}
