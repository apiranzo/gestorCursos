package com.pejo.anna.gestorCursosApi.repositorios;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;
import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.entidades.Nota;

@RepositoryRestResource(path = "notas", collectionResourceRel = "notas")
public interface NotaRepository extends JpaRepository<Nota, Long>{
	
	// Consulta JPQL para obtener los alumnos de un curso específico
	@Query("SELECT n.alumno FROM Nota n WHERE n.curso.id = :idCurso")
	Iterable<Alumno> obtenerAlumnosDeCurso(@Param("idCurso") Long idCurso);
    
	// Consulta JPQL para obtener los cursos de un alumno específico
    
    @Query("SELECT n.curso FROM Nota n WHERE n.alumno.id = :idAlumno")
    Iterable<Curso> obtenerCursosDeAlumno(@Param("idAlumno") Long idAlumno);
    
    // Consulta JPQL para obtener el TOTAL de alumnos de un curso específico
    @Query("SELECT COUNT(DISTINCT n.alumno) FROM Nota n WHERE n.curso.id = :idCurso")
	Long totalAlumnosDeCurso(@Param("idCurso") Long idCurso);
    
    // Consulta JPQL para obtener el TOTAL de alumnos aprobados de un curso específico
    @Query("SELECT COUNT(DISTINCT n.alumno) FROM Nota n WHERE n.curso.id = :idCurso AND n.valor >= 5")
	Long totalAlumnosAprobadosDeCurso(@Param("idCurso") Long idCurso);
    
    // Consulta JPQL para obtener TODOS los alumnos aprobados de un curso específico
    @Query("SELECT DISTINCT n.alumno FROM Nota n WHERE n.curso.id = :idCurso AND n.valor >= 5")
	Iterable<Alumno> listadoAlumnosAprobadosDeCurso(@Param("idCurso") Long idCurso);
        
    // Consulta JPQL para obtener Notas y Cursos de UN alumno específico
    @Query("FROM Nota n  WHERE n.alumno.id = :idAlumno")
    Iterable<Nota> listadoNotasAlumno(@Param("idAlumno") Long idAlumno);
    
    // Consulta JPQL para obtener No PRESENTADOS de un Curso
    @Query("SELECT COUNT(DISTINCT n.id) FROM Nota n WHERE n.curso.id = :idCurso AND n.valor IS NULL")
    Long noPresentadosCurso(@Param("idCurso") Long idCurso);
    
    //Consulta JPQL para INSERTAR Alumno dentro de un Curso
    @Transactional
    @Modifying
    @Query("INSERT INTO Nota (alumno, curso, valor) SELECT a, c, :valor FROM Alumno a, Curso c WHERE c.id = :cursoId AND a.id = :alumnoId")
    void gestionNotaAlumnoCurso(@Param("alumnoId") Long alumnoId, @Param("cursoId") Long cursoId, @Param("valor") BigDecimal valor);   

}
