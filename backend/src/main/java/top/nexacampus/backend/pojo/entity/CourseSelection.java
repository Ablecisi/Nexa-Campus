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
 * 学生选课实体类
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
public class CourseSelection implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long selectionId; // 选课ID
    private Long studentId; // 学生ID
    private Long courseId; // 课程ID
    private LocalDateTime selectTime;
    private String status; // 选课状态（如：已选、已退、待选等）

}
