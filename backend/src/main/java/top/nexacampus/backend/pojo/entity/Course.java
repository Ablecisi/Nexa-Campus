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
 * 课程信息实体类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 19:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long courseId;
  private String courseCode;
  private String name;
  private String description;
  private Long credit; // 学分
  private Long capacity; // 容纳人数
  private Long teacherId;
  private Long deptId;
  private String semester; // 学期
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
