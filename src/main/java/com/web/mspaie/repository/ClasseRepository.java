/**
 * 
 */
package com.web.mspaie.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.mspaie.models.Classe;
import com.web.mspaie.models.Niveau;


/**
 * @author thoma
 *
 */
@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
	
}
