package cn.beckbi.config;

import cn.beckbi.interceptor.LogInterceptor;
import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GlobalServerInterceptorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-25 17:34
 */
@Configuration
public class InterceptorConfiguration {

    @Bean
    public GlobalServerInterceptorConfigurer globalInterceptorConfigurerAdapter() {

        return new GlobalServerInterceptorConfigurer() {
            @Override
            public void configureServerInterceptors(List<ServerInterceptor> list) {
                list.add(new LogInterceptor());
            }
        };

    }
}
