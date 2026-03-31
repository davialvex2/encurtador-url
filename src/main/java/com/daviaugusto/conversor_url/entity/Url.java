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
    private Integer contador;


    public Url() {
    }

    public Url(Long id, String urlLonga, Integer contador) {
        this.id = id;

        this.urlLonga = urlLonga;
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

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }
}
