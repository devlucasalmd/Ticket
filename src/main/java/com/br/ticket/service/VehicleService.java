package com.br.ticket.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.ticket.model.Vehicle;
import com.br.ticket.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle update(Long id, Vehicle vehicle) {
		Vehicle vehicleSaved = findVehicleById(id);
		BeanUtils.copyProperties(vehicle, vehicleSaved, "id");
		return vehicleRepository.save(vehicleSaved);
	}
	
	public Vehicle findVehicleById(Long id) {
		Vehicle vehicleSaved = vehicleRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return vehicleSaved;
	}
}
