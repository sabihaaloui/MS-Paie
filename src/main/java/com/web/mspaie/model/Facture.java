package com.web.mspaie.model;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Table(name = "factures")
public class Facture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
	
}
