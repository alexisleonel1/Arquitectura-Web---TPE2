package Repositorio;

import Entidades.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CarreraRepositorio implements Repository<Carrera>{
	
	private EntityManagerFactory emf;
	
	public CarreraRepositorio(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public Carrera insert(String nombre) {
		Carrera c = new Carrera(nombre);
		return this.save(c);
	}
	
	@Override
	public Carrera save(Carrera c) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if(!em.contains(c)) {
			em.persist(c);
		}else {
			em.merge(c);
		}
		em.getTransaction().commit();
		em.close();
		return c;
	}

	@Override
	public boolean delete(Carrera c) {
		boolean remove = false;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if(!em.contains(c)) {
			em.remove(c);
			remove = true;
			em.getTransaction().commit();
		}
		em.close();
		return remove;
	}

	@Override
	public Carrera update(Carrera c) {
		Carrera updated = new Carrera();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if(!em.contains(c)) {
			updated = em.merge(c);
			em.getTransaction().commit();
		}
		em.close();
		return updated;
	}
	
}
