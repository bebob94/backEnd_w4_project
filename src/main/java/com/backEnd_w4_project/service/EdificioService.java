package com.backEnd_w4_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.backEnd_w4_project.model.Edificio;
import com.backEnd_w4_project.repository.EdificioDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EdificioService {
	
	@Autowired private EdificioDao edificioDao;

	@Autowired @Qualifier("EdificioFake") private ObjectProvider<Edificio> fakeEdificioProvider;
	
	public void creaEdificioFake() {
			Edificio e = fakeEdificioProvider.getObject();
			salvaEdificio(e);
		}
	
	public void salvaEdificio(Edificio e) {
		edificioDao.save(e);
		log.info("Edificio " + e.getName() + " aggiunto al DB");
	}
	
	public void rimuoviEdificio(Long id) {
		edificioDao.delete(findByID(id));
		log.info("Edificio rimosso dal DB");
	}
	
	public void aggiornaEdificio(Edificio e) {
		edificioDao.save(e);
		log.info("Edificio " + e.getName() + " aggiornato sul DB");
	}

	public Edificio findByID(Long id) {
		return edificioDao.findById(id).get();	
	}
	
	public List<Edificio> findAll() {
		return (List<Edificio>) edificioDao.findAll();	
	}
	
	
}