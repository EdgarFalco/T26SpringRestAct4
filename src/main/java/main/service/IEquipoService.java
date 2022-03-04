package main.service;

import java.util.List;

import main.dto.Equipo;

public interface IEquipoService {

	public List<Equipo> listarEquipo();
	
	public Equipo equipoXID(String num_serie);

	public Equipo guardarEquipo(Equipo equipo);	

	public Equipo actualizarEquipo(Equipo equipo);

	public void eliminarEquipo(String num_serie);
}
