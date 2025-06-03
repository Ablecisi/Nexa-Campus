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
 * 校园卡消费记录实体类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 19:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumption implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long consumeId; // 消费记录ID
  private String cardId; // 校园卡ID
  private Double amount; // 消费金额
  private String location; // 消费地点
  private String deviceId; // 设备ID
  private String type; // 消费类型（如餐饮、购物等）
  private LocalDateTime consumeTime; // 消费时间

}
