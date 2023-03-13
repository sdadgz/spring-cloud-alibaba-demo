package cn.sdadgz.controller;

import cn.sdadgz.entity.User;
import cn.sdadgz.service.IUserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sdadgz
 * @since 2023-02-15
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    public User getUser(@RequestParam("id") Integer id){
        return userService.getById(id);
    }

    @GlobalTransactional
    @PostMapping
    public boolean addUser(@RequestBody User user){
        return userService.save(user);
    }

}
