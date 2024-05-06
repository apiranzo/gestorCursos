package com.pejo.anna.gestorCursosApi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pejo.anna.gestorCursosApi.servicios.ApiService;
import com.pejo.anna.gestorCursosApi.servicios.GestorService;

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

}
