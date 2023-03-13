package cn.sdadgz.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sdadgz
 * @since 2023/2/13
 */

@FeignClient(name = "demo-02",path = "/test")
public interface TestService {

    @GetMapping("/m")
    String m();

}
