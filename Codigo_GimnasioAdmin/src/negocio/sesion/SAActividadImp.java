package negocio.sesion;

import java.util.ArrayList;

import integracion.actividad.DAOActividad;
import integracion.factoria.FactoriaDAOImp;
import integracion.monitor.DAOMonitor;


public class SASesionImp implements SASesion {

	private DAOSesion daoSesion;
	private DAOMonitor daoMonitor;

	public SASesionImp() {
		daoSesion = new FactoriaDAOImp().getDAOSesion();
		daoMonitor = new FactoriaDAOImp().getDAOMonitor();

	}

	public int AltaActividad(TransSesion tSesion) {

		if (daoSesion.buscar(tSesion.getId()) != null) {
			throw new IllegalArgumentException("Ya existe una actividad con id " + tSesion.getId());
		}
		if (daoMonitor.buscarMonitor(tSesion.getIdM()) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + tSesion.getIdM());
		}
		boolean exito = daoSesion.altaSesion(tSesion);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos la actividad");
		}

		return 1;
	}

	public int BajaActividad(int id) {
		if (daoSesion.buscar(id) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + id);
		}
		boolean exito = daoSesion.bajaActividad(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo quitar en la base de datos la actividad");
		}
		return 1;
	}

	public TransActividad MostrarActividad(int id) {
		TransActividad actividad = daoSesion.buscar(id);
		if (actividad == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + id);
		}
		return actividad;
	}

	public ArrayList<TransActividad> ListarActividad() {
		return daoSesion.listaActividades();
	}

	public int ModificarActividad(TransActividad tActividad) {
		if (daoSesion.buscar(tActividad.getId()) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + tActividad.getId());
		}
		if (daoMonitor.buscarMonitor(tActividad.getIdM()) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + tActividad.getIdM());
		}
		boolean exito = daoSesion.modificarActividad(tActividad);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos la actividad");
		}
		return 1;
	}

}
