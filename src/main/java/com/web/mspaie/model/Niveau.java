/**
 * 
 */
package com.web.mspaie.model;

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

/**
 * @author thoma
 *
 */
@Entity
@Table(name = "niveaux")
public class Niveau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private int anneeScolaire;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "niveau")
	private List<Service> services;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "niveau")
	private List<Classe> classes;
	public Niveau() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Niveau(Long id, String libelle, int anneeScolaire, List<Service> services, List<Classe> classes) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.anneeScolaire = anneeScolaire;
		this.services = services;
		this.classes = classes;
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
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "Niveau [id=" + id + ", libelle=" + libelle + ", anneeScolaire=" + anneeScolaire + ", services="
				+ services + ", classes=" + classes + "]";
	}
	
}
