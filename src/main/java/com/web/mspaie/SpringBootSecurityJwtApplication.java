package com.web.mspaie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.mspaie.models.Classe;
import com.web.mspaie.models.Niveau;
import com.web.mspaie.models.Service;
import com.web.mspaie.repository.ClasseRepository;
import com.web.mspaie.repository.EtudiantRepository;
import com.web.mspaie.repository.InscriptionRepository;
import com.web.mspaie.repository.NiveauRepository;
import com.web.mspaie.repository.ParentRepository;
import com.web.mspaie.repository.ServiceRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootSecurityJwtApplication  implements CommandLineRunner{
	
	@Autowired
	private NiveauRepository niveauRepository;
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private ParentRepository parentRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private InscriptionRepository inscriptionRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		////////// create and save Classes ////////////////////////////////

		
		
	}

}
