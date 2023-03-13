package cn.sdadgz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sdadgz
 * @since 2023/2/13
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${my.username}")
    private String username;

    @Value("${spring.cloud.sentinel.transport.dashboard}")
    private String dashboard;

    @GetMapping("/username")
    public String username() {
        return username;
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return dashboard;
    }

}
