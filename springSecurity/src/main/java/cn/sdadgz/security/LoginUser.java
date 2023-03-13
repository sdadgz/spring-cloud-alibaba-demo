package cn.sdadgz.security;

import cn.sdadgz.entity.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/22 21:15:04
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private User user;

    private List<String> permissions;

    public LoginUser(User user) {
        this.user = user;
    }

    public LoginUser(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    // 授权
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    // 获取密码
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // 获取用户名
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 是否在期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // true放行
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // true放行
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
