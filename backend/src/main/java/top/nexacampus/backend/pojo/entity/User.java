package top.nexacampus.backend.pojo.entity;


import io.swagger.annotations.ApiModel;
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
 * 用户信息实体类
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
@ApiModel(description = "用户信息实体类")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long   userId; // 用户ID
    private String studentNo; // 学号
    private String realName; // 真实姓名
    private String password; // 密码
    private String phone; // 手机号
    private String email; // 邮箱
    private String gender; // 性别
    private LocalDate birthDate; // 出生日期
    private Long deptId; // 所属院系ID
    private String wechatOpenid; // 微信OpenID
    private String avatarUrl; // 头像URL
    private String status; // 用户状态（如：正常、禁用等）
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间

}
