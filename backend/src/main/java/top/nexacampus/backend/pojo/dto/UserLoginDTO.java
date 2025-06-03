package top.nexacampus.backend.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.pojo.dto <br>
 * 用户登录数据传输对象
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 20:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO implements Serializable {
    private Long studentNo; // 学号/工号
    private String password; // 密码
    private String code; // 微信登录凭证
}
