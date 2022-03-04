package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IInvestigadorDao;
import main.dto.Investigador;

@Service
public class InvestigadorServiceImpl implements IInvestigadorService {

	@Autowired
	IInvestigadorDao iInvestigadorDao;
	
	@Override
	public List<Investigador> listarInvestigador() {
		
		return iInvestigadorDao.findAll();
	}

	@Override
	public Investigador investigadorXID(String dni) {
		
		return iInvestigadorDao.findById(dni).get();
	}

	@Override
	public Investigador guardarInvestigador(Investigador investigador) {
		
		return iInvestigadorDao.save(investigador);
	}

	@Override
	public Investigador actualizarInvestigador(Investigador investigador) {
		
		return iInvestigadorDao.save(investigador);
	}

	@Override
	public void eliminarInvestigador(String dni) {
		
		iInvestigadorDao.deleteById(dni);
	}

}
