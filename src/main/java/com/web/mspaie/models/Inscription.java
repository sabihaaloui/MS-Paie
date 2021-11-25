/**
 * 
 */
package com.web.mspaie.models;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "inscriptions")
public class Inscription implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateInscription;
	private int montant;
	private int code;
	private String anneeScolaire;
	private String observation;

	@JsonBackReference(value = "classe")
	@ManyToOne
	private Classe classe;
	@JsonBackReference(value = "parent")
	@ManyToOne
	private Parent parent;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "etudiant_id", nullable = false)
	private Etudiant etudiant;

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inscription(Long id, Date dateInscription, int montant, int code, String anneeScolaire, String observation,
			Classe classe, Parent parent, Etudiant etudiant) {
		super();
		this.id = id;
		this.dateInscription = dateInscription;
		this.montant = montant;
		this.code = code;
		this.anneeScolaire = anneeScolaire;
		this.observation = observation;
		this.classe = classe;
		this.parent = parent;
		this.etudiant = etudiant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "Inscription [id=" + id + ", dateInscription=" + dateInscription + ", montant=" + montant + ", code="
				+ code + ", anneeScolaire=" + anneeScolaire + ", observation=" + observation + ", classe=" + classe
				+ ", parent=" + parent + ", etudiant=" + etudiant + "]";
	}

}
