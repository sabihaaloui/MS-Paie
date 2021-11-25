/**
 * 
 */
package com.web.mspaie.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.mspaie.exception.ResourceNotFoundException;

import com.web.mspaie.models.Parent;
import com.web.mspaie.repository.ParentRepository;

/**
 * @author thoma
 *
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/v6")
public class ParentController {
	@Autowired
	private ParentRepository parentRepository;

	@GetMapping("/parents")
	public Page<Parent> getAllNiveauxs(Pageable pageable) {
		return parentRepository.findAll(pageable);

	}

	@PostMapping("/parents")
	public Parent createParent(@Valid @RequestBody Parent parent) {
		return parentRepository.save(parent);
	}

	@PutMapping("/parents/{parentId}")
	public Parent updateParent(@PathVariable Long parentId, @Valid @RequestBody Parent parentRequest) {
		return parentRepository.findById(parentId).map(parent -> {
			// niveau.setLibelle(niveauRequest.getLibelle());
			// niveau.setAnneeScolaire(niveauRequest.getAnneeScolaire())
			parent.setNom(parentRequest.getNom());
			parent.setPrenom(parentRequest.getPrenom());
			parent.setDateNaissance(parentRequest.getDateNaissance());
			parent.setLieuNaissance(parentRequest.getLieuNaissance());
			parent.setAdresse(parentRequest.getAdresse());
			parent.setTelephone(parentRequest.getTelephone());
			parent.setFonction(parentRequest.getFonction());
			parent.setCni(parentRequest.getCni());
			parent.setMail(parentRequest.getMail());
			parent.setGsm(parentRequest.getGsm());

			return parentRepository.save(parent);
		}).orElseThrow(() -> new ResourceNotFoundException("parentId " + parentId + " not found"));
	}

	@DeleteMapping("/parent/{parentId}")
	public ResponseEntity<?> deleteParent(@PathVariable Long parentId) {
		return parentRepository.findById(parentId).map(parent -> {
			parentRepository.delete(parent);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("parentId " + parentId + " not found"));
	}

}
