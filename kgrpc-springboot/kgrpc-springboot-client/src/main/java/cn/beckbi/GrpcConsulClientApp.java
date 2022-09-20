package cn.beckbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-20 23:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GrpcConsulClientApp {
    public static void main(String[] args) {
        SpringApplication.run(GrpcConsulClientApp.class, args);
    }
}
