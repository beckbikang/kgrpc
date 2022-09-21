package cn.beckbi.service;

import cn.beckbi.constants.ServerSupplier;
import cn.beckbi.pb.AdInfo;
import cn.beckbi.pb.AdRpcGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;


import io.grpc.Channel;


/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-20 23:15
 */
@Slf4j
@Service
public class GrpcClientService {

    @GrpcClient(ServerSupplier.PRODUCER_NAME)
    private Channel serverChannel;

    public AdInfo.Ad  createAd(String name) {
        AdRpcGrpc.AdRpcBlockingStub stub = AdRpcGrpc.newBlockingStub(serverChannel);
        AdInfo.AdId adId = stub.addAd(AdInfo.Ad.newBuilder()
                .setName(name)
                .setDescription("ad description")
                .setPrice(31.21f)
                .build());
        log.info("set ad "+ adId.getId()+" add success !");
        AdInfo.Ad ad = stub.getAd(adId);
        log.info("Ad: " + ad.toString());
        return ad;
    }
}
