package com.backEnd_w4_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.backEnd_w4_project.enum_.TipoPostazione;
import com.backEnd_w4_project.model.Postazione;
import com.backEnd_w4_project.model.Utente;
import com.backEnd_w4_project.repository.UtenteDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteService {
	
	@Autowired private UtenteDao utenteDao;

	@Autowired @Qualifier("UtenteFake") private ObjectProvider<Utente> fakeUserProvider;
	
	public void creaUtenteFake(Postazione postazione) {
		Utente u = fakeUserProvider.getObject(postazione);
		salvaUtente(u);
	}
	
	public void salvaUtente(Utente u) {
		utenteDao.save(u);
		log.info("Utente " + u.getEmail() + " aggiunto al DB");
	}
	
	public void rimuoviUtente(Long id) {
		utenteDao.delete(findByID(id));
		log.info("Utente rimosso dal DB!!!");
	}
	
	public void aggiornaUtente(Utente u) {
		utenteDao.save(u);
		log.info("Utente " + u.getEmail() + " aggiornato sul DB");
	}

	public Utente findByID(Long id) {
		return utenteDao.findById(id).get();	
	}
	
	public List<Utente> findAll() {
		return (List<Utente>) utenteDao.findAll();	
	}
	
	public List<Postazione> findByTipoAndCity(TipoPostazione tipo,String citta){

		return utenteDao.findByTipoAndCity(tipo,citta);
		
	}
}