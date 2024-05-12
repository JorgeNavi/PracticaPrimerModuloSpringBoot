package com.jorge.web.mvc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorge.web.mvc.entity.Proyecto;

@Repository
public interface ProyectoDao extends CrudRepository<Proyecto, Long>{

}
