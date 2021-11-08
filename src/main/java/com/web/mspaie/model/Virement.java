/**
 * 
 */
package com.web.mspaie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author thoma
 *
 */
@Entity
@Table(name = "virements")
public class Virement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
