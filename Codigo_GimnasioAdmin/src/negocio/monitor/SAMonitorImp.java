package negocio.monitor;

import java.util.ArrayList;

import integracion.factoria.FactoriaDAOImp;

import integracion.monitor.DAOMonitor;

public class SAMonitorImp implements SAMonitor {

	private DAOMonitor daoMonitor;

	public SAMonitorImp() {
		daoMonitor = new FactoriaDAOImp().getDAOMonitor();
	}

	public int AltaMonitor(TransMonitor tMonitor) {
		if (daoMonitor.buscarMonitor(tMonitor.getId()) != null) {
			throw new IllegalArgumentException("Ya existe un monitor con id " + tMonitor.getId());
		}
		boolean exito = daoMonitor.altaMonitor(tMonitor);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos el monitor");
		}
		return 1;
	}

	public int BajaMonitor(int id) {
		if (daoMonitor.buscarMonitor(id) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + id);
		}
		boolean exito = daoMonitor.bajaMonitor(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo dar de baja el monitor");
		}
		return 1;
	}

	public int ModificarMonitor(TransMonitor tMonitor) {
		if (daoMonitor.buscarMonitor(tMonitor.getId()) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + tMonitor.getId());
		}
		boolean exito = daoMonitor.modificarMonitor(tMonitor);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos el monitor");
		}
		return 1;
	}

	public TransMonitor MostrarMonitor(int id) {
		if (daoMonitor.buscarMonitor(id) == null) {
			throw new IllegalArgumentException("No existe un monitor con id " + id);
		}
		return daoMonitor.buscarMonitor(id);
	}

	public ArrayList<TransMonitor> ListarMonitor() {
		return daoMonitor.listarMonitor();
	}

}
