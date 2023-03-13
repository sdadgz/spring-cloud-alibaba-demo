package cn.sdadgz.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/26 15:01:14
 */
@Component
public class Ex {
    public static boolean hasAuthority(String auth){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 我觉得可以这样写
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // 他的写法
        List<String> permissions = loginUser.getPermissions();

        // todo 自定义验证

        return true;
    }
}
