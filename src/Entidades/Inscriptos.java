package Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Inscriptos {
	
	@Id
	@ManyToOne
	private Estudiante estudiante;
	
	@Id
	@ManyToOne
	private Carrera carrera;
	
	@Column
	private int antiguedad;
	
	@Column
	private boolean graduado;

	public Inscriptos() {
		super();
	}
	
	public Inscriptos(Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

}
