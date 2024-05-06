package com.pejo.anna.gestorCursosApi.entidades;

import java.math.BigDecimal;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "notas")
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Nullable
	@Min(0)
	@Positive
	@Digits(integer = 7, fraction = 2)
	@Column(name = "valor")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "id_alumno")
	private Alumno alumno;

	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
}
