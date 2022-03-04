package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "investigador")
public class Investigador {
	// Atributos
	@Id
	private String dni;
	@Column(name = "nom_apels")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "codigo")
	private Facultad facultad;

	@OneToMany
	@JoinColumn(name = "investigador")
	private List<Reserva> reserva;	

	// Constructores
	public Investigador() {
	}

	public Investigador(String dni, String nombre, Facultad facultad) {
		this.dni = dni;
		this.nombre = nombre;
		this.facultad = facultad;
	}

	// Getters and Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	// ToString
	@Override
	public String toString() {
		return "Investigador [dni=" + dni + ", nombre=" + nombre + ", facultad=" + facultad + "]";
	}
}
