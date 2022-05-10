package main;

import Consultas.CarreraConsultas;
import Consultas.CiudadConsultas;
import Consultas.EstudianteCarreraConsultas;
import Consultas.EstudianteConsultas;
import Entidades.Carrera;
import Entidades.Ciudad;
import Entidades.Estudiante;
import Entidades.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TPE2");
		EntityManager em = emf.createEntityManager();
		CarreraConsultas c = new CarreraConsultas(em);
		Carrera aw = c.insert("AW");
		CiudadConsultas ci = new CiudadConsultas(em);
		Ciudad rauch = ci.insert("Rauch");
		Ciudad tandil = ci.insert("Tandil");
		EstudianteConsultas e = new EstudianteConsultas(em);
		Estudiante e1 = e.insert("persona1", "la1", 22, 'M', 41969543, 2903, rauch);
		e.insert("Otro", "la2", 32, 'M', 41969543, 8803, tandil);
		System.out.println(e.getByNumLibretaUniversitaria(2903));
		System.out.println(e.getEstudiantesByEdad());
		System.out.println(e.getEstudiantesByGenero('M'));
		System.out.println(e.getEstudiantesByCiudad("Tandil"));
		EstudianteCarreraConsultas m = new EstudianteCarreraConsultas(em);
		EstudianteCarrera ec = m.matricular(e1,aw,0,false);
		System.out.println(ec);
		em.close();
		emf.close();
	}

}
