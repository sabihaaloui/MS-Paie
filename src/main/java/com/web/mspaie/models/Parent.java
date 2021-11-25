package com.web.mspaie.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "parents")
public class Parent implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String lieuNaissance;
	private String adresse;
	private int telephone;
	private String fonction;
	private int cni;
	private String mail;
	private int gsm;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Inscription> inscriptions;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<ReInscription> reInscriptions;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Facture> factures;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Payement> payements;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Etudiant> etudiants;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Recu> recus;
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parent(Long id, String nom, String prenom, Date dateNaissance, String lieuNaissance, String adresse,
			int telephone, String fonction, int cni, String mail, int gsm, List<Inscription> inscriptions,
			List<ReInscription> reInscriptions, List<Facture> factures, List<Payement> payements,
			List<Etudiant> etudiants, List<Recu> recus) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fonction = fonction;
		this.cni = cni;
		this.mail = mail;
		this.gsm = gsm;
		this.inscriptions = inscriptions;
		this.reInscriptions = reInscriptions;
		this.factures = factures;
		this.payements = payements;
		this.etudiants = etudiants;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public int getCni() {
		return cni;
	}
	public void setCni(int cni) {
		this.cni = cni;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getGsm() {
		return gsm;
	}
	public void setGsm(int gsm) {
		this.gsm = gsm;
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
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public List<Payement> getPayements() {
		return payements;
	}
	public void setPayements(List<Payement> payements) {
		this.payements = payements;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public List<Recu> getRecus() {
		return recus;
	}
	public void setRecus(List<Recu> recus) {
		this.recus = recus;
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", lieuNaissance=" + lieuNaissance + ", adresse=" + adresse + ", telephone=" + telephone
				+ ", fonction=" + fonction + ", cni=" + cni + ", mail=" + mail + ", gsm=" + gsm + ", inscriptions="
				+ inscriptions + ", reInscriptions=" + reInscriptions + ", factures=" + factures + ", payements="
				+ payements + ", etudiants=" + etudiants + ", recus=" + recus + "]";
	}
	
	
	
	

}
