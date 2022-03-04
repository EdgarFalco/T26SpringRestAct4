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

import main.dto.Facultad;
import main.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {
	
	@Autowired
	FacultadServiceImpl facultadServiceImpl;

	@GetMapping("/facultades")
	public List<Facultad> listarFacultad() {
		return facultadServiceImpl.listarFacultad();
	}

	@GetMapping("/facultades/{codigo}")
	public Facultad facultadXID(@PathVariable(name = "codigo") Integer codigo) {

		Facultad facultad_xid = new Facultad();

		facultad_xid = facultadServiceImpl.facultadXID(codigo);

		System.out.println("Facultad XID: " + facultad_xid);

		return facultad_xid;
	}

	@PostMapping("/facultades")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {

		return facultadServiceImpl.guardarFacultad(facultad);
	}

	@PutMapping("/facultades/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name = "codigo") Integer codigo, @RequestBody Facultad facultad) {

		Facultad facultad_seleccionada = new Facultad();
		Facultad facultad_actualizada = new Facultad();

		facultad_seleccionada = facultadServiceImpl.facultadXID(codigo);

		facultad_seleccionada.setNombre(facultad.getNombre());

		facultad_actualizada = facultadServiceImpl.actualizarFacultad(facultad_seleccionada);

		System.out.println("La facultad actualizado es: " + facultad_actualizada);

		return facultad_actualizada;
	}

	@DeleteMapping("/facultades/{codigo}")
	public void eliminarFacultad(@PathVariable(name = "codigo") Integer codigo) {
		facultadServiceImpl.eliminarFacultad(codigo);
	}

}
