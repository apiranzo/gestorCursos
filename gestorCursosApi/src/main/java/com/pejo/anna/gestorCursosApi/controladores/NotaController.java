package com.pejo.anna.gestorCursosApi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pejo.anna.gestorCursosApi.entidades.Nota;
import com.pejo.anna.gestorCursosApi.servicios.GestorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class NotaController {

	// VARIABLES DE SERVICIO
	@Autowired
	private GestorService gestorServicio;
	

	// CONTROLADOR notas
	@GetMapping("notas")
	private String listadonotas(Model modelo) {
		modelo.addAttribute("notas", gestorServicio.listarNotas());

		return "notas";
	}

	@GetMapping("nota/{id}")
	public String verUnnota(@PathVariable("id") Long id, Model model) {

		model.addAttribute("nota", gestorServicio.verNota(id));

		return "nota";
	}
	@GetMapping("nota/borrar/{id}")
	public String borrarnota(@PathVariable("id") Long id) {
		gestorServicio.borrarNota(id);
		
		return "notas";
	}
	
	// REGISTRO Nota
	@GetMapping("registroNota")
	public String registronota(Nota nota) {
		return "registroNota";
	}
	@GetMapping("registroNota/{id}")
	public String registronota(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("nota", gestorServicio.verNota(id));
		return "registroNota";
	}
	@PostMapping("registroNota")
	public String postRegistronota(@Valid Nota nota, BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) {
			return "registroNota";
		}

		if (nota.getId() == null) {
			gestorServicio.anadirNota(nota);
		} else {
			gestorServicio.modificarNota(nota);
		}

		return "redirect:/notas";
	}

}
