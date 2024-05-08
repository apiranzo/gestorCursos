package com.pejo.anna.gestorCursosApi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pejo.anna.gestorCursosApi.entidades.Nota;
import com.pejo.anna.gestorCursosApi.servicios.GestorService;

@RestController
@RequestMapping("/api/notas")
public class NotaRest {

	// VARIABLES DE SERVICIO
	@Autowired
	private GestorService gestorSericio;

	// CONTROLADOR USUARIOS
	@GetMapping("/")
	public Iterable<Nota> listadoNotas() {
		return gestorSericio.listarNotas();
	}

	@GetMapping("/{id}")
	public Nota notaPorId(@PathVariable Long id) {
		return gestorSericio.verNota(id);
	}

	@PostMapping("/")
	public Nota registrarNota(@RequestBody Nota nota) {
		gestorSericio.anadirNota(nota);
		return nota;
	}

	@DeleteMapping("/{id}")
	public void borrarNota(@PathVariable Long id) {
		gestorSericio.borrarNota(id);
	}

}
