package Consultas;

import Entidades.Ciudad;
import jakarta.persistence.EntityManager;

public class CiudadConsultas {
	
	private EntityManager em  = null;

	public CiudadConsultas(EntityManager em) {
		this.em = em;
	}
	
	public Ciudad insert(String nombre) {
		em.getTransaction().begin();
		Ciudad ci = new Ciudad(nombre);
		em.persist(ci);
		em.getTransaction().commit();
		return ci;
	}

}
