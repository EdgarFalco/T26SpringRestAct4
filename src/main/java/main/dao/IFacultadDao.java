package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Facultad;

public interface IFacultadDao  extends JpaRepository<Facultad, Integer>{

}
