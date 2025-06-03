package com.br.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ticket.model.Street;

public interface StreetRepository extends JpaRepository<Street, Long>{

}
