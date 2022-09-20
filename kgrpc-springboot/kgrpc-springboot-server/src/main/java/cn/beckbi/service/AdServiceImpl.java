package cn.beckbi.service;

import cn.beckbi.pb.AdInfo;
import cn.beckbi.pb.AdRpcGrpc;
import io.grpc.Status;
import io.grpc.StatusException;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-20 23:02
 */
@GrpcService
public class AdServiceImpl extends AdRpcGrpc.AdRpcImplBase  {

    private static final Logger logger = Logger.getLogger(AdServiceImpl.class.getName());

    private final Random random = new Random();

    private final Map<Integer, AdInfo.Ad> adInfoMap = new HashMap<>(50);

    @Override
    public void addAd(cn.beckbi.pb.AdInfo.Ad request,
                      io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdId> responseObserver) {
        int id = random.nextInt(100000000);



        logger.info("id:"+id);

        request = request.toBuilder().setId(id).build();
        adInfoMap.put(id, request);
        AdInfo.AdId adId = AdInfo.AdId.newBuilder().setId(id).build();
        responseObserver.onNext(adId);
        responseObserver.onCompleted();
    }

    @Override
    public void getAd(cn.beckbi.pb.AdInfo.AdId request,
                      io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.Ad> responseObserver) {
        int id = request.getId();

        logger.info("id:"+id);

        if (adInfoMap.containsKey(id)) {
            responseObserver.onNext((AdInfo.Ad) adInfoMap.get(id));
            responseObserver.onCompleted();
        }else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }

    }
}
