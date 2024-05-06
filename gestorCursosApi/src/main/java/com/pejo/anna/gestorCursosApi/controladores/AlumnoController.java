package com.pejo.anna.gestorCursosApi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;
import com.pejo.anna.gestorCursosApi.servicios.GestorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class AlumnoController {

	// VARIABLES DE SERVICIO
	@Autowired
	private GestorService gestorServicio;
	

	// CONTROLADOR alumnos
	@GetMapping("alumnos")
	private String listadoalumnos(Model modelo) {
		modelo.addAttribute("alumnos", gestorServicio.listarAlumnos());

		return "alumnos";
	}

	@GetMapping("alumno/{id}")
	public String verAlumno(@PathVariable("id") Long id, Model model) {

		model.addAttribute("alumno", gestorServicio.verAlumno(id));
		model.addAttribute("cursosAlumno", gestorServicio.listarCursosAlumno(id));
		model.addAttribute("notasAlumno", gestorServicio.listadoNotasAlumno(id));

		return "alumno";
	}
	@GetMapping("alumno/borrar/{id}")
	public String borraralumno(@PathVariable("id") Long id) {
		gestorServicio.borrarAlumno(id);
		
		return "alumnos";
	}
	
	// REGISTRO Alumno
	@GetMapping("registroAlumno")
	public String registroAlumno(Alumno alumno) {
		return "registroAlumno";
	}
	@GetMapping("registroAlumno/{id}")
	public String registroAlumno(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("alumno", gestorServicio.verAlumno(id));
		return "registroAlumno";
	}
	@PostMapping("registroAlumno")
	public String postRegistroalumno(@Valid Alumno alumno, BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) {
			return "registroAlumno";
		}

		if (alumno.getId() == null) {
			gestorServicio.anadirAlumno(alumno);
		} else {
			gestorServicio.modificarAlumno(alumno);
		}

		return "redirect:/alumnos";
	}

}
