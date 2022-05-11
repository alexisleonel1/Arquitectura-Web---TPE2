package Factory;

import Repositorio.CarreraRepositorio;
import Repositorio.CiudadRepositorio;
import Repositorio.EstudianteRepositorio;
import Repositorio.InscriptosRepositorio;

public abstract class Factory {
	
	public static final int MYSQL = 1;
	
	public abstract CarreraRepositorio getCarreraRepositorio();
	public abstract CiudadRepositorio getCiudadRepositorio();
	public abstract EstudianteRepositorio getEstudianteRepositorio();
	public abstract InscriptosRepositorio getInscriptosRepositorio();
	public abstract void cerrar();
	
	public static Factory getFactory(int whichFactory) {
		switch (whichFactory) {
			case MYSQL : return new MySQLDFactory();
			default : return null;
		}
	}

}
