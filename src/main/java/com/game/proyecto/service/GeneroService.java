package com.game.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.proyecto.entity.GeneroDTO;
import com.game.proyecto.repository.GeneroRepository;

@Service
public class GeneroService {
	
	// injection
	@Autowired
	private GeneroRepository repoGenero;
	
	// list for form-select(combito)
	public List<GeneroDTO> listaGeneros(){
		return repoGenero.findAll();
	}

}
