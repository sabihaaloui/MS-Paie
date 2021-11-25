/**
 * 
 */
package com.web.mspaie.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.web.mspaie.models.Niveau;
import com.web.mspaie.repository.*;

/**
 * @author thoma
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ClasseController {
	@Autowired
	private ClasseRepository classeRepository;

	@GetMapping("/classes")
	public List<Classe> getAllClasses() {
		return classeRepository.findAll();

	}

	@PostMapping("/classes")
	public Classe createClasse(@Valid @RequestBody Classe classe) {
		return classeRepository.save(classe);
	}

	@PutMapping("/classes/{id}")
	public ResponseEntity<Classe> updateClasse(@PathVariable(value = "id") Long classeId,
			@Valid @RequestBody Classe classeDetails) throws ResourceNotFoundException {
		Classe classe = classeRepository.findById(classeId)
				.orElseThrow(() -> new ResourceNotFoundException("Classe not found for this id :: " + classeId));
		classe.setLibelle(classeDetails.getLibelle());
		classe.setAnneeScolaire(classeDetails.getAnneeScolaire());

		final Classe updatedClasse = classeRepository.save(classe);
		return ResponseEntity.ok(updatedClasse);
	}

	@DeleteMapping("/classes/{id}")
	public Map<String, Boolean> deleteClasse(@PathVariable(value = "id") Long classeId)
			throws ResourceNotFoundException {
		Classe classe = classeRepository.findById(classeId)
				.orElseThrow(() -> new ResourceNotFoundException("Classe not found for this id :: " + classeId));

		classeRepository.delete(classe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
