/**
 * 
 */
package com.web.mspaie.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.mspaie.models.Etudiant;
import com.web.mspaie.models.Inscription;

/**
 * @author thoma
 *
 */
@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long>{
	Page<Inscription> findByClasseId(Long classeId, Pageable pageable);
    Optional<Inscription> findByIdAndClasseId(Long id, Long classeId);
    
    
    
    Page<Inscription> findByEtudiantId(Long etudiantId, Pageable pageable);
    Optional<Inscription> findByIdAndEtudiantId(Long id, Long etudiantId);
	
	

}
