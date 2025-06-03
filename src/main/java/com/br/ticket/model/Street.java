package com.br.ticket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "street")
public class Street {

    @Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String street_name;
    
    @NotNull
    private String cep;
}
