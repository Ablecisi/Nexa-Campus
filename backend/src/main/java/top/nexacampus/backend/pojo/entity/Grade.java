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
 * 学生成绩实体类
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
public class Grade implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long gradeId;
    private Long studentId;
    private Long courseId;
    private Double score;
    private Double gradePoint;
    private String semester;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
