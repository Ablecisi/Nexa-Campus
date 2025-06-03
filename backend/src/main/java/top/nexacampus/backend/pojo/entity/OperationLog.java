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
 * 系统操作日志实体类
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
public class OperationLog implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long logId;
    private Long userId;
    private String operation;
    private String module;
    private String ipAddress;
    private LocalDateTime operateTime;
    private String result;
    private String detail;

}
