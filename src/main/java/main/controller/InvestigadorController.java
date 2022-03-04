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

import main.dto.Investigador;
import main.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {
	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;

	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigador() {
		return investigadorServiceImpl.listarInvestigador();
	}

	@GetMapping("/investigadores/{dni}")
	public Investigador investigadorXID(@PathVariable(name = "num_serie") String dni) {

		Investigador investigador_xid = new Investigador();

		investigador_xid = investigadorServiceImpl.investigadorXID(dni);

		System.out.println("Investigador XID: " + investigador_xid);

		return investigador_xid;
	}

	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {

		return investigadorServiceImpl.guardarInvestigador(investigador);
	}

	@PutMapping("/investigadores/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name = "dni") String dni, @RequestBody Investigador investigador) {

		Investigador investigador_seleccionada = new Investigador();
		Investigador investigador_actualizada = new Investigador();

		investigador_seleccionada = investigadorServiceImpl.investigadorXID(dni);

		investigador_seleccionada.setNombre(investigador.getNombre());

		investigador_actualizada = investigadorServiceImpl.actualizarInvestigador(investigador_seleccionada);

		System.out.println("El investigador actualizado es: " + investigador_actualizada);

		return investigador_actualizada;
	}

	@DeleteMapping("/investigadores/{dni}")
	public void eliminarInvestigador(@PathVariable(name = "dni") String dni) {
		investigadorServiceImpl.eliminarInvestigador(dni);
	}

}
