package com.br.ticket.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String name;
	
	@NotNull
	@Email
	private String email;
		
	@NotNull
	@Size(min = 8, max = 16)
	private String password;
	
	@NotNull
	@CPF
	@Column(unique = true)
	private String cpf;
	
	@NotNull
	@Column(name = "birth_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate birthDate;
	
	@NotNull
	private String phone;
	
	@NotNull
	private Boolean active;
}
