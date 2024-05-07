package com.pejo.anna.gestorCursosApi.dto;

import com.pejo.anna.gestorCursosApi.entidades.Alumno;
import com.pejo.anna.gestorCursosApi.entidades.Curso;
import com.pejo.anna.gestorCursosApi.entidades.Nota;

public record CursoAlumnoNotaDto(Curso curso, Alumno alumno, Nota nota) {

}
