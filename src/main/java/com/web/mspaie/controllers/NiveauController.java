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
import com.web.mspaie.models.Niveau;
import com.web.mspaie.repository.NiveauRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/v4")
public class NiveauController {
	@Autowired
	private NiveauRepository niveauRepository;

	@GetMapping("/niveaux")
	public Page<Niveau> getAllNiveauxs(Pageable pageable) {
		return niveauRepository.findAll(pageable);

	}

	@PostMapping("/niveaux")
	public Niveau createNiveau(@Valid @RequestBody Niveau niveau) {
		return niveauRepository.save(niveau);
	}

	@PutMapping("/niveaux/{niveauId}")
	public Niveau updateNiveau(@PathVariable Long niveauId, @Valid @RequestBody Niveau niveauRequest) {
		return niveauRepository.findById(niveauId).map(niveau -> {
			niveau.setLibelle(niveauRequest.getLibelle());
			niveau.setAnneeScolaire(niveauRequest.getAnneeScolaire());

			// niveau.setLibelle(niveauRequest.getLibelle());

			return niveauRepository.save(niveau);
		}).orElseThrow(() -> new ResourceNotFoundException("niveauId " + niveauId + " not found"));
	}

	@DeleteMapping("/niveaux/{niveauId}")
	public ResponseEntity<?> deleteNiveau(@PathVariable Long niveauId) {
		return niveauRepository.findById(niveauId).map(niveau -> {
			niveauRepository.delete(niveau);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("niveauId " + niveauId + " not found"));
	}

}
