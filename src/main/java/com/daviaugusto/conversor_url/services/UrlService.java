package com.daviaugusto.conversor_url.services;

import com.daviaugusto.conversor_url.entity.Url;
import com.daviaugusto.conversor_url.exceptions.IllegalArgumentsException;
import com.daviaugusto.conversor_url.exceptions.ResourceNotFoundException;
import com.daviaugusto.conversor_url.repository.UrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;


@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private static final Logger logger = LoggerFactory.getLogger(UrlService.class);


    public String buscarUrlLonga(String urlCurta){
        Url url = urlRepository.findByUrlCurta(urlCurta).orElseThrow(
                () -> new ResourceNotFoundException("Url não encontrada"));
        if(url.getHorarioExpiracao().isBefore(LocalDateTime.now())){
            urlRepository.delete(url);
            throw  new ResourceNotFoundException("Url expirada");
        }
        else {
            url.setContador(url.getContador() + 1);
            urlRepository.save(url);
            return url.getUrlLonga();
        }
    }

    public Integer buscarQuantidadeContador(String url){
        Url urlEntity = urlRepository.findByUrlLonga(url).orElseThrow(
                () -> new ResourceNotFoundException("Url não encontrada"));

        return urlEntity.getContador();
    }



    public String salvarUrl(String urlLonga){
        if(!urlLonga.startsWith("http://") && !urlLonga.startsWith("https://")){
            throw new IllegalArgumentsException("A url digitada não é valida, tente algo como (http://exemplo.com)");
        }
        Url url = new Url();
        url.setUrlLonga(urlLonga);
        String urlCriada = logicaUrlCurta();
        while(urlRepository.existsByUrlCurta(urlCriada)){
            urlCriada = logicaUrlCurta();
        }
        url.setUrlCurta(urlCriada);
        url.setContador(0);
        url.setHorarioExpiracao(LocalDateTime.now().plusMinutes(2));
        urlRepository.save(url);
        return "http://localhost:8080/url/" + url.getUrlCurta();
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


    @Scheduled(cron = "${cron.horario}")
    public void detelarUrlExpiradas(){
        urlRepository.deleteByHorarioExpiracaoBefore(LocalDateTime.now());
        logger.info("Url(s) apagada(s)");
    }



}
