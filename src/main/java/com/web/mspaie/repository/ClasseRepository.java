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
import com.web.mspaie.model.Niveau;


/**
 * @author thoma
 *
 */
@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
	Page<Classe> findByNiveauId(Long niveauId, Pageable pageable);
    Optional<Classe> findByIdAndNiveauId(Long id, Long niveauId);
	static void save(Niveau niveau) {
		// TODO Auto-generated method stub
		
	}
}
