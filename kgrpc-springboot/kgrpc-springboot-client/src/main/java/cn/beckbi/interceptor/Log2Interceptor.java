package cn.beckbi.interceptor;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-25 17:31
 */
@Service
@Slf4j
public class Log2Interceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        log.info("private Log2Interceptor:"+method.getFullMethodName());
        return next.newCall(method, callOptions);
    }
}
