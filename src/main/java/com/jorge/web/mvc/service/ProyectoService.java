package com.jorge.web.mvc.service;

import java.util.List;

import com.jorge.web.mvc.entity.Proyecto;

public interface ProyectoService {

	public List<Proyecto> mostrarProyectos();
	
	public Proyecto buscarProyectoPorId(Long id);
	
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public Proyecto borrarProyecto(Long id);

}
