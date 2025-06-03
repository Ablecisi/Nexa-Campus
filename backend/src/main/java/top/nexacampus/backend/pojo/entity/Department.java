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
 * 院系信息实体类
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
public class Department implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long deptId; // 院系ID
    private String deptName;
    private String deptCode; // 院系代码
    private String dean; // 院长
    private String contactPhone;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
