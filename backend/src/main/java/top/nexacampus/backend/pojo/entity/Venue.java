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
 * 场地信息实体类
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
@ApiModel(description = "场地信息实体类")
public class Venue implements Serializable {
  @Serial
    private static final long serialVersionUID = 1L;

  private Long venueId;
  private String venueCode;
  private String name;
  private String type;
  private Long capacity;
  private Long needApproval;
  private String rules;
  private String location;
  private Long status;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
