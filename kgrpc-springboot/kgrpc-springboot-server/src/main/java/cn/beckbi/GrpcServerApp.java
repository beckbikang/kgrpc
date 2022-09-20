package cn.beckbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-20 22:33
 */
@SpringBootApplication(scanBasePackages ={"cn.beckbi"})
@EnableDiscoveryClient
public class GrpcServerApp
{
    public static void main(String[] args) {
        SpringApplication.run(GrpcServerApp.class, args);
    }
}
