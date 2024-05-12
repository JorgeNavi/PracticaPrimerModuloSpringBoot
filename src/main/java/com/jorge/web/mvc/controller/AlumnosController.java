package com.jorge.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jorge.web.mvc.entity.Alumnos;
import com.jorge.web.mvc.service.AlumnosService;
import com.jorge.web.mvc.service.ProyectoService;

@Controller
public class AlumnosController {
	
	@Autowired
	private AlumnosService alumnosService;
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping({"/alumnos", "/"})
	public String mostrarAlumnos(Model modelo) {
		modelo.addAttribute("lista_alumnos", alumnosService.mostrarAlumnos());
		return "alumnos";
	}
	
	@GetMapping("/proyectos/mostrar")
	public String mostrarProyectos(Model model) {
	    model.addAttribute("lista_proyectos", proyectoService.mostrarProyectos());
	    return "proyectos"; 
	}
	
	@GetMapping("/alumnos/registrar")
	public String formularioAlumnos(Model modelo) {
		Alumnos alumno = new Alumnos();
		modelo.addAttribute("alumno", alumno);
		return "registrar_alumno";
	}
	
	@PostMapping("/alumnos/registrar")
	public String guardarAlumno(@ModelAttribute("alumno") Alumnos alumno) {
		alumnosService.guardarAlumno(alumno);
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumnos/editar/{id}")
	public String formularioAlumnosEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("alumno", alumnosService.obtenerAlumnoPorId(id));
		return "editar_alumno";
		
	}
	
	@PostMapping("/alumnos/editar/{id}")
	public String actualizarAlumnos(@PathVariable Long id, @ModelAttribute("alumno") Alumnos alumno) {
		Alumnos alumnoUpdate = alumnosService.obtenerAlumnoPorId(id);
		alumnoUpdate.setNombre(alumno.getNombre());
		alumnoUpdate.setApellido(alumno.getApellido());
		alumnoUpdate.setEmail(alumno.getEmail());
		alumnoUpdate.setDni(alumno.getDni());
		alumnoUpdate.setTelefono(alumno.getTelefono());
		alumnoUpdate.setFecha_nac(alumno.getFecha_nac());
		alumnosService.guardarAlumno(alumnoUpdate);
		
		return "redirect:/alumnos";
		
	}
	
	@GetMapping("/alumnos/eliminar/{id}")
	public String eliminarAlumnos(@PathVariable Long id) {
		alumnosService.eliminarAlumno(id);
		return "redirect:/alumnos";
	}
	

}
