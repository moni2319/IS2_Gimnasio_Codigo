package negocio.actividad;

import java.util.ArrayList;

import integracion.actividad.DAOActividad;
import integracion.factoria.FactoriaDAOImp;

public class SAActividadImp implements SAActividad {

	private DAOActividad daoActividad;

	public SAActividadImp() {
		daoActividad = new FactoriaDAOImp().getDAOActividad();
	}

	public int AltaActividad(TransActividad tActividad) {

		if (daoActividad.buscar(tActividad.getId()) != null) {
			throw new IllegalArgumentException("Ya existe una actividad con id " + tActividad.getId());
		}
		boolean exito = daoActividad.altaActividad(tActividad);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos la actividad");
		}

		return 0;
	}

	public int BajaActividad(int id) {
		if (daoActividad.buscar(id) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + id);
		}
		boolean exito = daoActividad.bajaActividad(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo quitar en la base de datos la actividad");
		}
		return 0; // cambiar
	}

	public TransActividad MostrarActividad(int id) {
		if (daoActividad.buscar(id) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + id);
		}
		return daoActividad.buscar(id);
	}

	public ArrayList<TransActividad> ListarActividad() {
		return daoActividad.listaActividades();
	}

	public int Modificar(TransActividad tActividad) {
		if (daoActividad.buscar(tActividad.getId()) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + tActividad.getId());
		}
		boolean exito = daoActividad.modificarActividad(tActividad);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos la actividad");
		}
		return 0;
	}

}
