/**
 * 
 */
package com.web.mspaie.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.mspaie.model.Classe;
import com.web.mspaie.model.Etudiant;

/**
 * @author thoma
 *
 */
@Repository
public interface EtudiantRepository  extends JpaRepository<Etudiant, Long>{
	Page<Etudiant> findByClasseId(Long classeId, Pageable pageable);
    Optional<Etudiant> findByIdAndClasseId(Long id, Long classeId);
	

}
