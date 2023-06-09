package negocio.actividad;

import java.util.ArrayList;

import integracion.actividad.DAOActividad;
import integracion.factoria.FactoriaDAOImp;
import integracion.monitor.DAOMonitor;
import integracion.sesion.DAOSesion;
import negocio.sesion.TransSesion;


public class SAActividadImp implements SAActividad {

	private DAOActividad daoActividad;
	private DAOMonitor daoMonitor;
	private DAOSesion daoSesion;

	public SAActividadImp() {
		daoActividad = new FactoriaDAOImp().getDAOActividad();
		daoMonitor = new FactoriaDAOImp().getDAOMonitor();
		daoSesion  = new FactoriaDAOImp().getDAOSesion();

	}

	public int AltaActividad(TransActividad tActividad) {

		
		if (daoMonitor.buscarMonitor(tActividad.getIdM()) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + tActividad.getIdM());
		}
		
		boolean exito = daoSesion.altaSesion(tActividad);
		if(exito){
			exito = daoActividad.altaActividad(tActividad);
		}
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos la actividad");
		}

		return 1;
	}

	public int BajaActividad(int id) {
		if (daoActividad.buscar(id) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + id);
		}
		if (daoSesion.buscarClientesSesion(id) != null) {
			throw new IllegalArgumentException("No puedes darle de baja si tiene clientes");
		}
		boolean exito = daoActividad.bajaActividad(id);
		if(exito){
			exito = daoSesion.bajaSesion(id);
		}
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
		if(exito){
			exito = daoSesion.modificarSesion(tActividad);
		}
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos la actividad");
		}
		return 1;
	}

}
