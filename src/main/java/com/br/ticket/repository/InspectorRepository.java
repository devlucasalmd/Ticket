package com.br.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ticket.model.Inspector;

public interface InspectorRepository extends JpaRepository<Inspector, Long> {

}
