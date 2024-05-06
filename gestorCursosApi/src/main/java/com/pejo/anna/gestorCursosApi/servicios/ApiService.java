package com.pejo.anna.gestorCursosApi.servicios;

import com.pejo.anna.gestorCursosApi.entidades.Usuario;

public interface ApiService {
	
	default void anadirUsuario(Usuario usuario) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Usuario> listarUsuarios(){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Usuario verUsuario(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void modificarUsuario(Usuario usuario) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void borrarUsuario(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void loginUsuario(Usuario usuario) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

}
