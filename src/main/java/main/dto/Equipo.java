package main.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "equipo")
public class Equipo {
	// Atributos
	@Id	
	private String num_serie;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "codigo")
	private Facultad facultad;

	@OneToMany
	@JoinColumn(name = "num")
	private List<Reserva> reserva;	

	// Constructores
	public Equipo() {
	}

	public Equipo(String num_serie, String nombre, Facultad facultad) {		
		this.num_serie = num_serie;
		this.nombre = nombre;
		this.facultad = facultad;
	}

	// Getters y setters
	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	//ToString
	@Override
	public String toString() {
		return "Equipo [num_serie=" + num_serie + ", nombre=" + nombre + ", facultad=" + facultad + "]";
	}	
}
