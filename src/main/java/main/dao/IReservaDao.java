package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Reserva;

public interface IReservaDao  extends JpaRepository<Reserva, Integer>{

}
