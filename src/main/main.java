package main;

import java.text.ParseException;

import Entidades.Carrera;
import Entidades.Ciudad;
import Entidades.Estudiante;
import Entidades.Inscriptos;
import Factory.Factory;
import Factory.MySQLDFactory;
import Repositorio.CarreraRepositorio;
import Repositorio.CiudadRepositorio;
import Repositorio.EstudianteRepositorio;
import Repositorio.InscriptosRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class main {

	public static void main(String[] args) throws ParseException {
		
		Factory mysql = Factory.getFactory(1);
		CarreraRepositorio cr = mysql.getCarreraRepositorio();
		CiudadRepositorio cir = mysql.getCiudadRepositorio();
		EstudianteRepositorio er = mysql.getEstudianteRepositorio();
		InscriptosRepositorio ir = mysql.getInscriptosRepositorio();
		
		Carrera aw = cr.insert("AW");
		Carrera tdv = cr.insert("TDV");
		
		Ciudad rauch = cir.insert("Rauch");
		Ciudad tandil = cir.insert("Tandil");
		
		Estudiante e1 = er.insert("estudiante1", "la1", 22, 'M', 41969543, 2903, rauch);
		Estudiante e2 = er.insert("estudiante3", "la3", 32, 'M', 41969543, 8803, tandil);
		Estudiante e3 = er.insert("estudiante2", "la2", 26, 'F', 41969543, 5803, tandil);
		Estudiante e4 = er.insert("estudiante4", "la4", 18, 'M', 41969643, 4803, tandil);
		
		System.out.println(er.getByNumLibretaUniversitaria(2903));
		System.out.println(er.getEstudiantesByEdad());
		System.out.println(er.getEstudiantesByGenero('M'));
		System.out.println(er.getEstudiantesByCiudad("Tandil"));
		
		ir.matricular(e1,aw,"20/04/2022",false);
		ir.matricular(e2,aw,"20/04/2020",false);
		ir.matricular(e3,tdv,"20/04/2022",false);
		ir.matricular(e4,aw,"25/03/2018",true);
		
		System.out.println(ir.carrerasConInscriptos());
		System.out.println(ir.estudiantePorCarrera("tdv","Tandil"));
		System.out.println(ir.getInfoCarrera("11/05/2022"));
		
		mysql.cerrar();
	}

}
