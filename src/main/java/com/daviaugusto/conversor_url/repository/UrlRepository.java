package com.daviaugusto.conversor_url.repository;

import com.daviaugusto.conversor_url.entity.Url;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {

    Optional<Url> findByUrlCurta(String url);

    Optional<Url> findByUrlLonga(String url);

    boolean existsByUrlCurta(String url);

    @Transactional
    void deleteByHorarioExpiracaoBefore(LocalDateTime horario);



}
