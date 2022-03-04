package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IReservaDao;
import main.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	IReservaDao iReservaDao;
	
	@Override
	public List<Reserva> listarReserva() {
		
		return iReservaDao.findAll();
	}

	@Override
	public Reserva reservaXID(Integer id) {
		
		return iReservaDao.findById(id).get();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		
		return iReservaDao.save(reserva);
	}

	@Override
	public Reserva actualizarReserva(Reserva reserva) {
		
		return iReservaDao.save(reserva);
	}

	@Override
	public void eliminarReserva(Integer id) {
		
		iReservaDao.deleteById(id);
	}
}
