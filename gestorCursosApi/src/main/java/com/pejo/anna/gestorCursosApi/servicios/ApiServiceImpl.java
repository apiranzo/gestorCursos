package com.pejo.anna.gestorCursosApi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pejo.anna.gestorCursosApi.entidades.Usuario;
import com.pejo.anna.gestorCursosApi.repositorios.UsuarioRepository;

import lombok.extern.java.Log;

@Log
@Service
public class ApiServiceImpl implements ApiService{
	
	// VARIABLES DE REPOSITORIO
	@Autowired 
	private UsuarioRepository usuarioRepository;

	
	// CONSTRUCTOR
	public ApiServiceImpl(UsuarioRepository usuarioRepository) {
		
		// INICIALIZACIÓN DE USUARIOS PARA LA DB
		usuarioRepository.save(Usuario.builder().nombre("anna").email("anna@gmail").password("1234").rol("ADMIN").build());
		usuarioRepository.save(Usuario.builder().nombre("javier").email("javier@gmail").password("1234").rol("USER").build());
		usuarioRepository.save(Usuario.builder().nombre("marta").email("marta@gmail").password("1234").rol("USER").build());
		usuarioRepository.save(Usuario.builder().nombre("iker").email("iker@gmail").password("1234").rol("USER").build());
		usuarioRepository.save(Usuario.builder().nombre("fina").email("fina@gmail").password("1234").rol("ADMIN").build());
		
		
		this.usuarioRepository = usuarioRepository;
	}


	// METHODS IMPLEMENTADOS
	@Override
	public void anadirUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		log.info("Se ha añadido el usuario " + usuario);
	}


	@Override
	public Iterable<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}


	@Override
	public Usuario verUsuario(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No existe usuario con id:" + id));
	}


	@Override
	public void modificarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}


	@Override
	@Transactional
	public void borrarUsuario(Long id) {
		if(!usuarioRepository.existsById(id)) {
			log.warning("Se ha intentado borrar un usuario que no existe: " + id);
			throw new ServiciosException("No existe el usuario a borrar");
		}	
		usuarioRepository.deleteById(id);
	}
	
}
