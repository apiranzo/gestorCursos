package com.pejo.anna.gestorCursosApi.servicios;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;
import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.entidades.Nota;

public interface GestorService {
	
	default void anadirAlumno(Alumno alumno) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Alumno> listarAlumnos(){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Alumno verAlumno(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void modificarAlumno(Alumno alumno) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void borrarAlumno(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	//************************************************************//
	
	default void anadirCurso(Curso curso) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Curso> listarCursos(){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Curso verCurso(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void modificarCurso(Curso curso) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void borrarCurso(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	//************************************************************//
	
	default void anadirNota(Nota nota) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Nota> listarNotas(){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Nota verNota(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void modificarNota(Nota nota) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void borrarNota(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	//*************************************************************//
	default Iterable<Alumno> listarAlumnosCurso(Long idCurso){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	default Iterable<Curso> listarCursosAlumno(Long idAlumno){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	default Long totalAlumnosAprobadosCurso(Long idCurso){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	default Long totalAlumnosCurso(Long idCurso) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	default Iterable<Alumno> listarAlumnosAprobadosDeCurso(Long idCurso){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	default Long porcentajeAlumnosCurso(Long idCurso) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	default Iterable<Nota> listadoNotasAlumno(Long idAlumno){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	

}
