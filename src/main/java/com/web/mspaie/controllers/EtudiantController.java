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
import com.web.mspaie.models.Classe;
import com.web.mspaie.models.Etudiant;
import com.web.mspaie.repository.ClasseRepository;
import com.web.mspaie.repository.EtudiantRepository;
import com.web.mspaie.repository.NiveauRepository;

/**
 * @author thoma
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/v2")
public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ClasseRepository classeRepository;

	@GetMapping("/classes/{etudiantId}/etudiants")
	public Page<Etudiant> getAllEtudiantsByClasseId(@PathVariable(value = "classeId") Long classeId,
			Pageable pageable) {
		return etudiantRepository.findByClasseId(classeId, pageable);
	}

	@PostMapping("/classes/{classeId}/etudiants")
	public Etudiant createEtudiant(@PathVariable(value = "classeId") Long classeId,
			@Valid @RequestBody Etudiant etudiant) {
		return classeRepository.findById(classeId).map(classe -> {
			etudiant.setClasse(classe);

			return etudiantRepository.save(etudiant);
		}).orElseThrow(() -> new ResourceNotFoundException("ClasseId " + classeId + " not found"));
	}

	@PutMapping("/classe/{classeId}/etudiants/{etudiantId}")
	public Etudiant updateEtudiant(@PathVariable(value = "classeId") Long classeId,
			@PathVariable(value = "etudiantId") Long etudiantId, @Valid @RequestBody Etudiant etudiantRequest) {
		if (!classeRepository.existsById(classeId)) {
			throw new ResourceNotFoundException("classeId " + classeId + " not found");
		}

		return etudiantRepository.findById(etudiantId).map(etudiant -> {
			// comment.setText(commentRequest.getText());
			etudiant.setNom(etudiantRequest.getNom());
			etudiant.setPrenom(etudiantRequest.getPrenom());
			etudiant.setDateNaissance(etudiantRequest.getDateNaissance());
			etudiant.setLieuNaissance(etudiantRequest.getLieuNaissance());
			etudiant.setSexe(etudiantRequest.getSexe());
			etudiant.setEcolePrecedant(etudiantRequest.getEcolePrecedant());
			etudiant.setEmail(etudiantRequest.getEmail());
			
			
			etudiant.setAdresse(etudiantRequest.getAdresse());
			
			
			
			// classe.setLibelle(classe.getLibelle());
			
			return etudiantRepository.save(etudiant);
		}).orElseThrow(() -> new ResourceNotFoundException("EtudiantId " + etudiantId + "not found"));
	}

	@DeleteMapping("/classes/{classeId}/etudiants/{etudiantId}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable(value = "classeId") Long classeId,
			@PathVariable(value = "etudiantId") Long etudiantId) {
		return etudiantRepository.findByIdAndClasseId(etudiantId, classeId).map(comment -> {
			etudiantRepository.delete(comment);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Comment not found with id " + etudiantId + " and classeId " + classeId));
	}

}
