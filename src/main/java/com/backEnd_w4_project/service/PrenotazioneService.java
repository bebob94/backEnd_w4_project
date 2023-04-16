package com.backEnd_w4_project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.backEnd_w4_project.model.Postazione;
import com.backEnd_w4_project.model.Prenotazione;
import com.backEnd_w4_project.model.Utente;
import com.backEnd_w4_project.repository.PostazioneDao;
import com.backEnd_w4_project.repository.PrenotazioneDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrenotazioneService {

	@Autowired private PrenotazioneDao prenotazionedao;
	@Autowired PostazioneDao postazionedao;
	
	@Autowired @Qualifier("paramPrenotazione") private ObjectProvider<Prenotazione> PrenotazioneProvider;

	public void creaPrenotazione(LocalDate dataPrenotazione,  Postazione postazione,Utente utente) {
		if(dataPrenotazione.isAfter(LocalDate.now())) {
			if(postazione.isPostazioneLibera()) {
				Boolean b = utente.getPrenotazioni().stream().map(e -> e.getDataPrenotazione()).collect(Collectors.toList()).contains(dataPrenotazione);
				if(!b) {
					Prenotazione pr = PrenotazioneProvider.getObject(dataPrenotazione,postazione, utente);
					pr.setPostazione(postazione);
					pr.setUtente(utente);
					pr.setDataPrenotazione(dataPrenotazione);
					pr.setScadenzaPrenotazione(dataPrenotazione.plusDays(1));
					pr.getPostazione().setPostazioneLibera(false);
					salvaPrenotazione(pr);
					postazionedao.save(pr.getPostazione());
				}else {
					System.out.println("CI DISPIACE, HA GIA UNA PRENOTAZIONE IN CORSO IN QUESTA DATA");
				}
			}else {
				System.out.println("CI DISPIACE, LA POSTAZIONE NON RISULTA DISPONIBILE");
			}
			
		}else {
			System.out.println("CI DISPIACE, NON POSSIAMO TORNARE INDIETRO NEL TEMPO");
			
		}
	}
	
	
	public void salvaPrenotazione(Prenotazione p) {	
			prenotazionedao.save(p);
		log.info("Prenotazione aggiunta al DB");
	}
	
	
	
}