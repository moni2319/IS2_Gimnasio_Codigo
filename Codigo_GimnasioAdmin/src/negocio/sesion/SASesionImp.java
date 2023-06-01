package negocio.sesion;

import java.util.ArrayList;

import integracion.actividad.DAOActividad;
import integracion.factoria.FactoriaDAOImp;
import integracion.monitor.DAOMonitor;
import integracion.sesion.DAOSesion;


public class SASesionImp implements SASesion {

	private DAOSesion daoSesion;
	private DAOMonitor daoMonitor;

	public SASesionImp() {
		daoSesion = new FactoriaDAOImp().getDAOSesion();
		daoMonitor = new FactoriaDAOImp().getDAOMonitor();

	}

	public int AltaSesion(TransSesion tSesion) {

		if (daoSesion.buscar(tSesion.getId()) != null) {
			throw new IllegalArgumentException("Ya existe una sesion con id " + tSesion.getId());
		}
		if (daoMonitor.buscarMonitor(tSesion.getIdM()) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + tSesion.getIdM());
		}
		boolean exito = daoSesion.altaSesion(tSesion);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos la sesion");
		}

		return 1;
	}

	public int BajaSesion(int id) {
		if (daoSesion.buscar(id) == null) {
			throw new IllegalArgumentException("No existe una sesion con id " + id);
		}
		boolean exito = daoSesion.bajaSesion(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo quitar en la base de datos la sesion");
		}
		return 1;
	}

	public TransSesion MostrarSesion(int id) {
		TransSesion actividad = daoSesion.buscar(id);
		if (actividad == null) {
			throw new IllegalArgumentException("No existe una sesion con id " + id);
		}
		return actividad;
	}

	public ArrayList<TransSesion> ListarSesion() {
		return daoSesion.listaSesiones();
	}

	public int ModificarSesion(TransSesion tSesion) {
		if (daoSesion.buscar(tSesion.getId()) == null) {
			throw new IllegalArgumentException("No existe una sesion con id " + tSesion.getId());
		}
		if (daoMonitor.buscarMonitor(tSesion.getIdM()) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + tSesion.getIdM());
		}
		boolean exito = daoSesion.modificarSesion(tSesion);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos la sesion");
		}
		return 1;
	}

	

}
