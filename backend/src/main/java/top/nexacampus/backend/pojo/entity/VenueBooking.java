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
 * 场地预约实体类
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
@ApiModel(description = "场地预约实体类")
public class VenueBooking implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long bookingId;
    private Long venueId;
    private Long userId;
    private String purpose;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private Long approverId;
    private LocalDateTime approveTime;
    private String cancelReason;
    private LocalDateTime createTime;

}
