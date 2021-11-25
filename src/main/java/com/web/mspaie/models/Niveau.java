/**
 * 
 */
package com.web.mspaie.models;

import java.io.Serializable;
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
public class Niveau  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private int anneeScolaire;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "niveau")
	private List<Service> services;
	public Niveau() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Niveau(Long id, String libelle, int anneeScolaire, List<Service> services) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.anneeScolaire = anneeScolaire;
		this.services = services;
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
	
	
	
	
}
