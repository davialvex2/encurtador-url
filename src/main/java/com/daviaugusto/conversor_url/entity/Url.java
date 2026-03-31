package com.daviaugusto.conversor_url.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String urlLonga;
    private String urlCurta;
    private Integer contador;


    public Url() {
    }

    public Url(Long id, String urlLonga, String urlCurta, Integer contador) {
        this.id = id;
        this.urlLonga = urlLonga;
        this.urlCurta = urlCurta;
        this.contador = contador;
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
}
