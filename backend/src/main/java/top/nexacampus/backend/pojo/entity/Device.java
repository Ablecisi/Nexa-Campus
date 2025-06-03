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
 * 设备信息实体类
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
public class Device implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long deviceId;
    private String deviceCode;
    private String name;
    private Long type; // 设备类型ID
    private String location; // 设备位置
    private Long status; // 设备状态
    private LocalDate installDate; // 安装日期
    private LocalDate warrantyEndDate; // 保修结束日期
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
