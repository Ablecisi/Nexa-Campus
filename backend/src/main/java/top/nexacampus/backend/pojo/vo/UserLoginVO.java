package top.nexacampus.backend.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.pojo.vo <br>
 * 用户登录视图对象
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 20:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginVO implements Serializable {
    private Long userId; // 用户ID
    private String studentNo; // 用户名
    private String realName; // 姓名
    private Long roleId; // 角色ID

    private String wechatOpenid; // 微信用户唯一标识

    private String token; // JWT令牌
}
