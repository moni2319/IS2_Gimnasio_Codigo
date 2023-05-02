package negocio.monitor;

import java.util.ArrayList;

public interface SAMonitor {
	public int AltaMonitor(TransMonitor tMonitor);

	public int BajaMonitor(int id);

	public int ModificarMonitor(TransMonitor tMonitor);

	public TransMonitor MostrarMonitor(int id);

	public ArrayList<TransMonitor> ListarMonitor();
}
