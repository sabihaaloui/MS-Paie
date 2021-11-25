/**
 * 
 */
package com.web.mspaie.models;

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
@Table(name = "lettrages")
public class Lettrage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
