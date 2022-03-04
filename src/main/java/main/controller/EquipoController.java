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

import main.dto.Equipo;
import main.service.EquipoServiceImpl;



@RestController
@RequestMapping("/api")
public class EquipoController {
	
	@Autowired
	EquipoServiceImpl equipoServiceImpl;

	@GetMapping("/equipos")
	public List<Equipo> listarEquipo() {
		return equipoServiceImpl.listarEquipo();
	}
	
	@GetMapping("/equipos/{num_serie}")
	public Equipo equipoXID(@PathVariable(name = "num_serie") String num_serie) {

		Equipo equipo_xid = new Equipo();

		equipo_xid = equipoServiceImpl.equipoXID(num_serie);

		System.out.println("Equipo XID: " + equipo_xid);

		return equipo_xid;
	}

	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {

		return equipoServiceImpl.guardarEquipo(equipo);
	}

	@PutMapping("/equipos/{num_serie}")
	public Equipo actualizarEquipo(@PathVariable(name = "num_serie") String num_serie, @RequestBody Equipo equipo) {

		Equipo equipo_seleccionada = new Equipo();
		Equipo equipo_actualizada = new Equipo();

		equipo_seleccionada = equipoServiceImpl.equipoXID(num_serie);

		equipo_seleccionada.setNombre(equipo.getNombre());

		equipo_actualizada = equipoServiceImpl.actualizarEquipo(equipo_seleccionada);

		System.out.println("El equipo actualizado es: " + equipo_actualizada);

		return equipo_actualizada;
	}

	@DeleteMapping("/equipos/{num_serie}")
	public void eliminarEquipo(@PathVariable(name = "num_serie") String num_serie) {
		equipoServiceImpl.eliminarEquipo(num_serie);
	}

}
