package main.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "facultad")
public class Facultad {
	// Atributos
	@Id	
	private int codigo;
	private String nombre;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Equipo> equipo;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Investigador> investigador;

	// Constructores
	public Facultad() {
	}

	public Facultad(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	// Getters y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigador() {
		return investigador;
	}

	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}

	// toString
	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
}
