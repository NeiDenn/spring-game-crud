package com.game.proyecto.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.game.proyecto.entity.Desarrolladora;
import com.game.proyecto.entity.Genero;
import com.game.proyecto.entity.Juego;
import com.game.proyecto.service.DesarrolladoraService;
import com.game.proyecto.service.GeneroService;
import com.game.proyecto.service.JuegoService;

@Controller
@RequestMapping("/juego")
public class JuegoController {

	// injection
	@Autowired
	private JuegoService serviJuego;
	@Autowired
	private GeneroService serviGenero;
	@Autowired
	private DesarrolladoraService serviDesarrolladora;
	
	// link list-table
	@RequestMapping("/lista")
	public String inicio(Model model) {
		
		// recuperar list of games
		List<Juego> dataJuego = serviJuego.listaJuegos();
		// recuperar list genre para form-select
		List<Genero> dataGenero = serviGenero.listaGeneros();
		// recuperar list desarrolladora para form-select
		List<Desarrolladora> dataDesarrolladora = serviDesarrolladora.listaDesarrolladoras();
		
		// atributos para enviar al html
		model.addAttribute("listaJuegos", dataJuego);
		model.addAttribute("listaGeneros", dataGenero);
		model.addAttribute("listaDesarrolladoras", dataDesarrolladora);
		
		// return "".hmtl
		return "juego";
	}
	
	// link save and update
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("txtCodigo") int cod, @RequestParam("txtTitulo") String tit,
			@RequestParam("txtDescripcion") String desc, @RequestParam("txtPrecio") BigDecimal pre,
			@RequestParam("txtFecha") String fec, @RequestParam("txtGenero") int genero, 
			@RequestParam("txtDesarrolladora") int desarrolladora, RedirectAttributes redirect) {

		try {
			// object
			Juego objJuego= new Juego();

			// set
			objJuego.setCodJue(cod);
			objJuego.setTitJue(tit);
			objJuego.setDesJue(desc);
			objJuego.setPreJue(pre);
			// date.java
			objJuego.setFecLanJue(new SimpleDateFormat("yyyy-MM-dd").parse(fec));

			// create objects
			Genero objGenero = new Genero();
			objGenero.setCodGen(genero);
			Desarrolladora objDesarrolladora = new Desarrolladora();
			objDesarrolladora.setCodDes(desarrolladora);

			// send object
			objJuego.setJuegoGenero(objGenero);
			objJuego.setJuegoDesarrolladora(objDesarrolladora);

			// call method y object
			serviJuego.grabar(objJuego);

			// message
			if (cod > 0) {
				// si encuentra un cod mayor a 0; actualiza
				redirect.addFlashAttribute("mensaje", "El juego " + objJuego.getTitJue().toUpperCase() + " se actualizó correctamente.");
				redirect.addFlashAttribute("tipo", "alert-primary");
			} else {
				// si cod null; registra
				redirect.addFlashAttribute("mensaje", "El juego " + objJuego.getTitJue().toUpperCase() + " se registró correctamente.");
				redirect.addFlashAttribute("tipo", "alert-success");
			}

		} catch (Exception e) {
			redirect.addAttribute("mensaje", "Hubo un problema en el momento de grabar este registro!");
			redirect.addFlashAttribute("tipo", "alert-danger");
			e.printStackTrace();
		}
		
		return "redirect:/juego/lista";
	}
	
	// search x cod
	@RequestMapping("/buscar")
	@ResponseBody
	public Juego buscar(@RequestParam("buscarCodigo") int cod) {
		// call method search
		Juego objJuego = serviJuego.buscar(cod);
		
		return objJuego;
	}
	
	// link delete
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("buscarCodigo") int cod, RedirectAttributes redirect) {

		// object
		Juego objJuego = new Juego();
		objJuego.setCodJue(cod);

		try {
			// call method delete
			serviJuego.eliminar(cod);
			redirect.addFlashAttribute("mensaje", "El juego con el Codigo: " + objJuego.getCodJue() + " fue eliminado correctamente.");
			redirect.addFlashAttribute("tipo", "alert-danger");
		} catch (Exception e) {
			redirect.addFlashAttribute("mensaje", "Hubo un problema en eliminar este registro!");
			redirect.addFlashAttribute("tipo", "alert-danger");
			e.printStackTrace();
		}

		return "redirect:/juego/lista";
	}
}
