package cn.beckbi.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.stereotype.Component;



import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;
/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-25 19:53
 */
@GrpcGlobalServerInterceptor
@Component
@Slf4j
public class MDInterceptor implements io.grpc.ServerInterceptor {


    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata metadata, ServerCallHandler<ReqT, RespT> next) {

        String retMd = metadata.get(Metadata.Key.of("META1", ASCII_STRING_MARSHALLER));
        log.info("Metadata Retrived : " + retMd);
        return next.startCall(call, metadata);
    }
}

