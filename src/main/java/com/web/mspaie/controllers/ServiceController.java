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
import com.web.mspaie.models.Service;
import com.web.mspaie.repository.ClasseRepository;
import com.web.mspaie.repository.NiveauRepository;
import com.web.mspaie.repository.ServiceRepository;

/**
 * @author thoma
 *
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/v0")
public class ServiceController {
	
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private NiveauRepository niveauRepository;

	@GetMapping("/niveaux/{niveauId}/services")
	public Page<Service> getAllServicesByNiveauId(@PathVariable(value = "niveauId") Long niveauId, Pageable pageable) {
		return serviceRepository.findByNiveauId(niveauId, pageable);
	}

	@PostMapping("/niveaux/{niveauId}/services")
	public Service createService(@PathVariable(value = "niveauId") Long niveauId, @Valid @RequestBody Service service) {
		return niveauRepository.findById(niveauId).map(niveau -> {
			service.setNiveau(niveau);
			
			return serviceRepository.save(service);
		}).orElseThrow(() -> new ResourceNotFoundException("NiveauId " + niveauId + " not found"));
	}

	@PutMapping("/niveaux/{niveauId}/services/{serviceId}")
	public Service updateService(@PathVariable(value = "niveauId") Long niveauId,
			@PathVariable(value = "serviceId") Long serviceId, @Valid @RequestBody Service serviceRequest) {
		if (!niveauRepository.existsById(niveauId)) {
			throw new ResourceNotFoundException("NiveauId " + niveauId + " not found");
		}

		return serviceRepository.findById(serviceId).map(service -> {
			//comment.setText(commentRequest.getText());
			//classe.setLibelle(classe.getLibelle());
			service.setLibelle(service.getLibelle());
			service.setNiveau(service.getNiveau());
			service.setCout(service.getCout());
			
			
			//classe.setAnneeScolaire(classe.getAnneeScolaire());
			return serviceRepository.save(service);
		}).orElseThrow(() -> new ResourceNotFoundException("ServiceId " + serviceId + "not found"));
	}

	@DeleteMapping("/niveaux/{niveauId}/services/{seviveId}")
	public ResponseEntity<?> deleteService(@PathVariable(value = "niveauId") Long niveauId,
			@PathVariable(value = "serviceId") Long serviceId) {
		return serviceRepository.findByIdAndNiveauId(serviceId, niveauId).map(service -> {
			serviceRepository.delete(service);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Comment not found with id " + serviceId + " and niveauId " + niveauId));
	}


}
