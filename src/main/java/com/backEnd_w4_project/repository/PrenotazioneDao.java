package com.backEnd_w4_project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backEnd_w4_project.model.Prenotazione;


@Repository
public interface PrenotazioneDao extends CrudRepository<Prenotazione, Long> {


}