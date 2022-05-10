package Consultas;

import Entidades.Carrera;
import jakarta.persistence.EntityManager;

public class CarreraConsultas {
	
	private EntityManager em  = null;
	
	public CarreraConsultas(EntityManager em) {
		this.em = em;
	}

	public Carrera insert(String nombre) {
		em.getTransaction().begin();
		Carrera c = new Carrera(nombre);
		em.persist(c);
		em.getTransaction().commit();
		return c;
	}
	
}
