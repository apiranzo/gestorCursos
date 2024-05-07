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
import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.entidades.Nota;
import com.pejo.anna.gestorCursosApi.servicios.ApiService;
import com.pejo.anna.gestorCursosApi.servicios.GestorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {
	
	//VARIABLES DE SERVICIO
	@Autowired
	private ApiService apiServicio;
	
	@Autowired
	private GestorService gestorServicio;
	
	@GetMapping("/")
	private String index(Model modelo) {
		modelo.addAttribute("usuarios", apiServicio.listarUsuarios());
		modelo.addAttribute("cursos", gestorServicio.listarCursos());
		modelo.addAttribute("alumnos", gestorServicio.listarAlumnos());
		modelo.addAttribute("notas", gestorServicio.listarNotas());
		
		
		return "index";
	}
	
	// Registro AlumnoCursoNota - vista formulario
		@GetMapping("registroCompleto")
		public String registroCompleto(Model modelo) {
			modelo.addAttribute("cursos", gestorServicio.listarCursos());
			modelo.addAttribute("alumnos", gestorServicio.listarAlumnos());
			modelo.addAttribute("notas", gestorServicio.listarNotas());
			
			return "registroCompleto";
		}

		@GetMapping("registroCompleto/{id}")
		public String verRegistroCompleto(@PathVariable("idCurso") Long idCurso, Model modelo) {
			Curso curso = gestorServicio.verCurso(idCurso);

			modelo.addAttribute("cursos", gestorServicio.listarCursos());
			modelo.addAttribute("alumnos", gestorServicio.listarAlumnos());
			modelo.addAttribute("notas", gestorServicio.listarNotas());
			return "registroCompleto";
		}

		// Recibo de los datos de Usuario
		@PostMapping("registroCompleto")
		public String postRegistroUsuario(@Valid Curso curso, @Valid Alumno alumno, @Valid Nota nota, BindingResult bindingResult, Model modelo) {
			if (bindingResult.hasErrors()) {
				return "registroCompleto";
			}

//			
//			if (curso.getId() == null) {
//				System.out.println(curso.getId());
//				gestorServicio.anadirCurso(curso);
//				
//			} else {
//				gestorServicio.modificarCurso(curso);
//			}

			return "redirect:/index";
		}

}
