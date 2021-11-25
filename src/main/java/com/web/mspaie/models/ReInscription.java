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
@Table(name = "re_inscriptions")
public class ReInscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonBackReference(value = "classe")
	@ManyToOne
	private Classe classe;
	@JsonBackReference(value = "parent")
	@ManyToOne
	private Parent parent;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant;
}
