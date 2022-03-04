package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Equipo;

public interface IEquipoDao extends JpaRepository<Equipo, String> {

}
