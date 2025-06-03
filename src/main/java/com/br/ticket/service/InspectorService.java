package com.br.ticket.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.ticket.model.Inspector;
import com.br.ticket.repository.InspectorRepository;

@Service
public class InspectorService {

	@Autowired
	private InspectorRepository inspectorRepository;
	
	public Inspector update(Long id, Inspector inspector) {
		Inspector inspectorSaved = findInspectorById(id);
		BeanUtils.copyProperties(inspector, inspectorSaved, "id");
		return inspectorRepository.save(inspectorSaved);
	}
	
	public Inspector findInspectorById(Long id) {
		Inspector inspectorSaved = inspectorRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return inspectorSaved;
	}
}
