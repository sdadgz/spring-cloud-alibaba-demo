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
public class SeataApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataApplication.class, args);
    }
}
