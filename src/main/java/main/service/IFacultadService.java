package main.service;

import java.util.List;

import main.dto.Facultad;

public interface IFacultadService {

	public List<Facultad> listarFacultad();
	
	public Facultad facultadXID(Integer codigo);

	public Facultad guardarFacultad(Facultad facultad);	

	public Facultad actualizarFacultad(Facultad facultad);

	public void eliminarFacultad(Integer codigo);
}
