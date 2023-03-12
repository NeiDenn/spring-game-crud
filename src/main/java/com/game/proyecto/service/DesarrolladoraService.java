package com.game.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.proyecto.entity.DesarrolladoraDTO;
import com.game.proyecto.repository.DesarrolladoraRepository;

@Service
public class DesarrolladoraService {

	// injection
	@Autowired
	private DesarrolladoraRepository repoDesarrolladora;
	
	// list for form-select(combito)
	public List<DesarrolladoraDTO> listaDesarrolladoras(){
		return repoDesarrolladora.findAll();
	}
	
}
