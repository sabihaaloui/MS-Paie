/**
 * 
 */
package com.web.mspaie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.mspaie.models.Parent;

/**
 * @author thoma
 *
 */
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

	//S save(Parent parent);

}
