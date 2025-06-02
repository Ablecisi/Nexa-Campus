package top.nexacampus.backend.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.nexacampus.backend.common.properties.AliOssProperties;
import top.nexacampus.backend.common.utils.AliOssUtil;

/**
 * Nexa Campus
 * top.nexacampus.backend.configuration <br>
 * 阿里云OSS配置类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:07
 **/
@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties) {
        log.info("初始化AliOssUtil");
        return new AliOssUtil(
            aliOssProperties.getEndpoint(),
            aliOssProperties.getAccessKeyId(),
            aliOssProperties.getAccessKeySecret(),
            aliOssProperties.getBucketName(),
            aliOssProperties.getFolderName()
        );
    }
}
