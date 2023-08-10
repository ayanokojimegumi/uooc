package com.edu.client;

import com.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-vod") //指定调用哪个模块，名称与被调用的服务名保持一致
@Component
public interface VodClient {
    @DeleteMapping("/eduvod/video/{id}")    //完整路径
    public R deleteVideo(@PathVariable("id") String id);
}
