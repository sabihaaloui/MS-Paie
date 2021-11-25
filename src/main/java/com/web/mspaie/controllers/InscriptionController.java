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
import com.web.mspaie.models.Etudiant;
import com.web.mspaie.models.Inscription;
import com.web.mspaie.models.Parent;
import com.web.mspaie.repository.ClasseRepository;
import com.web.mspaie.repository.EtudiantRepository;
import com.web.mspaie.repository.InscriptionRepository;

/**
 * @author thoma
 *
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/v3")
public class InscriptionController {
	@Autowired
	private InscriptionRepository inscriptionRepository;
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;

	@GetMapping("/inscriptions")
	public Page<Inscription> getAllInscriptions(Pageable pageable) {
		return inscriptionRepository.findAll(pageable);

	}

	@PostMapping("/classes/{classeId}/inscriptions")
	public Inscription createInscription(@PathVariable(value = "classeId") Long classeId,
			@Valid @RequestBody Inscription inscription) {
		return classeRepository.findById(classeId).map(classe -> {
			inscription.setClasse(classe);

			return inscriptionRepository.save(inscription);
		}).orElseThrow(() -> new ResourceNotFoundException("ClasseId " + classeId + " not found"));
	}

	@PutMapping("/classe/{classeId}/inscriptions/{inscriptionId}")
	public Inscription updateInscription(@PathVariable(value = "classeId") Long classeId,
			@PathVariable(value = "inscriptionId") Long inscriptionId,
			@Valid @RequestBody Inscription inscriptionRequest) {
		if (!classeRepository.existsById(classeId)) {
			throw new ResourceNotFoundException("InscriptionId " + classeId + " not found");
		}

		/*
		 * Long etudiantId = null; if (!etudiantRepository.existsById(etudiantId)) {
		 * throw new ResourceNotFoundException("InscriptionId " + classeId +
		 * " not found"); }
		 */

		return inscriptionRepository.findById(classeId).map(inscription -> {
			// comment.setText(commentRequest.getText());
			// etudiant.setNom(inscriptionRequest.getNom());
			inscription.setDateInscription(inscriptionRequest.getDateInscription());
			inscription.setMontant(inscriptionRequest.getMontant());
			inscription.setCode(inscriptionRequest.getCode());
			inscription.setAnneeScolaire(inscriptionRequest.getAnneeScolaire());
			inscription.setObservation(inscriptionRequest.getObservation());

			

			return inscriptionRepository.save(inscription);
		}).orElseThrow(() -> new ResourceNotFoundException("ClasseId " + classeId + "not found"));
	}

	@DeleteMapping("/classes/{classeId}/inscriptions/{isncriptionId}")
	public ResponseEntity<?> deleteInscription(@PathVariable(value = "classeId") Long classeId,
			@PathVariable(value = "InscriptionId") Long inscriptionId) {
		return inscriptionRepository.findByIdAndClasseId(inscriptionId, classeId).map(comment -> {
			inscriptionRepository.delete(comment);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Comment not found with id " + inscriptionId + " and classeId " + classeId));
	}

}
