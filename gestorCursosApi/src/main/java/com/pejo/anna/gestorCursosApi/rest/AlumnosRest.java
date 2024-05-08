package com.pejo.anna.gestorCursosApi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;
import com.pejo.anna.gestorCursosApi.servicios.GestorService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnosRest {

	// VARIABLES DE SERVICIO
	@Autowired
	private GestorService gestorSericio;

	// CONTROLADOR USUARIOS
	@GetMapping("/")
	public Iterable<Alumno> listadoAlumnos() {
		return gestorSericio.listarAlumnos();
	}

	@GetMapping("/{id}")
	public Alumno alumnoPorId(@PathVariable Long id) {
		return gestorSericio.verAlumno(id);
	}

	@PostMapping("/")
	public Alumno registrarAlumno(@RequestBody Alumno alumno) {
		gestorSericio.anadirAlumno(alumno);
		return alumno;
	}

	@DeleteMapping("/{id}")
	public void borrarAlumno(@PathVariable Long id) {
		gestorSericio.borrarAlumno(id);
	}

}
