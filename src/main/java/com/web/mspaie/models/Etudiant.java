package com.web.mspaie.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "etudiants")
public class Etudiant  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String lieuNaissance;
	private String sexe;

	private String ecolePrecedant;
	private String email;
	private String adresse;

	@JsonBackReference(value = "classe")
	@ManyToOne
	private Classe classe;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "etudiant")
	private Inscription inscription;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "etudiant")
	private ReInscription reinscription;
	@JsonBackReference(value = "parent")
	@ManyToOne
	private Parent parent;
	@JsonBackReference(value = "tiers")
	@ManyToOne
	private Tiers tiers;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etudiant")
	private List<Facture> factures;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etudiant")
	private List<Recu> recus;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Etudiant(Long id, String nom, String prenom, Date dateNaissance, String lieuNaissance, String sexe,
			String ecolePrecedant, String email, String adresse, Classe classe, Inscription inscription,
			ReInscription reinscription, Parent parent, Tiers tiers, List<Facture> factures, List<Recu> recus) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.ecolePrecedant = ecolePrecedant;
		this.email = email;
		this.adresse = adresse;
		this.classe = classe;
		this.inscription = inscription;
		this.reinscription = reinscription;
		this.parent = parent;
		this.tiers = tiers;
		this.factures = factures;
		this.recus = recus;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEcolePrecedant() {
		return ecolePrecedant;
	}

	public void setEcolePrecedant(String ecolePrecedant) {
		this.ecolePrecedant = ecolePrecedant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	public ReInscription getReinscription() {
		return reinscription;
	}

	public void setReinscription(ReInscription reinscription) {
		this.reinscription = reinscription;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Tiers getTiers() {
		return tiers;
	}

	public void setTiers(Tiers tiers) {
		this.tiers = tiers;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<Recu> getRecus() {
		return recus;
	}

	public void setRecus(List<Recu> recus) {
		this.recus = recus;
	}
	

}
