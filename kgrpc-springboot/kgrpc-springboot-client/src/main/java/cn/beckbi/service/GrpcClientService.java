package cn.beckbi.service;

import cn.beckbi.constants.ServerSupplier;
import cn.beckbi.interceptor.Log2Interceptor;
import cn.beckbi.interceptor.Log3Interceptor;
import cn.beckbi.pb.AdInfo;
import cn.beckbi.pb.AdRpcGrpc;
import io.grpc.Deadline;
import io.grpc.Metadata;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import io.grpc.Channel;

import java.util.concurrent.TimeUnit;


/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-20 23:15
 */
@Slf4j
@Service
public class GrpcClientService {

    @Autowired
    private Log2Interceptor log2Interceptor;

    @Autowired
    private Log3Interceptor log3Interceptor;

    @GrpcClient(ServerSupplier.PRODUCER_NAME)
    private Channel serverChannel;

    public synchronized AdInfo.Ad  createAd(String name) {
        AdRpcGrpc.AdRpcBlockingStub stub = AdRpcGrpc.newBlockingStub(serverChannel);

        AdInfo.Ad  adInfo = AdInfo.Ad.newBuilder()
                .setName(name)
                .setDescription("ad description")
                .setPrice(31.21f)
                .build();


        AdInfo.AdId adId = stub
                .withDeadline(Deadline.after(300, TimeUnit.MILLISECONDS))
                .withInterceptors(log3Interceptor)
                .addAd(adInfo);

        log.info("set ad "+ adId.getId()+" add success !");
        AdInfo.Ad  result = AdInfo.Ad.newBuilder()
                .setName(name)
                .setDescription("ad description")
                .setPrice(31.21f)
                .setId(adId.getId())
                .build();
        return result;
    }

    public synchronized AdInfo.Ad getById(int id) {
        AdRpcGrpc.AdRpcBlockingStub stub = AdRpcGrpc.newBlockingStub(serverChannel);
        AdInfo.AdId adId = AdInfo.AdId.newBuilder().setId(id).build();
        AdInfo.Ad ad = stub
                .withDeadline(Deadline.after(100, TimeUnit.MILLISECONDS))
                .withInterceptors(log2Interceptor, log3Interceptor)
                .getAd(adId);
        log.info("Ad: " + ad.toString());
        return ad;
    }
}
