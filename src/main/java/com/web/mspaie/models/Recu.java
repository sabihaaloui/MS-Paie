/**
 * 
 */
package com.web.mspaie.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author thoma
 *
 */
@Entity
@Table(name = "recus")
public class Recu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonBackReference(value = "etudiant")
	@ManyToOne
	private Etudiant etudiant;
	@JsonBackReference(value = "parent")
	@ManyToOne
	private Parent parent;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payement_id", nullable = false)
    private Payement payement;
	@JsonBackReference(value = "tiers")
	@ManyToOne
	private Tiers tiers;
	
}
