package com.ithink.infra.repository;

import com.ithink.infra.entity.TrolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA Repository for TROL entity database access
 */
@Repository
public interface TrolRepository extends JpaRepository<TrolEntity, Long> {
    Optional<TrolEntity> findByCodigo(String codigo);

    Optional<TrolEntity> findByEstado(String estado);

}
