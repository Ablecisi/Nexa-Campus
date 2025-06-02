package top.nexacampus.backend.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.common.utils <br>
 * <h1>jwt工具类</h1>
 * <p>
 * jwt的格式：header.payload.signature<br>
 * <b>header的格式(算法、token的类型): </b>
 * <pre>
 * {
 *     "alg": "HS256",
 *     "typ": "JWT"
 * }
 * </pre>
 *
 * <b>payload的格式(用户名、创建时间、生成时间): </b>
 * <pre>
 * {
 *     "sub": "wang",
 *     "created": 1489079981393,
 *     "exp": 1489684781
 * }
 * </pre>
 * <b>signature的生成算法：</b> <br>
 * {@code HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)}
 * @since 2025/6/2.
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 15:13
 **/
public class JwtUtil {
    private static final Charset charset = StandardCharsets.UTF_8;

    /**
     * 生成jwt
     * 使用Hs256算法, 私匙使用固定秘钥
     *
     * @param secretKey jwt秘钥
     * @param ttlMillis jwt过期时间(毫秒)
     * @param claims    设置的信息
     * @return jwt token
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims) {
        // 生成JWT的时间
        long expMillis = System.currentTimeMillis() + ttlMillis; // 过期时间
        Date exp = new Date(expMillis); // 过期时间

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(charset)); // 使用秘钥生成HMAC SHA密钥
        // 设置jwt的body
        JwtBuilder builder = Jwts.builder()
                .claims(claims)
                // 设置签名使用的签名算法和签名使用的秘钥
                .signWith(key, Jwts.SIG.HS256)
                .expiration(exp);

        return builder.compact(); // 生成token
    }

    /**
     * Token解密
     *
     * @param secretKey jwt秘钥 此秘钥一定要保留好在服务端, 不能暴露出去, 否则sign就可以被伪造, 如果对接多个客户端建议改造成多个
     * @param token     加密后的token
     * @return 解密后的信息
     */
    public static Claims parseJWT(String secretKey, String token) {
        // 得到DefaultJwtParser
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(charset)); // 使用秘钥生成HMAC SHA密钥
        return Jwts.parser()
                // 设置签名的秘钥
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
