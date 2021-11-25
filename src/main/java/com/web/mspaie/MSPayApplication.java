package com.web.mspaie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.web.mspaie.model.Classe;
import com.web.mspaie.model.Etudiant;
import com.web.mspaie.model.Inscription;
import com.web.mspaie.model.Niveau;
import com.web.mspaie.model.Parent;
import com.web.mspaie.model.Service;
import com.web.mspaie.repository.ClasseRepository;
import com.web.mspaie.repository.EtudiantRepository;
import com.web.mspaie.repository.InscriptionRepository;
import com.web.mspaie.repository.NiveauRepository;
import com.web.mspaie.repository.ParentRepository;
import com.web.mspaie.repository.ServiceRepository;

import javax.annotation.PostConstruct;

import java.util.Set;
import java.util.TimeZone;

/**
 * @author thoma
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
public class MSPayApplication implements CommandLineRunner {
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

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(MSPayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
/*
		// ///////create the levels /////////////////////
		Niveau niveau1 = new Niveau(null, "Ingenierie ", 2022, null, null);
		niveauRepository.save(niveau1);
		Niveau niveau2 = new Niveau(null, "Preparatoire", 2022, null, null);
		niveauRepository.save(niveau2);

		////////// create and save Classes ////////////////////////////////

		Classe C1 = new Classe(null, "Informatique", 2022, niveau1, null, null, null);
		classeRepository.save(C1);
		Classe C2 = new Classe(null, "Math Info", 2022, niveau2, null, null, null);
		classeRepository.save(C2);

		////// Create and save Services//////////////
		serviceRepository.save(new Service(null, "Inscription", 500, niveau1, null));
		serviceRepository.save(new Service(null, "Inscription", 600, niveau2, null));

		/// creation and save the parents ////////////////////////////
		Parent p1 = new Parent(null, "Bussines Man", null, null, null, null, 10101010, "thomas@yahoo.fr", 56399163, null, 0, null, null, null, null, null, null);
		parentRepository.save(p1);
		Parent p2 = new Parent(null, "Enseignant", null, null, null, null, 11111111, "Ama@gmai.com", 888777, null, 0, null, null, null, null, null, null);
		parentRepository.save(p2);

		////////// create and save Student /////////////////////
		Etudiant e1 = new Etudiant(null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, null, 0, C1, null, null, p1, null, null,
				null);
		etudiantRepository.save(e1);

		Etudiant e2 = new Etudiant(null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, null, 0, C1, null, null, p1, null, null,
				null);
		etudiantRepository.save(e2);

		Etudiant e3 = new Etudiant(null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, null, 0, C2, null, null, p2, null, null,
				null);
		etudiantRepository.save(e3);

		Etudiant e4 = new Etudiant(null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, null, 0, C2, null, null, p2, null, null,
				null);
		etudiantRepository.save(e4);
	
		//////////create and save the inscriptions////////////////////
		Inscription i1 = new Inscription(null, null, 600, 4949, null, null, C1, p1, e1);
		inscriptionRepository.save(i1);
		Inscription i2 = new Inscription(null, null,600 , 444, null, null, C1, p1, e2);
		inscriptionRepository.save(i2);
		Inscription i3 = new Inscription(null, null, 500, 045, null, null, C2, p2, e3);
		inscriptionRepository.save(i3);
		Inscription i4 = new Inscription(null, null, 0, 0, null, null, C2, p2, e4);
		inscriptionRepository.save(i4);

	*/	
		/////////// il faut affiche les données///////////////////////////////////
		
		  niveauRepository.findAll().forEach(cp ->{
		  System.out.println(cp.getAnneeScolaire());
		  System.out.println(cp.getLibelle()); });
		 

	}

}
