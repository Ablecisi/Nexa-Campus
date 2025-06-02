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
 * 系统权限实体类
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
@ApiModel(description = "系统权限实体类")
public class Permission implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String permCode;
    private String name;
    private String description;
    private String category;
    private LocalDateTime createTime;

}
