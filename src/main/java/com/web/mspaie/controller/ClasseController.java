/**
 * 
 */
package com.web.mspaie.controller;

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
import com.web.mspaie.model.Classe;
import com.web.mspaie.repository.ClasseRepository;
import com.web.mspaie.repository.NiveauRepository;

/**
 * @author thoma
 *
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/v1")
public class ClasseController {
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private NiveauRepository niveauRepository;

	@GetMapping("/niveaux/{niveauId}/classes")
	public Page<Classe> getAllClassesByNiveauId(@PathVariable(value = "niveauId") Long niveauId, Pageable pageable) {
		return classeRepository.findByNiveauId(niveauId, pageable);
	}

	@PostMapping("/niveaux/{niveauId}/classes")
	public Classe createClasse(@PathVariable(value = "niveauId") Long niveauId, @Valid @RequestBody Classe classe) {
		return niveauRepository.findById(niveauId).map(niveau -> {
			classe.setNiveau(niveau);
			
			return classeRepository.save(classe);
		}).orElseThrow(() -> new ResourceNotFoundException("NiveauId " + niveauId + " not found"));
	}

	@PutMapping("/niveaux/{niveauId}/classes/{classeId}")
	public Classe updateClasse(@PathVariable(value = "niveauId") Long niveauId,
			@PathVariable(value = "classeId") Long classeId, @Valid @RequestBody Classe classeRequest) {
		if (!niveauRepository.existsById(niveauId)) {
			throw new ResourceNotFoundException("NiveauId " + niveauId + " not found");
		}

		return classeRepository.findById(classeId).map(classe -> {
			//comment.setText(commentRequest.getText());
			classe.setLibelle(classe.getLibelle());
			classe.setAnneeScolaire(classe.getAnneeScolaire());
			return classeRepository.save(classe);
		}).orElseThrow(() -> new ResourceNotFoundException("ClasseId " + classeId + "not found"));
	}

	@DeleteMapping("/niveaux/{niveauId}/classes/{classeId}")
	public ResponseEntity<?> deleteClasse(@PathVariable(value = "niveauId") Long niveauId,
			@PathVariable(value = "classeId") Long classeId) {
		return classeRepository.findByIdAndNiveauId(classeId, niveauId).map(comment -> {
			classeRepository.delete(comment);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Comment not found with id " + classeId + " and niveauId " + niveauId));
	}

}
