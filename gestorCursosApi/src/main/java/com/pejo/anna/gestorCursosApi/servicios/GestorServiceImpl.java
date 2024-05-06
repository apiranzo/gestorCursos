package com.pejo.anna.gestorCursosApi.servicios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;
import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.entidades.Nota;
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
	
	public GestorServiceImpl(AlumnoRepository alumnoRepository, CursoRepository cursoRepository,
			NotaRepository notaRepository) {
		
		// INICIALIZACIÓN DE DATOS PARA LA DB
		var anna = alumnoRepository.save(Alumno.builder().nombre("Anna").apellidos("Pejó").build());
		var pep = alumnoRepository.save(Alumno.builder().nombre("Pep").apellidos("Perez").build());
		var jaume = alumnoRepository.save(Alumno.builder().nombre("Jaume").apellidos("Margarita").build());
		var miriam = alumnoRepository.save(Alumno.builder().nombre("Miriam").apellidos("Jon").build());

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

		
		
		this.alumnoRepository = alumnoRepository;
		this.cursoRepository = cursoRepository;
		this.notaRepository = notaRepository;
	}

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
	public Long porcentajeAlumnosCurso(Long idCurso, Long totalAlumnos) {
		
		var totalNota = notaRepository.totalAlumnosAprobadosDeCurso(totalAlumnos);
		var totalAlum = notaRepository.totalAlumnosDeCurso(idCurso);
		Long resultado = (long) ((totalNota / totalAlum) * 100.0);
		return resultado;
		
	}

	@Override
	public Iterable<Nota> listadoNotasAlumno(Long idAlumno) {
		return notaRepository.listadoNotasAlumno(idAlumno);
	}
	
	
}