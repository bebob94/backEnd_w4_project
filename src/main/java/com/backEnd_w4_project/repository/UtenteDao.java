package com.backEnd_w4_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backEnd_w4_project.enum_.TipoPostazione;
import com.backEnd_w4_project.model.Postazione;
import com.backEnd_w4_project.model.Utente;

@Repository
public interface UtenteDao extends CrudRepository<Utente, Long> {

	@Query(value="SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipo AND p.edificio.città = :citta")
	public List<Postazione> findByTipoAndCity(TipoPostazione tipo, String citta);
}