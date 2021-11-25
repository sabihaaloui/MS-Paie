/**
 * 
 */
package com.web.mspaie.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.web.mspaie.models.Service;

/**
 * @author thoma
 *
 */
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	Page<Service> findByNiveauId(Long niveauId, Pageable pageable);
    Optional<Service> findByIdAndNiveauId(Long id, Long niveauId);

}
