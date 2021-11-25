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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Table(name = "factures")
public class Facture  implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFacture;
	private int prix;
	private double total;

	
	
	@JsonBackReference(value = "parent")
	@ManyToOne
	private Parent parent;
	@JsonBackReference(value = "tiers")
	@ManyToOne
	private Tiers tiers;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payement_id", nullable = false)
    private Payement payement;
	@JsonBackReference(value = "etudiant")
	@ManyToOne
	private Etudiant etudiant;

	  @ManyToOne
	  private User user;
	
	
}
