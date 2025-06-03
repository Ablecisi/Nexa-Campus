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
 * 报修进度跟踪实体类
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
public class RepairProgress implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long progressId;
    private Long orderId;
    private String status;
    private String description;
    private LocalDateTime updateTime;
    private Long operatorId;
}
