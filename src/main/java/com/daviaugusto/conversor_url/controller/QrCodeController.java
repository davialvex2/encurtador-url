package com.daviaugusto.conversor_url.controller;

import com.daviaugusto.conversor_url.client.QrCodeClient;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {


    @Autowired
    public QrCodeClient qrCodeClien;

    @PostMapping
    public ResponseEntity<byte[]> gerarQrcode(@RequestParam("url") String url){
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(qrCodeClien.gerarQrcode(url));
    }

}
