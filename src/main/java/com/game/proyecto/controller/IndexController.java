package com.game.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.game.proyecto.repository.DesarrolladoraRepository;
import com.game.proyecto.repository.GeneroRepository;
import com.game.proyecto.repository.JuegoRepository;

@Controller
public class IndexController {
	
	// injection
	@Autowired
	private JuegoRepository repoJuego;
	@Autowired
	private DesarrolladoraRepository repoDesarrolladora;
	@Autowired
	private GeneroRepository repoGenero;
	
	@RequestMapping("/index")
	public String inicio(Model model) {
		
		// guardar el numero de entidades disponibles
		Long juegos = repoJuego.count();
		Long desarrolladoras = repoDesarrolladora.count();
		Long generos = repoGenero.count();
		
		model.addAttribute("cantJuegos", juegos);
		model.addAttribute("cantDesarrolladoras", desarrolladoras);
		model.addAttribute("cantGeneros", generos);
		
		return "index";
	}

}
