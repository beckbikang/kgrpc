package cn.beckbi.controller;

import cn.beckbi.pb.AdInfo;
import cn.beckbi.service.GrpcClientService;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-09-20 23:12
 */
@Slf4j
@RestController
public class ApiController {
    @Autowired
    private GrpcClientService grpcClientService;

    @GetMapping("/ok")
    public String info() {
        return "ok";
    }

    @Builder
    @Data
    static class AdX {
        private Integer id;
        private String name;
        private String desc;
        private Float price;

    }

    @GetMapping("/ad")
    public AdX createAd(@RequestParam("name") String name) {


        AdInfo.Ad adInfo = grpcClientService.createAd(name);
        return AdX.builder()
                .id(adInfo.getId())
                .name(adInfo.getName())
                .desc(adInfo.getDescription())
                .price(adInfo.getPrice())
                .build();
    }

    @GetMapping("/ad/{id}")
    public AdX createAd(@PathVariable("id") Integer id) {

        AdInfo.Ad adInfo = grpcClientService.getById(id);
        return AdX.builder()
                .id(adInfo.getId())
                .name(adInfo.getName())
                .desc(adInfo.getDescription())
                .price(adInfo.getPrice())
                .build();
    }


}
