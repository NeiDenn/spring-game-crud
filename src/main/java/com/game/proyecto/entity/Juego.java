package com.game.proyecto.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_juego")
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_jue")
	private Integer codJue;
	
	@Column(name = "tit_jue")
	private String titJue;
	
	@Column(name = "des_jue")
	private String desJue;
	
	@Column(name = "pre_jue")
	private BigDecimal preJue;
	
	// Date - java.util
	@Temporal(TemporalType.DATE)
	@Column(name="fec_lan_jue")
	private Date fecLanJue;
	
	// many to one
	@ManyToOne
	@JoinColumn(name = "cod_gen")
	private Genero juegoGenero;
	
	// many to one
	@ManyToOne
	@JoinColumn(name = "cod_des")
	private Desarrolladora juegoDesarrolladora;

	// getters and setters
	public Integer getCodJue() {
		return codJue;
	}

	public void setCodJue(Integer codJue) {
		this.codJue = codJue;
	}

	public String getTitJue() {
		return titJue;
	}

	public void setTitJue(String titJue) {
		this.titJue = titJue;
	}

	public String getDesJue() {
		return desJue;
	}

	public void setDesJue(String desJue) {
		this.desJue = desJue;
	}

	public BigDecimal getPreJue() {
		return preJue;
	}

	public void setPreJue(BigDecimal preJue) {
		this.preJue = preJue;
	}

	public Date getFecLanJue() {
		return fecLanJue;
	}

	public void setFecLanJue(Date fecLanJue) {
		this.fecLanJue = fecLanJue;
	}

	public Genero getJuegoGenero() {
		return juegoGenero;
	}

	public void setJuegoGenero(Genero juegoGenero) {
		this.juegoGenero = juegoGenero;
	}

	public Desarrolladora getJuegoDesarrolladora() {
		return juegoDesarrolladora;
	}

	public void setJuegoDesarrolladora(Desarrolladora juegoDesarrolladora) {
		this.juegoDesarrolladora = juegoDesarrolladora;
	}

	// constructors
	public Juego(Integer codJue, String titJue, String desJue, BigDecimal preJue, Date fecLanJue,
			Genero juegoGenero, Desarrolladora juegoDesarrolladora) {
		super();
		this.codJue = codJue;
		this.titJue = titJue;
		this.desJue = desJue;
		this.preJue = preJue;
		this.fecLanJue = fecLanJue;
		this.juegoGenero = juegoGenero;
		this.juegoDesarrolladora = juegoDesarrolladora;
	}

	public Juego() {
		super();
	}
}
