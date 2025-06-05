package com.br.ticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ticket.model.Vehicle;
import com.br.ticket.repository.VehicleRepository;
import com.br.ticket.service.VehicleService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	public Vehicle create(@Valid @RequestBody Vehicle vehicle, HttpServletResponse response) {
		return vehicleRepository.save(vehicle);
	}
	
	@GetMapping
	public List<Vehicle> read(){
		return vehicleRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> findById(@PathVariable Long id){
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		
		if(vehicle.isPresent()) {
			return ResponseEntity.ok(vehicle.get());			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vehicle> update(@PathVariable Long id, @Valid @RequestBody Vehicle vehicle){
		Vehicle vehicleSaved = vehicleService.update(id, vehicle);
		return ResponseEntity.ok(vehicleSaved);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		vehicleRepository.deleteById(id);
	}
		
}
