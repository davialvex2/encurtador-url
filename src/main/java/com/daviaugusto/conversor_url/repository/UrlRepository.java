package com.daviaugusto.conversor_url.repository;

import com.daviaugusto.conversor_url.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {

    Url findByUrlLonga(String url);

}
