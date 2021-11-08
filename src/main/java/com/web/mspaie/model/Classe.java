package com.web.mspaie.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "classes")
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private int anneeScolaire;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "niveau_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Niveau niveau;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classe")
	private List<Inscription> inscriptions;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classe")
	private List<ReInscription> reInscriptions;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classe")
	private List<Etudiant> etudiants;
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classe(Long id, String libelle, int anneeScolaire, Niveau niveau, List<Inscription> inscriptions,
			List<ReInscription> reInscriptions, List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.anneeScolaire = anneeScolaire;
		this.niveau = niveau;
		this.inscriptions = inscriptions;
		this.reInscriptions = reInscriptions;
		this.etudiants = etudiants;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getAnneeScolaire() {
		return anneeScolaire;
	}
	public void setAnneeScolaire(int anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public List<ReInscription> getReInscriptions() {
		return reInscriptions;
	}
	public void setReInscriptions(List<ReInscription> reInscriptions) {
		this.reInscriptions = reInscriptions;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	@Override
	public String toString() {
		return "Classe [id=" + id + ", libelle=" + libelle + ", anneeScolaire=" + anneeScolaire + ", niveau=" + niveau
				+ ", inscriptions=" + inscriptions + ", reInscriptions=" + reInscriptions + ", etudiants=" + etudiants
				+ "]";
	}

	

}
