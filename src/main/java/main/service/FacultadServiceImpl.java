package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IFacultadDao;
import main.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService {

	@Autowired
	IFacultadDao iFacultadDao;
	
	@Override
	public List<Facultad> listarFacultad() {
		
		return iFacultadDao.findAll();
	}

	@Override
	public Facultad facultadXID(Integer codigo) {
		
		return iFacultadDao.findById(codigo).get();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		
		return iFacultadDao.save(facultad);
	}

	@Override
	public Facultad actualizarFacultad(Facultad facultad) {
		
		return iFacultadDao.save(facultad);
	}

	@Override
	public void eliminarFacultad(Integer codigo) {
		
		iFacultadDao.deleteById(codigo);
	}

}
