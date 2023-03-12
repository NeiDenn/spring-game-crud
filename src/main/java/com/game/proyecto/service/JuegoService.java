package com.game.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.proyecto.entity.JuegoDTO;
import com.game.proyecto.repository.JuegoRepository;

@Service
public class JuegoService {
	
	// injection
	@Autowired
	private JuegoRepository repoJuego;
	
	// list
	public List<JuegoDTO> listaJuegos(){
		return repoJuego.findAll();
	}
	
	// save and update
	public void grabar(JuegoDTO bean) {
		repoJuego.save(bean);
	}
	
	// search
	public JuegoDTO buscar(Integer cod) {
		return repoJuego.findById(cod).orElse(null);
	}
	
	// delete
	public void eliminar(Integer cod) {
		repoJuego.deleteById(cod);
	}
}
