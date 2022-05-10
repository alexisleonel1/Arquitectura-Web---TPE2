package Consultas;

import java.util.List;

import DTO.CarrerasInscriptosDTO;
import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.Inscriptos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class InscriptosConsultas {

	private EntityManager em  = null;

	public InscriptosConsultas(EntityManager em) {
		this.em = em;
	}

	public Inscriptos matricular(Estudiante e, Carrera c, int antiguedad, boolean graduado) {
		em.getTransaction().begin();
		Inscriptos ec = new Inscriptos(e,c,antiguedad,graduado);
		em.persist(ec);
		em.getTransaction().commit();
		return ec;
	}
	
	@SuppressWarnings("unchecked")
	public List<CarrerasInscriptosDTO> carrerasConInscriptos() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT new DTO.CarrerasInscriptosDTO( c.nombre ) FROM Inscriptos ec JOIN ec.carrera c GROUP BY ec.carrera ORDER BY count(ec.carrera) DESC", CarrerasInscriptosDTO.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Estudiante> estudiantePorCarrera(String carrera,String ciudad) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Inscriptos i JOIN i.carrera c JOIN i.estudiante e JOIN e.ciudad ci WHERE c.nombre = :carrera AND ci.nombre = :ciudad");
		query.setParameter("carrera", carrera);
		query.setParameter("ciudad", ciudad);
		return query.getResultList();
	}
	
}