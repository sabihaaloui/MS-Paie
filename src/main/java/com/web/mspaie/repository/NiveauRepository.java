/**
 * 
 */
package com.web.mspaie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.mspaie.models.Niveau;

/**
 * @author thoma
 *
 */
@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {

}
