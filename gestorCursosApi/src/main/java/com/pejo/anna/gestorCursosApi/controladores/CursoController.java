package com.pejo.anna.gestorCursosApi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.servicios.GestorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class CursoController {

	// VARIABLES DE SERVICIO
	@Autowired
	private GestorService gestorServicio;
	

	// CONTROLADOR CURSOS
	@GetMapping("cursos")
	private String listadoCursos(Model modelo) {
		modelo.addAttribute("cursos", gestorServicio.listarCursos());

		return "cursos";
	}

	@GetMapping("curso/{id}")
	public String verUnCurso(@PathVariable("id") Long id, Model model) {
		
		Long totalAlumnosCurso = gestorServicio.totalAlumnosCurso(id);
		Long totalAprobados = gestorServicio.totalAlumnosAprobadosCurso(id);
		Long porcentajeAprobados = gestorServicio.porcentajeAlumnosCurso(totalAprobados);

		model.addAttribute("curso", gestorServicio.verCurso(id));
		model.addAttribute("alumnos", gestorServicio.listarAlumnosCurso(id));
		model.addAttribute("alumnosAprobados", gestorServicio.listarAlumnosAprobadosDeCurso(id));
	
		model.addAttribute("totalAlumnosCurso", totalAlumnosCurso);
		model.addAttribute("totalAprobados", totalAprobados);
		model.addAttribute("porcentajeAprobados", porcentajeAprobados);

		return "curso";
	}
	@GetMapping("curso/borrar/{id}")
	public String borrarCurso(@PathVariable("id") Long id) {
		gestorServicio.borrarCurso(id);
		
		return "cursos";
	}
	
	// REGISTRO CURSO
	@GetMapping("registroCurso")
	public String registroCurso(Curso curso) {
		return "registroCurso";
	}
	@GetMapping("registroCurso/{id}")
	public String registroCurso(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("curso", gestorServicio.verCurso(id));
		return "registroCurso";
	}
	@PostMapping("registroCurso")
	public String postRegistroCurso(@Valid Curso curso, BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) {
			return "registroCurso";
		}

		if (curso.getId() == null) {
			System.out.println(curso.getId());
			gestorServicio.anadirCurso(curso);
		} else {
			gestorServicio.modificarCurso(curso);
		}

		return "redirect:/cursos";
	}

}
