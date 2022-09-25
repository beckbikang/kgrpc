package cn.beckbi.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import io.grpc.*;
import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-25 19:51
 */
@Slf4j
@Service
public class Log3Interceptor  implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel channel) {

        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                headers.put(Metadata.Key.of("META1", ASCII_STRING_MARSHALLER), "meta11111111");
                log.info("headers:{}", headers);
                super.start(responseListener, headers);
            }
        };
    }
}
