package com.br.ticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.ticket.model.Inspector;
import com.br.ticket.model.User;
import com.br.ticket.repository.InspectorRepository;
import com.br.ticket.service.InspectorService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/inspector")
public class InspectorController {

	@Autowired
	public InspectorRepository inspectorRepository;

	@Autowired
	public InspectorService inspectorService;
	
	@PostMapping
	public Inspector create(@Valid @RequestBody Inspector inspector, HttpServletResponse response) {
		return inspectorRepository.save(inspector);
	}
	
	@GetMapping
	public List<Inspector> read() {
		return inspectorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Inspector> findById(@PathVariable Long id){
		Optional<Inspector> inspector = inspectorRepository.findById(id);
		if(inspector.isPresent()) {
			return ResponseEntity.ok(inspector.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Inspector> update(@PathVariable Long id, @Valid @RequestBody Inspector inspector){
		Inspector inspectorSaved = inspectorService.update(id, inspector);
		return ResponseEntity.ok(inspectorSaved);
	}
		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		inspectorRepository.deleteById(id);
	}
}
