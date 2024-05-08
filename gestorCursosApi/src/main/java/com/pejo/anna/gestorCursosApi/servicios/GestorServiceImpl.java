package com.pejo.anna.gestorCursosApi.servicios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;
import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.entidades.Nota;
import com.pejo.anna.gestorCursosApi.mocks.InicializacionMock;
import com.pejo.anna.gestorCursosApi.repositorios.AlumnoRepository;
import com.pejo.anna.gestorCursosApi.repositorios.CursoRepository;
import com.pejo.anna.gestorCursosApi.repositorios.NotaRepository;

@Service
public class GestorServiceImpl implements GestorService{
	
	// VARIABLES DE REPOSITORIO
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private NotaRepository notaRepository;
	
	private InicializacionMock initMock;

	// METHODS IMPLEMENTADOS
	@Override
	public void anadirAlumno(Alumno alumno) {
		alumnoRepository.save(alumno);
	}

	@Override
	public Iterable<Alumno> listarAlumnos() {
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno verAlumno(Long id) {
		return alumnoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No existe alumno con id:" + id));
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		alumnoRepository.save(alumno);
	}

	@Override
	public void borrarAlumno(Long id) {
		alumnoRepository.deleteById(id);
	}

//******************************************//
	@Override
	public void anadirCurso(Curso curso) {
		cursoRepository.save(curso);
	}

	@Override
	public Iterable<Curso> listarCursos() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso verCurso(Long id) {
		return cursoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe curso con id:" + id));
	}

	@Override
	public void modificarCurso(Curso curso) {
		cursoRepository.save(curso);
	}

	@Override
	public void borrarCurso(Long id) {
		cursoRepository.deleteById(id);
	}
	
//*****************************************//
	@Override
	public void anadirNota(Nota nota) {
		notaRepository.save(nota);
	}

	@Override
	public Iterable<Nota> listarNotas() {
		return notaRepository.findAll();
	}

	@Override
	public Nota verNota(Long id) {
		return notaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe nota con id:" + id));
	}

	@Override
	public void modificarNota(Nota nota) {
		notaRepository.save(nota);
	}

	@Override
	public void borrarNota(Long id) {
		notaRepository.deleteById(id);
	}
	
//********************************************//

	@Override
	public Iterable<Alumno> listarAlumnosCurso(Long id) {
		return notaRepository.obtenerAlumnosDeCurso(id);
	}

	@Override
	public Iterable<Curso> listarCursosAlumno(Long id) {
		return notaRepository.obtenerCursosDeAlumno(id);
	}

	@Override
	public Long totalAlumnosAprobadosCurso(Long idCurso) {
		return notaRepository.totalAlumnosAprobadosDeCurso(idCurso);
	}

	@Override
	public Long totalAlumnosCurso(Long idCurso) {
		return notaRepository.totalAlumnosDeCurso(idCurso);
	}

	@Override
	public Iterable<Alumno> listarAlumnosAprobadosDeCurso(Long idCurso) {
		return notaRepository.listadoAlumnosAprobadosDeCurso(idCurso);
	}

	@Override
	public Long porcentajeAlumnosCurso(Long idCurso) {
		
		var totalNota = notaRepository.totalAlumnosAprobadosDeCurso(idCurso);
		var totalAlum = notaRepository.totalAlumnosDeCurso(idCurso);
		
		if (totalAlum == 0) {
	        return 0L; // If there are no students in the course, return 0%
	    }
	    
	    // Calculate percentage with floating-point division, then round to Long
		double percentage = (totalNota * 100.0) / totalAlum;
	    Long resultado = Math.round(percentage);
	    System.out.println(totalNota);
	    System.out.println(totalAlum);
	    System.out.println(resultado);
	    return resultado;
		
	}

	@Override
	public Iterable<Nota> listadoNotasAlumno(Long idAlumno) {
		return notaRepository.listadoNotasAlumno(idAlumno);
	}

	@Override
	public Long noPresentados(Long idCurso) {
		return notaRepository.noPresentadosCurso(idCurso);
	}

	@Override
	public void inscribirAlumnoCursoNota(Long idAlumno, Long idCurso, BigDecimal valor) {
		notaRepository.gestionNotaAlumnoCurso(idAlumno, idCurso, valor);
	}
	
		
}
