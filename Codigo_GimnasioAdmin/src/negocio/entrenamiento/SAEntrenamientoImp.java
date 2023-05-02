package negocio.entrenamiento;

import java.util.ArrayList;

import integracion.entrenamiento.DAOEntrenamiento;
import integracion.factoria.FactoriaDAOImp;
import integracion.monitor.DAOMonitor;

public class SAEntrenamientoImp implements SAEntrenamiento{

	private DAOEntrenamiento daoEntrenamiento;
	private DAOMonitor daoMonitor;

	public SAEntrenamientoImp() {
		daoEntrenamiento = new FactoriaDAOImp().getDAOEntrenamiento();
		daoMonitor = new FactoriaDAOImp().getDAOMonitor();
	}

	public int AltaEntrenamiento(TransEntrenamiento tEntrenamiento) {
		if (daoEntrenamiento.buscarEntrenamiento(tEntrenamiento.getId()) != null) {
			throw new IllegalArgumentException("Ya existe un entrenamiento con id " + tEntrenamiento.getId());
		}
		if (daoMonitor.buscarMonitor(tEntrenamiento.getIdM()) == null){
			throw new IllegalArgumentException("No existe un monitor con id " + tEntrenamiento.getIdM());
		}
		boolean exito = daoEntrenamiento.altaEntrenamiento(tEntrenamiento);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos el entrenamiento");
		}

		return 1;
	}

	public TransEntrenamiento MostrarEntrenamiento(int id) {
		TransEntrenamiento entrenamiento = daoEntrenamiento.buscarEntrenamiento(id);
		if (entrenamiento == null) {
			throw new IllegalArgumentException("No existe un entrenamiento con id " + id);
		}
		return entrenamiento;
	}

	public ArrayList<TransEntrenamiento> ListarEntrenamiento() {
	  return daoEntrenamiento.listaEntrenamiento();
	}

	public int ModificarEntrenamiento(TransEntrenamiento tEntrenamiento) {
		if (daoEntrenamiento.buscarEntrenamiento(tEntrenamiento.getId()) == null) {
			throw new IllegalArgumentException("No existe un entrenamiento con id " + tEntrenamiento.getId());
		}
		if (daoMonitor.buscarMonitor(tEntrenamiento.getIdM()) == null){
			throw new IllegalArgumentException("No existe un monitor con id " + tEntrenamiento.getIdM());
		}
		boolean exito = daoEntrenamiento.modificarEntrenamiento(tEntrenamiento);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos el entrenamiento");
		}
		return 1;
	}

	public int BajaEntrenamiento(int id) {
		if (daoEntrenamiento.buscarEntrenamiento(id) == null) {
			throw new IllegalArgumentException("No existe un entrenamiento con id " + id);
		}
		boolean exito = daoEntrenamiento.bajaEntrenamiento(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo quitar en la base de datos el entrenamiento");
		}
		return 1; 
	}

}
