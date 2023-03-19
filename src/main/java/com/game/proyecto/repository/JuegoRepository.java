package com.game.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.proyecto.entity.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer>{

}
