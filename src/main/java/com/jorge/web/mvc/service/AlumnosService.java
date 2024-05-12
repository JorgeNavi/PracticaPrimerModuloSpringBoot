package com.jorge.web.mvc.service;

import java.util.List;

import com.jorge.web.mvc.entity.Alumnos;

public interface AlumnosService {
	
	public List<Alumnos> mostrarAlumnos();
	
	public Alumnos guardarAlumno(Alumnos alumno);
	
	public Alumnos obtenerAlumnoPorId(Long id);
	
	public void eliminarAlumno(Long id);

}
