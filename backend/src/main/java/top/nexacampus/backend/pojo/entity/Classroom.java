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
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 19:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "教室信息实体类")
public class Classroom implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long roomId; // 教室ID
  private String building; // 教学楼
  private Long floor; // 楼层
  private String roomNo; // 教室编号
  private Long capacity; // 容纳人数
  private Long hasProjector; // 是否有投影仪
  private Long hasAircon; // 是否有空调
  private Long status; // 教室状态（0：未使用，1：使用中，2：维修中，3：已关闭）
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
