package com.jorge.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jorge.web.mvc.entity.Proyecto;
import com.jorge.web.mvc.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> mostrarProyectos() {
        return proyectoService.mostrarProyectos();
    }

    @GetMapping("/{id}")
    public Proyecto buscarProyectoPorId(@PathVariable Long id) {
        return proyectoService.buscarProyectoPorId(id);
    }

    @PostMapping
    public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.guardarProyecto(proyecto);
    }
    
    @PutMapping("/{id}")
    public Proyecto actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto newproyecto) {
    	Proyecto proyectoUpdate = proyectoService.buscarProyectoPorId(id);
    	proyectoUpdate.setNombre(newproyecto.getNombre());
    	proyectoUpdate.setDescripcion(newproyecto.getDescripcion());
    	proyectoUpdate.setFecha_inicio(newproyecto.getFecha_inicio());
    	proyectoUpdate.setFecha_fin(newproyecto.getFecha_fin());
    	proyectoUpdate.setActivo(newproyecto.getActivo());
    	return proyectoService.guardarProyecto(proyectoUpdate);
    }

    @DeleteMapping("/{id}")
    public Proyecto borrarProyecto(@PathVariable Long id) {
        return proyectoService.borrarProyecto(id);
        
    }
}