package com.daviaugusto.conversor_url.repository;

import com.daviaugusto.conversor_url.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {

    Optional<Url> findByUrlCurta(String url);

    Optional<Url> findByUrlLonga(String url);

    boolean existsByUrlCurta(String url);



}
