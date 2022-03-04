package main.service;

import java.util.List;

import main.dto.Reserva;

public interface IReservaService {

	public List<Reserva> listarReserva();
	
	public Reserva reservaXID(Integer id);

	public Reserva guardarReserva(Reserva reserva);	

	public Reserva actualizarReserva(Reserva reserva);

	public void eliminarReserva(Integer id);
}
