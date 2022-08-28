package cn.beckbi.client;

import cn.beckbi.pb.AdInfo;
import cn.beckbi.pb.AdStreamGrpc;
import com.alibaba.fastjson2.JSON;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-08-27 23:56
 */
public class AdClient {

    private static final Logger logger = Logger.getLogger(AdClient.class.getName());

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 11112)
                .usePlaintext()
                .build();
        AdStreamGrpc.AdStreamBlockingStub stub = AdStreamGrpc.newBlockingStub(channel);
        AdStreamGrpc.AdStreamStub asyncStub = AdStreamGrpc.newStub(channel);

        //create ad in list
        AdInfo.AdIdList adIdList = createAdList(asyncStub);
        logger.info("result:"+ adIdList.toString());




        List<AdInfo.AdList> adListList = getAdList(stub, adIdList);
        logger.info("adListList:"+ adListList.toString());


        channel.shutdown();
    }

    public static List<AdInfo.AdList> getAdList(AdStreamGrpc.AdStreamBlockingStub stub, AdInfo.AdIdList adIdList) {

        List<AdInfo.AdList> adListList = new ArrayList<>();

        Iterator<AdInfo.AdList> iterator = stub.getAdList(adIdList);
        while (iterator.hasNext()) {
            AdInfo.AdList adList = iterator.next();
            adListList.add(adList);
        }
        return adListList;
    }

    public static AdInfo.AdIdList createAdList(AdStreamGrpc.AdStreamStub asyncStub ) {

        List<Integer> allIdList = new ArrayList<>(30);

        
        AdInfo.Ad ad1 = AdInfo.Ad.newBuilder()
                .setName("cpl1")
                .setDescription("cpl ad")
                .setPrice(11.21f)
                .build();
        AdInfo.Ad ad2 = AdInfo.Ad.newBuilder()
                .setName("cp21")
                .setDescription("cpl ad")
                .setPrice(21.21f)
                .build();
        AdInfo.Ad ad3 = AdInfo.Ad.newBuilder()
                .setName("cpl3")
                .setDescription("cpl ad")
                .setPrice(31.21f)
                .build();
        AdInfo.Ad ad4 = AdInfo.Ad.newBuilder()
                .setName("cpl1")
                .setDescription("cpl ad")
                .setPrice(41.21f)
                .build();
        AdInfo.Ad ad5 = AdInfo.Ad.newBuilder()
                .setName("cpl1")
                .setDescription("cpl ad")
                .setPrice(51.21f)
                .build();


        final CountDownLatch countDownLatch = new CountDownLatch(1);

        StreamObserver<AdInfo.AdIdList> adIdListStreamObserver = new StreamObserver<AdInfo.AdIdList>() {
            @Override
            public void onNext(AdInfo.AdIdList adIdList) {
                adIdList.getIdList().stream().forEach(
                        id ->   {
                            logger.info("create ad success : " + id);
                            allIdList.add(id);
                        });
            }

            @Override
            public void onError(Throwable t) {
                logger.info("error:"+t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("create success");
                countDownLatch.countDown();
            }
        };

        StreamObserver<AdInfo.AdList> createAdObserver = asyncStub.addAdList(adIdListStreamObserver);

        AdInfo.AdList adList1 = AdInfo.AdList.newBuilder()
                .addAds(ad1)
                .addAds(ad2)
                .addAds(ad3)
                .addAds(ad4)
                .addAds(ad5)
                .setTraceId("a")
                .setCreateAt("2022-01-01 01:01:01")
                .build();

        AdInfo.AdList adList2 = AdInfo.AdList.newBuilder()
                .addAds(ad1)
                .addAds(ad2)
                .addAds(ad3)
                .addAds(ad4)
                .addAds(ad5)
                .setTraceId("b")
                .setCreateAt("2022-02-02 01:01:01")
                .build();

        AdInfo.AdList adList3 = AdInfo.AdList.newBuilder()
                .addAds(ad1)
                .addAds(ad2)
                .addAds(ad3)
                .addAds(ad4)
                .addAds(ad5)
                .setTraceId("c")
                .setCreateAt("2022-03-03 01:01:01")
                .build();
        createAdObserver.onNext(adList1);
        createAdObserver.onNext(adList2);
        createAdObserver.onNext(adList3);

        if (countDownLatch.getCount() == 0) {
            logger.warning("rpc error");
            return null;
        }
        createAdObserver.onCompleted();


        try {
            if (!countDownLatch.await(10, TimeUnit.SECONDS)) {
                logger.warning("failed after 10 seconds");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return AdInfo.AdIdList.newBuilder().addAllId(allIdList).build();
    }
}
