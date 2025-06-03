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
 * 门禁通行记录实体类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 19:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessRecord implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long recordId; // 主键ID
  private Long userId; // 用户ID
  private Long deviceId; // 设备ID
  private LocalDateTime accessTime; // 访问时间
  private String accessType; // 访问类型（如：进入、离开）
  private String result; // 访问结果（如：成功、失败）
  private String failReason; // 失败原因（如果有的话）

}
