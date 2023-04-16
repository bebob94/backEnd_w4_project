package com.backEnd_w4_project.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.backEnd_w4_project.model.Postazione;
import com.backEnd_w4_project.model.Prenotazione;
import com.backEnd_w4_project.model.Utente;


@Configuration
@PropertySource("classpath:application.properties")
public class prenotazioneConfiguration {

	@Bean
	@Scope("prototype")
	public Prenotazione customPrenotazione() {
		return new Prenotazione();
	}
	
	@Bean("paramPrenotazione")
	@Scope("prototype")
	public Prenotazione paramPrenotazione(LocalDate dataPrenotazione,  Postazione postazione,Utente utente) {
		return new Prenotazione(dataPrenotazione,postazione,utente);
	}
	
	
}
