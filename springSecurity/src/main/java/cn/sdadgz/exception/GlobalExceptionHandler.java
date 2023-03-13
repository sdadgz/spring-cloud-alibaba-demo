package cn.sdadgz.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/25 13:44:18
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception e) {
        return "exception:" + e.getMessage();
    }

}
