package com.backEnd_w4_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.backEnd_w4_project.enum_.TipoPostazione;
import com.backEnd_w4_project.model.Edificio;
import com.backEnd_w4_project.model.Postazione;
import com.backEnd_w4_project.repository.PostazioneDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostazioneService {
	
	@Autowired private PostazioneDao postazionedao;

	@Autowired @Qualifier("PostazioneFake") private ObjectProvider<Postazione> fakePostazioneProvider;
	
	public void creaPostazioneFake(Edificio edificio) {
		Postazione p = fakePostazioneProvider.getObject(edificio);
		p.setEdificio(edificio);
		salvaPostazione(p);
		
	}
	
	public void salvaPostazione(Postazione p) {
		postazionedao.save(p);
		log.info("Postazione " + p.getDescrizione() + " aggiunta al DB");
	}
	
	public void rimuoviPostazione(Long id) {
		postazionedao.delete(findByID(id));
		log.info("Postazione rimossa dal DB!!!");
	}
	
	public void aggiornaPostazione(Postazione p) {
		postazionedao.save(p);
		log.info("Postazione " + p.getDescrizione() + " aggiornata sul DB");
	}

	public Postazione findByID(Long id) {
		return postazionedao.findById(id).get();	
	}
	
	public List<Postazione> findAll() {
		return (List<Postazione>) postazionedao.findAll();	
	}
	
}