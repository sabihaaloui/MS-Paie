package com.web.mspaie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Etudiant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}