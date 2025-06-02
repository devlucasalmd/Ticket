package com.br.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ticket.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
