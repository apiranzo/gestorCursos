package com.pejo.anna.gestorCursosApi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;

@RepositoryRestResource(path = "alumnos", collectionResourceRel = "alumnos")
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
