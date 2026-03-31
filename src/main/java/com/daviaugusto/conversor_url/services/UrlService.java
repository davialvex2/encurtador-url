package com.daviaugusto.conversor_url.services;

import com.daviaugusto.conversor_url.entity.Url;
import com.daviaugusto.conversor_url.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;




    public String salvarUrl(String urlLonga){
        Url url = new Url();
        url.setUrlLonga(urlLonga);
        String urlCriada = logicaUrlCurta();
        while(urlRepository.existsByUrlCurta(urlCriada)){
            urlCriada = logicaUrlCurta();
        }
        url.setUrlCurta(urlCriada);
        urlRepository.save(url);
        return url.getUrlCurta();
    }


    public String logicaUrlCurta(){

        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUWXYZ124567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<10; i++){
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }


}
