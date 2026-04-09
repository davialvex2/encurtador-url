package com.daviaugusto.conversor_url.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "qrcode", url = "${url.qrcode}")
public interface QrCodeClient {


    @PostMapping("/?size=150x150&data={url}")
    byte[] gerarQrcode(@RequestParam("url") String url);

}
