package com.game.proyecto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_gen")
	private Integer codGen;
	
	@Column(name = "nom_gen")
	private String nomGen;
	
	/* !important: previene un futuro error en la 
	 * busqueda x cod*/ 
	@JsonIgnore
	// one to many
	@OneToMany(mappedBy = "juegoGenero")
	private List<Juego> listaJuegos;

	// getters and setters
	public Integer getCodGen() {
		return codGen;
	}

	public void setCodGen(Integer codGen) {
		this.codGen = codGen;
	}

	public String getNomGen() {
		return nomGen;
	}

	public void setNomGen(String nomGen) {
		this.nomGen = nomGen;
	}

	public List<Juego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(List<Juego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}

	// constructors
	public Genero(Integer codGen, String nomGen, List<Juego> listaJuegos) {
		super();
		this.codGen = codGen;
		this.nomGen = nomGen;
		this.listaJuegos = listaJuegos;
	}

	public Genero() {
		super();
	}
}
