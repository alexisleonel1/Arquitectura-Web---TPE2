package Consultas;

import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.EstudianteCarrera;
import jakarta.persistence.EntityManager;

public class EstudianteCarreraConsultas {

	private EntityManager em  = null;

	public EstudianteCarreraConsultas(EntityManager em) {
		this.em = em;
	}

	public EstudianteCarrera matricular(Estudiante e, Carrera c, int antiguedad, boolean graduado) {
		em.getTransaction().begin();
		EstudianteCarrera ec = new EstudianteCarrera(e,c,antiguedad,graduado);
		em.persist(ec);
		em.getTransaction().commit();
		return ec;
	}
	
}
