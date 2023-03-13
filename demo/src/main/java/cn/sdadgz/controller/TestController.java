package cn.sdadgz.controller;

import cn.sdadgz.feign.ConfigService;
import cn.sdadgz.feign.TestService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sdadgz
 * @since 2023/2/12
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @Resource
    private ConfigService configService;

    @GetMapping("/hello")
    public String test() {
        String m = testService.m();
        return "hello world:" + m;
    }

    @GetMapping("/config")
    public String config() {
        return "username:" + configService.username();
    }

}
