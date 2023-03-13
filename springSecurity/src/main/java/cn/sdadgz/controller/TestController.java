package cn.sdadgz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/20 12:47:36
 */
@RestController
@RequestMapping("/test")
@PreAuthorize("hasAuthority('test')")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
