package cn.beckbi.interceptor;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.stereotype.Service;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-25 17:31
 */
@Service
@Slf4j
//@GrpcGlobalServerInterceptor
public class GlobalInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {

        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(serverCallHandler.startCall(serverCall, metadata)) {

            private long start = 0;
            private ReqT request;

            @Override
            public void onComplete() {
                //记录请求参数及耗时
                System.out.println("const:" + (System.nanoTime() - start)/1000000 +"ms");
                System.out.println("process param: " + request.toString());
                super.onComplete();
            }

            @Override
            public void onMessage(ReqT message) {
                start = System.nanoTime();
                request = message;
            }

        };
    }
}
