package com.jorge.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorge.web.mvc.dao.ProyectoDao;
import com.jorge.web.mvc.entity.Proyecto;


@Service
public class ProyectoServiceImpl implements ProyectoService{

	
	@Autowired
	ProyectoDao proyectoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Proyecto> mostrarProyectos() {
		return (List<Proyecto>) proyectoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Proyecto buscarProyectoPorId(Long id) {
		return proyectoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Proyecto guardarProyecto(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
	}

	@Override
	@Transactional
	public Proyecto borrarProyecto(Long id) {
		Proyecto proyectoDelete = proyectoDao.findById(id).orElse(null);
		proyectoDao.deleteById(id);
		return proyectoDelete;
	}

}
