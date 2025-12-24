package com.ithink.infra.repository;

import com.ithink.infra.entity.TrolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * JPA Repository for TROL entity database access
 */
@Repository
public interface TrolRepository extends JpaRepository<TrolEntity, Long> {
	@Query(value = "SELECT * FROM public.\"TROL\"", nativeQuery = true)
	List<TrolEntity> findAll();
    Optional<TrolEntity> findByCodigo(String codigo);

    Optional<TrolEntity> findByEstado(String estado);

}
