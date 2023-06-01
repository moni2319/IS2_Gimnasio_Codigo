package negocio.actividad;

import java.util.ArrayList;

import integracion.actividad.DAOActividad;
import integracion.factoria.FactoriaDAOImp;
import integracion.monitor.DAOMonitor;


public class SAActividadImp implements SAActividad {

	private DAOActividad daoActividad;
	private DAOMonitor daoMonitor;

	public SAActividadImp() {
		daoActividad = new FactoriaDAOImp().getDAOActividad();
		daoMonitor = new FactoriaDAOImp().getDAOMonitor();

	}

	public int AltaActividad(TransActividad tActividad) {

		if (daoActividad.buscar(tActividad.getId()) != null) {
			throw new IllegalArgumentException("Ya existe una actividad con id " + tActividad.getId());
		}
		if (daoMonitor.buscarMonitor(tActividad.getIdM()) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + tActividad.getIdM());
		}
		boolean exito = daoActividad.altaActividad(tActividad);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos la actividad");
		}

		return 1;
	}

	public int BajaActividad(int id) {
		if (daoActividad.buscar(id) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + id);
		}
		boolean exito = daoActividad.bajaActividad(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo quitar en la base de datos la actividad");
		}
		return 1;
	}

	public TransActividad MostrarActividad(int id) {
		TransActividad actividad = daoActividad.buscar(id);
		if (actividad == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + id);
		}
		return actividad;
	}

	public ArrayList<TransActividad> ListarActividad() {
		return daoActividad.listaActividades();
	}

	public int ModificarActividad(TransActividad tActividad) {
		if (daoActividad.buscar(tActividad.getId()) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + tActividad.getId());
		}
		if (daoMonitor.buscarMonitor(tActividad.getIdM()) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + tActividad.getIdM());
		}
		boolean exito = daoActividad.modificarActividad(tActividad);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos la actividad");
		}
		return 1;
	}

}
