package com.pejo.anna.gestorCursosApi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pejo.anna.gestorCursosApi.entidades.Curso;

@RepositoryRestResource(path = "cursos", collectionResourceRel = "cursos")
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
