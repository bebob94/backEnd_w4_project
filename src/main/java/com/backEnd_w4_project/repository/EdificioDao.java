package com.backEnd_w4_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.backEnd_w4_project.model.Edificio;

@Repository
public interface EdificioDao extends CrudRepository<Edificio, Long>{

}
