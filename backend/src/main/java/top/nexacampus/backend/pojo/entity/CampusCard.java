package top.nexacampus.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
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
public class CampusCard implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private String        cardId;
  private Long          userId;
  private Double        balance; // 余额
  private String        status;
  private LocalDate     issueDate; // 发卡日期
  private LocalDate     expireDate; // 有效期
  private LocalDateTime lastUsed;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
