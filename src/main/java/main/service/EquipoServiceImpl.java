package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IEquipoDao;
import main.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService{

	@Autowired
	IEquipoDao iEquipoDao;
	
	@Override
	public List<Equipo> listarEquipo() {
		
		return iEquipoDao.findAll();
	}

	@Override
	public Equipo equipoXID(String num_serie) {
		
		return iEquipoDao.findById(num_serie).get();
	}

	@Override
	public Equipo guardarEquipo(Equipo equipo) {
		
		return iEquipoDao.save(equipo);
	}

	@Override
	public Equipo actualizarEquipo(Equipo equipo) {
		
		return iEquipoDao.save(equipo);
	}

	@Override
	public void eliminarEquipo(String num_serie) {
		
		iEquipoDao.deleteById(num_serie);
	}

}
