package cn.sdadgz.controller;

import cn.sdadgz.feign.DemoService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sdadgz
 * @since 2023/2/14
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @Resource
    private DemoService demoService;

    @GetMapping
    @SentinelResource(value = "test", blockHandler = "blockHandler")
    public String test() {
        return "success";
    }

    // blockHandler
    public String blockHandler(BlockException blockException) {
        return "block";
    }

    // 整合feign
    @GetMapping("/feign")
    public String feign() {
        return "feign:" + demoService.hello();
    }

}
