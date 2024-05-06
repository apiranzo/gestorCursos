package com.pejo.anna.gestorCursosApi.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pejo.anna.gestorCursosApi.entidades.Usuario;
import com.pejo.anna.gestorCursosApi.servicios.ApiService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class UsuariosController {

	// VARIABLES DE SERVICIO
	@Autowired
	private ApiService apiServicio;

	// CONTROLADOR USUARIOS
	@GetMapping("usuarios")
	private String listadoUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", apiServicio.listarUsuarios());

		return "usuarios";
	}

	// Registro Usuario - vista formulario
	@GetMapping("registroUsuario")
	public String registroUsuario(Usuario usuario) {
		return "registroUsuario";
	}

	@GetMapping("registroUsuario/{id}")
	public String verRegistroUsuario(@PathVariable("id") Long id, Model model) {
		Usuario usuario = apiServicio.verUsuario(id);

		model.addAttribute("usuario", usuario);
		return "registroUsuario";
	}

	// Recibo de los datos de Usuario
	@PostMapping("registroUsuario")
	public String postRegistroUsuario(@Valid Usuario usuario, BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) {
			return "registroUsuario";
		}

		if (usuario.getId() == null) {
			System.out.println(usuario.getId());
			apiServicio.anadirUsuario(usuario);
		} else {
			apiServicio.modificarUsuario(usuario);
		}

		return "redirect:/usuarios";
	}

	// USUARIO
	@GetMapping("usuario/{id}")
	public String verUsuario(@PathVariable("id") Long id, Model model) {
		model.addAttribute("usuario", apiServicio.verUsuario(id));
		return "fichaUsuario";
	}

	@GetMapping("usuario/borrar/{id}")
	public String borrarRegistroUsuario(@PathVariable("id") Long id) {
		apiServicio.borrarUsuario(id);

		return "redirect:/usuarios";
	}

}
