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
 * 校园卡信息实体类
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
@ApiModel(description = "角色权限关联实体类")
public class RolePermission implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long roleId;
    private String permCode;
    private LocalDateTime createTime;

}
