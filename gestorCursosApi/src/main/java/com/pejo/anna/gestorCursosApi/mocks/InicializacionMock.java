package com.pejo.anna.gestorCursosApi.mocks;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;
import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.entidades.Nota;
import com.pejo.anna.gestorCursosApi.repositorios.AlumnoRepository;
import com.pejo.anna.gestorCursosApi.repositorios.CursoRepository;
import com.pejo.anna.gestorCursosApi.repositorios.NotaRepository;

@Component
public class InicializacionMock {
	public InicializacionMock(AlumnoRepository alumnoRepository, CursoRepository cursoRepository,
			NotaRepository notaRepository) {
		
		// INICIALIZACIÓN DE DATOS PARA LA DB
		var anna = alumnoRepository.save(Alumno.builder().nombre("Anna").apellidos("Pejó").build());
		var pep = alumnoRepository.save(Alumno.builder().nombre("Pep").apellidos("Perez").build());
		var jaume = alumnoRepository.save(Alumno.builder().nombre("Jaume").apellidos("Margarita").build());
		var miriam = alumnoRepository.save(Alumno.builder().nombre("Miriam").apellidos("Jon").build());
		var fina = alumnoRepository.save(Alumno.builder().nombre("Fina").apellidos("Jon").build());


		var catala = cursoRepository.save(Curso.builder().nombreCurso("Catalá").build());
		var castella = cursoRepository.save(Curso.builder().nombreCurso("Castellà").build());
		var historia = cursoRepository.save(Curso.builder().nombreCurso("História").build());
		var filosofia = cursoRepository.save(Curso.builder().nombreCurso("Filosofia").build());
		
		notaRepository.save(Nota.builder().alumno(anna).curso(catala).valor(new BigDecimal(5.5)).build());
		notaRepository.save(Nota.builder().alumno(anna).curso(castella).valor(new BigDecimal(7.5)).build());
		notaRepository.save(Nota.builder().alumno(anna).curso(historia).valor(new BigDecimal(3.5)).build());
		
		notaRepository.save(Nota.builder().alumno(pep).curso(catala).valor(new BigDecimal(2.5)).build());
		notaRepository.save(Nota.builder().alumno(pep).curso(historia).valor(new BigDecimal(5.5)).build());
		notaRepository.save(Nota.builder().alumno(pep).curso(filosofia).valor(new BigDecimal(10.5)).build());
		
		notaRepository.save(Nota.builder().alumno(jaume).curso(castella).valor(new BigDecimal(4.5)).build());
		notaRepository.save(Nota.builder().alumno(jaume).curso(historia).valor(new BigDecimal(8.5)).build());
		notaRepository.save(Nota.builder().alumno(jaume).curso(filosofia).valor(new BigDecimal(9.5)).build());

		notaRepository.save(Nota.builder().alumno(miriam).curso(catala).valor(new BigDecimal(3.5)).build());
		notaRepository.save(Nota.builder().alumno(miriam).curso(castella).valor(new BigDecimal(2.5)).build());
		notaRepository.save(Nota.builder().alumno(miriam).curso(filosofia).valor(new BigDecimal(10)).build());
		
		notaRepository.save(Nota.builder().alumno(fina).curso(catala).valor(null).build());
		notaRepository.save(Nota.builder().alumno(fina).curso(castella).valor(new BigDecimal(7.5)).build());
		notaRepository.save(Nota.builder().alumno(fina).curso(historia).valor(new BigDecimal(3.5)).build());
	}

}
