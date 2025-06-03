package top.nexacampus.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.pojo.entity <br>
 * 系统角色实体类
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
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long roleId; // 角色ID
    private String roleName; // 角色名称
    private String description; // 角色描述
    private LocalDateTime createTime; // 创建时间

}
