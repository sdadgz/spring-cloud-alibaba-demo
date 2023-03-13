package cn.sdadgz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sdadgz
 * @since 2023/2/14
 */
@FeignClient(value = "demo", path = "/test")
public interface DemoService {

    @GetMapping("/hello")
    String hello();

}
