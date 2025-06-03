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
 * 报修工单实体类
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
public class RepairOrder implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private String title;
    private String description;
    private String type;
    private String status;
    private LocalDateTime reportTime;
    private LocalDateTime completeTime;
    private Long rating;
    private Long reporterId;
    private Long handlerId;
    private Long deviceId;
    private String location;
    private String imageUrls;

}
