package com.daviaugusto.conversor_url.controller;

import com.daviaugusto.conversor_url.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/url")
public class UrlController {


    @Autowired
    private UrlService urlService;


    @PostMapping
    public ResponseEntity<String> criarUrlCurta(@RequestParam("urlLonga") String urlLonga){
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.salvarUrl(urlLonga));
    }

    @GetMapping("/{urlCurta}")
    public ResponseEntity<Void> buscarUrlLonga(@PathVariable String urlCurta){
        String url = urlService.buscarUrlLonga(urlCurta);
        URI uri = URI.create(url);
        return ResponseEntity.status(HttpStatus.FOUND).location(uri).build();

    }

    @GetMapping
    public ResponseEntity<String> buscarContagem(@RequestParam("url") String url){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Quantidade de vezes acessado: " + urlService.buscarQuantidadeContador(url));

    }



}
