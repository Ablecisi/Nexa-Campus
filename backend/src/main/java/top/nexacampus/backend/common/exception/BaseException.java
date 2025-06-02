package top.nexacampus.backend.common.exception;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.common.exception <br>
 * 业务异常类
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 16:01
 **/
public class BaseException extends RuntimeException {
    public BaseException() {
    }
    public BaseException(String message) {
        super(message);
    }
}
