package cn.sdadgz.security;

import cn.hutool.json.JSONUtil;
import cn.sdadgz.exception.MyException;
import cn.sdadgz.utils.WebUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
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
 * @since 2023/2/25 11:51:09
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws MyException {
        String json = JSONUtil.toJsonStr("认证失败");
        WebUtil.renderString(response, json);
    }
}
