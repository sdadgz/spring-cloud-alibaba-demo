package cn.sdadgz.security;

import cn.sdadgz.entity.User;
import cn.sdadgz.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/24 14:46:16
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final IUserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (Objects.isNull(token)) {
            // 没有token，放行
            filterChain.doFilter(request, response);
            return;
        }

        // todo 获取用户，这里先写死
        // 这里本应是根据刚才的token从redis中取到权限信息和用户
        User user = userService.getById(4);
        LoginUser loginUser = new LoginUser(user);
        loginUser.setPermissions(Collections.singletonList("test"));

        // 授权，从数据库中获取
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null,/* 授权 */ loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }
}
