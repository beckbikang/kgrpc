package cn.beckbi.server;

import cn.beckbi.pb.AdInfo;
import cn.beckbi.pb.AdStreamGrpc;

import java.util.*;
import java.util.logging.Logger;


import io.grpc.stub.StreamObserver;


/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-08-28 08:02
 */
public class AdStreamGrpcImpl extends AdStreamGrpc.AdStreamImplBase {

    private static final Logger logger = Logger.getLogger(AdStreamGrpcImpl.class.getName());

    private final Random random = new Random();

    private final Map<Integer, AdInfo.Ad> adInfoMap = new HashMap<>(50);

    @Override
    public io.grpc.stub.StreamObserver<AdInfo.AdList> addAdList(
            io.grpc.stub.StreamObserver<AdInfo.AdIdList> responseObserver) {

        return new StreamObserver<AdInfo.AdList>() {

            private AdInfo.AdIdList adIdList = AdInfo.AdIdList.newBuilder().build();

            @Override
            public void onNext(AdInfo.AdList value) {
                if (value != null) {
                    logger.info("time:"+value.getCreateAt());
                    logger.info("traceId:"+value.getTraceId());
                    List<AdInfo.Ad> adList = value.getAdsList();
                    adList.stream().forEach( adInfo -> {
                        int id = random.nextInt(100000000);
                        AdInfo.Ad ad = AdInfo.Ad.newBuilder()
                                .setId(id)
                                .setName(adInfo.getName())
                                .setPrice(adInfo.getPrice())
                                .setDescription(adInfo.getDescription())
                                .build();
                        adInfoMap.put(id, ad);
                        adIdList = adIdList.toBuilder().addId(id).build();
                        logger.info("create ad success : " + id );
                    });
                }
            }

            @Override
            public void onError(Throwable t) {
                logger.info("ad create error " + t.getMessage());
            }
            @Override
            public void onCompleted() {
                logger.info("create  ad  success");
                responseObserver.onNext(adIdList);
                responseObserver.onCompleted();
            }
        };
    }


    @Override
    public void getAdList(AdInfo.AdIdList request,
                          io.grpc.stub.StreamObserver<AdInfo.AdList> responseObserver) {

        List<AdInfo.Ad> adList = new ArrayList<>(30);

        logger.info("request:"+request.getIdList().toString());
        request.getIdList().forEach( id ->
            {
                if (adInfoMap.containsKey(id)) {
                    adList.add(adInfoMap.get(id));
                    logger.info( "result:"+adInfoMap.get(id).toString());
                }
            }
        );
        logger.info("ad list"+adList.toString());
        responseObserver.onNext(AdInfo.AdList.newBuilder().addAllAds(adList).build());
        responseObserver.onCompleted();
    }

}
