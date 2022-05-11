package Factory;

import Repositorio.CarreraRepositorio;
import Repositorio.CiudadRepositorio;
import Repositorio.EstudianteRepositorio;
import Repositorio.InscriptosRepositorio;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MySQLDFactory extends Factory {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TPE2");
	
	public MySQLDFactory() {
		super();
	}

	@Override
	public CarreraRepositorio getCarreraRepositorio() {
		return new CarreraRepositorio(emf);
	}

	@Override
	public CiudadRepositorio getCiudadRepositorio() {
		return new CiudadRepositorio(emf);
	}

	@Override
	public EstudianteRepositorio getEstudianteRepositorio() {
		return new EstudianteRepositorio(emf);
	}

	@Override
	public InscriptosRepositorio getInscriptosRepositorio() {
		return new InscriptosRepositorio(emf);
	}
	
	public void cerrar(){
		emf.close();
	}
}
