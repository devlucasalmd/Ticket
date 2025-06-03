package com.br.ticket.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.ticket.model.Street;
import com.br.ticket.repository.StreetRepository;

@Service
public class StreetService {

	@Autowired
	private StreetRepository streetRepository;
	
	public Street update(Long id, Street street) {
		Street streetSaved = findStreetById(id);
		BeanUtils.copyProperties(street, streetSaved, "id");
		return streetRepository.save(streetSaved);
	}
	
	public Street findStreetById(Long id) {
		Street streetSaved = streetRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return streetSaved;
	}
}
