package com.game.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.proyecto.entity.Genero;
import com.game.proyecto.repository.GeneroRepository;

@Service
public class GeneroService {
	
	// injection
	@Autowired
	private GeneroRepository repoGenero;
	
	// list for form-select
	public List<Genero> listaGeneros(){
		return repoGenero.findAll();
	}

}
