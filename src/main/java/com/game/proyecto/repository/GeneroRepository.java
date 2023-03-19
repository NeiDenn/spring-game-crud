package com.game.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.proyecto.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{

}
