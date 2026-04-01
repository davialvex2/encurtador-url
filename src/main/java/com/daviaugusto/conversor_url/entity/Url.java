package com.daviaugusto.conversor_url.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String urlLonga;
    private String urlCurta;
    private Integer contador;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime horarioExpiracao;


    public Url() {
    }

    public Url(Long id, String urlLonga, String urlCurta, Integer contador, LocalDateTime horarioExpiracao) {
        this.id = id;
        this.urlLonga = urlLonga;
        this.urlCurta = urlCurta;
        this.contador = contador;
        this.horarioExpiracao = horarioExpiracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLonga() {
        return urlLonga;
    }

    public void setUrlLonga(String urlLonga) {
        this.urlLonga = urlLonga;
    }

    public String getUrlCurta() {
        return urlCurta;
    }

    public void setUrlCurta(String urlCurta) {
        this.urlCurta = urlCurta;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public LocalDateTime getHorarioExpiracao() {
        return horarioExpiracao;
    }

    public void setHorarioExpiracao(LocalDateTime horarioExpiracao) {
        this.horarioExpiracao = horarioExpiracao;
    }
}
