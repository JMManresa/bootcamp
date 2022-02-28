package com.example;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.contracts.ActorRepository;
import com.example.domains.contracts.repositories.LanguageRepository;
import com.example.domains.entities.Actor;
import com.example.ioc.Servicio;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	@Qualifier("despliegue")
	Servicio srv;
	
	@Autowired(required = false)
	@Qualifier("manual")
	Servicio manual;
	
	@Autowired
	ActorRepository dao;
	
	@Autowired
	LanguageRepository daoLanguage;

	@Override
	public void run(String... args) throws Exception {
//		srv.run();
//		if(manual != null) manual.run();
//		
//		srv.setName("coña");
//		srv.run();
		
//		var a = new Actor(206, "Grillo", "Pepito", new Timestamp(0));
		
//		dao.findAll().forEach(System.out::println);
//		System.err.println(dao.findById(1).get());
//		System.err.println(dao.findByFirstName("nick"));
//		System.err.println(dao.findByFirstNameStartingWithAndLastNameEndingWith("n", "g"));
//		
//		var b = dao.findById(1).get();
//		b.getFilmActors().forEach(item -> System.out.println(item.getFilm().getTitle()));

		
	}

}
