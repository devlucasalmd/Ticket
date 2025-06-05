package com.br.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ticket.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
