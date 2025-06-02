package top.nexacampus.backend.pojo.entity;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.pojo.entity <br>
 * 系统配置实体类
 *
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 19:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "系统配置实体类")
public class SystemConfig implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long configId;
    private String configKey;
    private String configValue;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
