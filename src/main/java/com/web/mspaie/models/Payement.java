package com.web.mspaie.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "payements")
public class Payement  implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 private LocalDate datePayement;
	 private Double montant;
	 private String banque;
	 private String type;
	 
	
	
	@JsonBackReference(value = "service")
	@ManyToOne
	private Service service;
	@JsonBackReference(value = "parent")
	@ManyToOne
	private Parent parent;
	@JsonBackReference(value = "tiers")
	@ManyToOne
	private Tiers tiers;
	@JsonBackReference(value = "facture")
	@ManyToOne
	private Facture facture;
	@JsonBackReference(value = "etudiant")
	@ManyToOne
	private Etudiant etudiant;
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "payement")
    private Recu recu;


    

}
