package cn.sdadgz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/15 18:52:01
 */
@SpringBootApplication
@EnableFeignClients
@EnableTransactionManagement
public class Seata03_Application {
    public static void main(String[] args) {
        SpringApplication.run(Seata03_Application.class, args);
    }
}
