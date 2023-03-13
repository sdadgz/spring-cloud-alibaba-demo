package cn.sdadgz.security;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import cn.sdadgz.exception.MyException;
import cn.sdadgz.utils.WebUtil;
import org.springframework.http.codec.cbor.Jackson2CborEncoder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/25 13:57:07
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws MyException {
        String json = JSONUtil.toJsonStr("权限不足");
        WebUtil.renderString(response, json);
    }
}
