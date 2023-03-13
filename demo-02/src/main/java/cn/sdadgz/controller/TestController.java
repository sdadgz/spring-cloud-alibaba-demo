package cn.sdadgz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sdadgz
 * @since 2023/2/12
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/m")
    public String m() {
        System.out.println("m被调用了");
        return "m";
    }

}
