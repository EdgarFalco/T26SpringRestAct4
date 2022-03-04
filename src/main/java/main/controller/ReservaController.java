package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Reserva;
import main.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	ReservaServiceImpl reservaServiceImpl;

	@GetMapping("/reservas")
	public List<Reserva> listarReserva() {
		return reservaServiceImpl.listarReserva();
	}

	@GetMapping("/reservas/{id}")
	public Reserva reservaXID(@PathVariable(name = "id") Integer id) {

		Reserva reserva_xid = new Reserva();

		reserva_xid = reservaServiceImpl.reservaXID(id);

		System.out.println("Reserva XID: " +reserva_xid);

		return reserva_xid;
	}

	@PostMapping("/reservas")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {

		return reservaServiceImpl.guardarReserva(reserva);
	}

	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") Integer id, @RequestBody Reserva reserva) {

		Reserva reserva_seleccionada = new Reserva();
		Reserva reserva_actualizada = new Reserva();

		reserva_seleccionada = reservaServiceImpl.reservaXID(id);

		reserva_seleccionada.setId(reserva.getId());

		reserva_actualizada = reservaServiceImpl.actualizarReserva(reserva_seleccionada);

		System.out.println("La reserva actualizada es: " + reserva_actualizada);

		return reserva_actualizada;
	}

	@DeleteMapping("/reservas/{id}")
	public void eliminarReserva(@PathVariable(name = "id") Integer id) {
		reservaServiceImpl.eliminarReserva(id);
	}

}
