package com.daviaugusto.conversor_url.controller;

import com.daviaugusto.conversor_url.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlController {


    @Autowired
    private UrlService urlService;


    @PostMapping("/{urlLonga}")
    public ResponseEntity<String> criarUrlCurta(@PathVariable String urlLonga){
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.salvarUrl(urlLonga));
    }



}
