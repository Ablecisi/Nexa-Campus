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
public class Permission implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String permCode; // 权限代码
    private String name; // 权限名称
    private String description; // 权限描述
    private String category; // 权限分类
    private LocalDateTime createTime; // 创建时间

}
