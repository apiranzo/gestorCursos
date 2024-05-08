package com.pejo.anna.gestorCursosApi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.servicios.GestorService;

@RestController
@RequestMapping("/api/cursos")
public class CursosRest {

	// VARIABLES DE SERVICIO
	@Autowired
	private GestorService gestorSericio;

	// CONTROLADOR USUARIOS
	@GetMapping("/")
	public Iterable<Curso> listadoCursos() {
		return gestorSericio.listarCursos();
	}

	@GetMapping("/{id}")
	public Curso cursoPorId(@PathVariable Long id) {
		return gestorSericio.verCurso(id);
	}

	@PostMapping("/")
	public Curso registrarCurso(@RequestBody Curso curso) {
		gestorSericio.anadirCurso(curso);
		return curso;
	}

	@DeleteMapping("/{id}")
	public void borrarCurso(@PathVariable Long id) {
		gestorSericio.borrarCurso(id);
	}

}
