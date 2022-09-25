package cn.beckbi.interceptor;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.stereotype.Service;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-25 17:31
 */
@GrpcGlobalClientInterceptor
@Service
@Slf4j
public class LogInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        log.info("global .... LogInterceptor"+method.getFullMethodName());

        return next.newCall(method, callOptions);
    }
}
