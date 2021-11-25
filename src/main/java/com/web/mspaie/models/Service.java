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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



/**
 * @author thoma
 *
 */
@Entity
@Table(name = "services")
public class Service  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private int cout;
	@JsonBackReference(value = "niveau")
	@ManyToOne
	private Niveau niveau;

	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "service")
	private List<Payement> payements;


	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Service(Long id, String libelle, int cout, Niveau niveau, List<Payement> payements) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.cout = cout;
		this.niveau = niveau;
		this.payements = payements;
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


	public int getCout() {
		return cout;
	}


	public void setCout(int cout) {
		this.cout = cout;
	}


	public Niveau getNiveau() {
		return niveau;
	}


	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}


	public List<Payement> getPayements() {
		return payements;
	}


	public void setPayements(List<Payement> payements) {
		this.payements = payements;
	}


	@Override
	public String toString() {
		return "Service [id=" + id + ", libelle=" + libelle + ", cout=" + cout + ", niveau=" + niveau + ", payements="
				+ payements + "]";
	}
	
	


	
	
	

}
