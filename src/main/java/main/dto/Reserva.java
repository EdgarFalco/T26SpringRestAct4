package main.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "investigador")
	private Investigador investigador;
	
	@ManyToOne
	@JoinColumn(name = "equipo")
	private Equipo equipo;
	
	private String comienzo;
	private String fin;	

	// Constructores
	public Reserva() {
	}

	public Reserva(int id, Investigador investigador, Equipo equipo, String comienzo, String fin) {		
		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComienzo() {
		return comienzo;
	}

	public void setComienzo(String comienzo) {
		this.comienzo = comienzo;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	// ToString
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", comienzo=" + comienzo + ", fin=" + fin + ", equipo=" + equipo
				+ ", investigador=" + investigador + "]";
	}
}
