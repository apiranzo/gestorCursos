package com.pejo.anna.gestorCursosApi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 3, max = 50)
	private String nombre;
	
	@Email
	@NotNull(message = "El correo es obligatorio")
	@NotBlank
	@Size(max = 100)
	private String email;

	@NotNull
	@NotBlank
	@Size(min = 3, max = 100)
	private String password;
	
	@NotNull
	@NotBlank
	private String rol;

}
