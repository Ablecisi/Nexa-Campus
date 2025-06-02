package top.nexacampus.backend.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.nexacampus.backend.common.context.MessageConstant;
import top.nexacampus.backend.common.exception.BaseException;
import top.nexacampus.backend.common.result.Result;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Nexa Campus <br>
 * top.nexacampus.backend.handler <br>
 * 全局异常处理器，处理项目中抛出的业务异常
 * @author Ablecisi
 * @version 0.0.1
 * 2025/6/2
 * 星期一
 * 16:02
 **/
@RestControllerAdvice // 该注解用于定义统一的异常处理类，可以用于捕获Controller层抛出的异常
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex 业务异常
     * @return 返回异常信息
     */
    @ExceptionHandler
    public Result<String> exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage(), "");
    }

    /**
     * 捕获SQL异常
     * @param ex SQL异常
     * @return 返回异常信息
     */
    @ExceptionHandler
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error("SQL异常：{}", ex.getMessage());
        String message = ex.getMessage();
        if (message.contains("Duplicate entry")) {
            String[] split = message.split(" ");
            String username = split[2];
            String msg = username + MessageConstant.ALREADY_EXIST;
            return Result.error(msg, "");
        }
        return Result.error(MessageConstant.UNKNOWN_ERROR, "");
    }

}
