package main.service;

import java.util.List;

import main.dto.Investigador;

public interface IInvestigadorService {
	public List<Investigador> listarInvestigador();
	
	public Investigador investigadorXID(String dni);

	public Investigador guardarInvestigador(Investigador investigador);	

	public Investigador actualizarInvestigador(Investigador investigador);

	public void eliminarInvestigador(String dni);
}
