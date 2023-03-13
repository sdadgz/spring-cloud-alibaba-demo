package cn.sdadgz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sdadgz
 * @since 2023/2/14
 */
@SpringBootApplication
@EnableFeignClients
public class SentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }
}
