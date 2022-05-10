package Consultas;

import java.util.List;

import Entidades.Ciudad;
import Entidades.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EstudianteConsultas {
	
	private EntityManager em  = null;

	public EstudianteConsultas(EntityManager em) {
		this.em = em;
	}
	
	public Estudiante insert(String nombre,String apellido, int edad, char genero,int dni,int numLibretaUniversitaria,Ciudad ciudad) {
		em.getTransaction().begin();
		Estudiante e = new Estudiante(nombre,apellido,edad,genero,dni,numLibretaUniversitaria,ciudad);
		em.persist(e);
		em.getTransaction().commit();
		return e;
	}
	
	public Estudiante getByNumLibretaUniversitaria(int l) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Estudiante e WHERE e.numLibretaUniversitaria = ?1");
		query.setParameter(1, l);
		Estudiante e = (Estudiante) query.getSingleResult();
		em.getTransaction().commit();
		return e;
	}
	
	public List<Estudiante> getEstudiantesByEdad() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.edad ASC");
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = query.getResultList();
		em.getTransaction().commit();
		return estudiantes;
	}
	
	public List<Estudiante> getEstudiantesByGenero(char g) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = ?1");
		query.setParameter(1, g);
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = query.getResultList();
		em.getTransaction().commit();
		return estudiantes;
	}
	
	public List<Estudiante> getEstudiantesByCiudad(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Estudiante e JOIN e.ciudad c WHERE c.nombre = :ciudad");
		query.setParameter("ciudad", c);
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = query.getResultList();
		em.getTransaction().commit();
		return estudiantes;
	}

}
