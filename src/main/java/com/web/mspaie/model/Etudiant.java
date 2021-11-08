package com.web.mspaie.model;

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
public class Etudiant {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String lieuNaissance;
	private String adresse;
	private int telephone;
	private String nomPere;
	private String nomMere;
	private String fonctionPere;
	private String fonctionMere;
	private int gsm;
	private String ecolePrecedant;
	private String classePrecedant;
	@Column(nullable = true, length = 64)
    private String photos;
	private int matricule;
	
	
	@JsonBackReference(value = "classe")
	@ManyToOne
	private Classe classe;
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "etudiant")
    private Inscription inscription;
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "etudiant")
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

	public Etudiant(Long id, String nom, String prenom, Date dateNaissance, String lieuNaissance, String adresse,
			int telephone, String nomPere, String nomMere, String fonctionPere, String fonctionMere, int gsm,
			String ecolePrecedant, String classePrecedant, String photos, int matricule, Classe classe,
			Inscription inscription, ReInscription reinscription, Parent parent, Tiers tiers, List<Facture> factures,
			List<Recu> recus) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.nomPere = nomPere;
		this.nomMere = nomMere;
		this.fonctionPere = fonctionPere;
		this.fonctionMere = fonctionMere;
		this.gsm = gsm;
		this.ecolePrecedant = ecolePrecedant;
		this.classePrecedant = classePrecedant;
		this.photos = photos;
		this.matricule = matricule;
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

	public String getNomPere() {
		return nomPere;
	}

	public void setNomPere(String nomPere) {
		this.nomPere = nomPere;
	}

	public String getNomMere() {
		return nomMere;
	}

	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}

	public String getFonctionPere() {
		return fonctionPere;
	}

	public void setFonctionPere(String fonctionPere) {
		this.fonctionPere = fonctionPere;
	}

	public String getFonctionMere() {
		return fonctionMere;
	}

	public void setFonctionMere(String fonctionMere) {
		this.fonctionMere = fonctionMere;
	}

	public int getGsm() {
		return gsm;
	}

	public void setGsm(int gsm) {
		this.gsm = gsm;
	}

	public String getEcolePrecedant() {
		return ecolePrecedant;
	}

	public void setEcolePrecedant(String ecolePrecedant) {
		this.ecolePrecedant = ecolePrecedant;
	}

	public String getClassePrecedant() {
		return classePrecedant;
	}

	public void setClassePrecedant(String classePrecedant) {
		this.classePrecedant = classePrecedant;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
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

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", lieuNaissance=" + lieuNaissance + ", adresse=" + adresse + ", telephone=" + telephone
				+ ", nomPere=" + nomPere + ", nomMere=" + nomMere + ", fonctionPere=" + fonctionPere + ", fonctionMere="
				+ fonctionMere + ", gsm=" + gsm + ", ecolePrecedant=" + ecolePrecedant + ", classePrecedant="
				+ classePrecedant + ", photos=" + photos + ", matricule=" + matricule + ", classe=" + classe
				+ ", inscription=" + inscription + ", reinscription=" + reinscription + ", parent=" + parent
				+ ", tiers=" + tiers + ", factures=" + factures + ", recus=" + recus + "]";
	}

	
	

}
