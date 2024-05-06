package com.pejo.anna.gestorCursosApi.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "El nombre del Curso debe ser rellenado")
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "nombre_cursos")
	private String nombreCurso;
	
	@Past
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_fin")
	private LocalDate fechaFin;

}
