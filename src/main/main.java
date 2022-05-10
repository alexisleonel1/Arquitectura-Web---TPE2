package main;

import java.util.List;

import Consultas.CarreraConsultas;
import Consultas.CiudadConsultas;
import Consultas.InscriptosConsultas;
import Consultas.EstudianteConsultas;
import DTO.CarrerasInscriptosDTO;
import Entidades.Carrera;
import Entidades.Ciudad;
import Entidades.Estudiante;
import Entidades.Inscriptos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TPE2");
		EntityManager em = emf.createEntityManager();
		CarreraConsultas c = new CarreraConsultas(em);
		Carrera aw = c.insert("AW");
		Carrera tdv = c.insert("tdv");
		CiudadConsultas ci = new CiudadConsultas(em);
		Ciudad rauch = ci.insert("Rauch");
		Ciudad tandil = ci.insert("Tandil");
		EstudianteConsultas e = new EstudianteConsultas(em);
		Estudiante e1 = e.insert("persona1", "la1", 22, 'M', 41969543, 2903, rauch);
		Estudiante e2 = e.insert("Otro", "la2", 32, 'M', 41969543, 8803, tandil);
		Estudiante e3 = e.insert("ultimo", "la3", 32, 'M', 41969543, 8803, tandil);
		System.out.println(e.getByNumLibretaUniversitaria(2903));
		System.out.println(e.getEstudiantesByEdad());
		System.out.println(e.getEstudiantesByGenero('M'));
		System.out.println(e.getEstudiantesByCiudad("Tandil"));
		InscriptosConsultas m = new InscriptosConsultas(em);
		Inscriptos ec = m.matricular(e1,aw,0,false);
		m.matricular(e2,aw,0,false);
		m.matricular(e3,tdv,0,false);
		//System.out.println(m.carrerasConInscriptos());
		System.out.println(m.estudiantePorCarrera("tdv","Tandil"));
		em.close();
		emf.close();
	}

}
