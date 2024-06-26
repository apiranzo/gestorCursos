package com.pejo.anna.gestorCursosApi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pejo.anna.gestorCursosApi.entidades.Usuario;
import com.pejo.anna.gestorCursosApi.servicios.ApiService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosRest {

	// VARIABLES DE SERVICIO
	@Autowired
	private ApiService apiServicio;

	// CONTROLADOR USUARIOS
	@GetMapping("/")
	public Iterable<Usuario> listadoUsuarios(){
		return apiServicio.listarUsuarios();
	}
	@GetMapping("/{id}")
	public Usuario usuarioPorId(@PathVariable Long id) {
		return apiServicio.verUsuario(id);
	}
	@PostMapping("/")
	public Usuario registrarUsuario(@RequestBody Usuario usuario) {
		apiServicio.anadirUsuario(usuario);
		return usuario;
	}
	@DeleteMapping("/{id}")
	public void borrarUsuario(@PathVariable Long id) {
		apiServicio.borrarUsuario(id);
	}
	
	
	
	

}
