package cn.sdadgz.controller;

import cn.sdadgz.entity.User;
import cn.sdadgz.security.LoginUser;
import cn.sdadgz.service.IUserService;
import cn.sdadgz.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sdadgz
 * @since 2023-02-23
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final IUserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // 内部使用 UserDetailsService 查询用户，正确返回信息 错误返回空（大概）
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        // 取出刚才返回信息的内部存储的 UserDetails
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }

        LoginUser principal = (LoginUser) authenticate.getPrincipal();
        System.out.println(principal);

        // 返回一个token，在 JwtAuthenticationTokenFilter 中根据这个token获取权限和信息
        return JwtUtil.createToken(principal.getUsername(), principal.getPassword());
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return String.valueOf(userService.save(user));
    }

    @DeleteMapping("/logout")
    public String logout(){
        // 取出来值
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser principal = (LoginUser) authentication.getPrincipal();

        // todo redis删东西

        return "";
    }

}
