package integracion.monitor;

import java.util.ArrayList;

import negocio.monitor.TransMonitor;

public interface DAOMonitor {
	public boolean altaMonitor(TransMonitor tMonitor);

	public boolean bajaMonitor(int id);

	public boolean modificarMonitor(TransMonitor tMonitor);

	public TransMonitor buscarMonitor(int id);

	public ArrayList<TransMonitor> listarMonitor();
}
