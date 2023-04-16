package com.backEnd_w4_project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.backEnd_w4_project.model.Postazione;


@Repository
public interface PostazioneDao extends CrudRepository<Postazione, Long> {
	    
}