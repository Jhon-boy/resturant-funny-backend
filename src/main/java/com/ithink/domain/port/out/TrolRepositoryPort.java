package com.ithink.domain.port.out;

import com.ithink.domain.model.Trol;

import java.util.Optional;

/**
 * Output port for Trol data access
 * Defines the operations that the domain needs from the repository
 */
public interface TrolRepositoryPort {
    /**
     * Saves a Trol in the repository
     */
    Trol save(Trol trol);
    
    /**
     * Finds a Trol by its ID
     */
    Optional<Trol> findById(Long idRol);
    
    /**
     * Finds a Trol by its code
     */
    Optional<Trol> findByCodigo(String codigo);
}
