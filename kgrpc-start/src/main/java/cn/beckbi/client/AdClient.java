package cn.beckbi.client;

import cn.beckbi.pb.AdInfo;
import cn.beckbi.pb.AdRpcGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Objects;
import java.util.logging.Logger;

import java.io.File;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;

import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.SslContext;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-08-27 23:56
 */
public class AdClient {

    private static final Logger logger = Logger.getLogger(AdClient.class.getName());

    public static void main(String[] args) throws Exception {

        String rootDir = Objects.requireNonNull(AdClient.class.getClassLoader().getResource("")).getPath();

        File certFile = Paths.get( rootDir+"server.crt").toFile();



        SslContext sslContext = GrpcSslContexts.forClient().trustManager(certFile).build();
        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 11111)
                .useTransportSecurity()
                .sslContext(sslContext)
                .build();

        AdRpcGrpc.AdRpcBlockingStub stub = AdRpcGrpc.newBlockingStub(channel);
        AdInfo.AdId adId = stub.addAd(AdInfo.Ad.newBuilder()
                        .setName("cpl1")
                        .setDescription("cpl ad")
                        .setPrice(31.21f)
                        .build());
        logger.info("set ad "+ adId.getId()+" add success !");
        AdInfo.Ad ad = stub.getAd(adId);
        logger.info("Ad: " + ad.toString());
        channel.shutdown();


    }
}
