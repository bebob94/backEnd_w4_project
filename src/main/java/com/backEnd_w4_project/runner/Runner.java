package com.backEnd_w4_project.runner;

import java.time.LocalDate;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.backEnd_w4_project.enum_.TipoPostazione;
import com.backEnd_w4_project.model.Edificio;
import com.backEnd_w4_project.model.Postazione;
import com.backEnd_w4_project.model.Utente;
import com.backEnd_w4_project.service.EdificioService;
import com.backEnd_w4_project.service.PostazioneService;
import com.backEnd_w4_project.service.PrenotazioneService;
import com.backEnd_w4_project.service.UtenteService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Runner implements ApplicationRunner {

	@Autowired
	UtenteService utentedao;
	@Autowired
	EdificioService edificiodao;
	@Autowired
	PostazioneService postazionedao;
	@Autowired
	PrenotazioneService prenotazionedao;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		
//		<<<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE EDIFICIO>>>>>>>>>>>>>>>>>>>>>>>>>>>
//		edificiodao.creaEdificioFake();
//		edificiodao.creaEdificioFake();
//		
//		<<<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE POSTAZIONE>>>>>>>>>>>>>>>>>>>>>>>>>>>
//		postazionedao.creaPostazioneFake(edificiodao.findByID(1l));
//		postazionedao.creaPostazioneFake(edificiodao.findByID(2l));

//		<<<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE UTENTE>>>>>>>>>>>>>>>>>>>>>>>>>>>
//		utentedao.creaUtenteFake(postazionedao.findByID(1l));
//		utentedao.creaUtenteFake(postazionedao.findByID(2l));
		
//		<<<<<<<<<<<<<<<<<<<<<<<<<<< CREAZIONE PRENOTAZIONE>>>>>>>>>>>>>>>>>>>>>>>>>>>
		prenotazionedao.creaPrenotazione(LocalDate.of(2023, 4, 20),postazionedao.findByID(3l), utentedao.findByID(1l));
//		prenotazionedao.creaPrenotazione(LocalDate.of(2022, 12, 20),postazionedao.findByID(3l), utentedao.findByID(1l));
//		prenotazionedao.creaPrenotazione(LocalDate.of(2022, 12, 20),postazionedao.findByID(4l), utentedao.findByID(1l));
		
		
//		<<<<<<<<<<<<<<<<<<<<<<<<<<< CERCA POSTAZIONE IN BASE AL TIPO E ALLA CITTA >>>>>>>>>>>>>>>>>>>>>>>>>>>
		System.out.println(utentedao.findByTipoAndCity(TipoPostazione.OPEN_SPACE, "Settimo Ciro").toString());
		
		
	}

}
