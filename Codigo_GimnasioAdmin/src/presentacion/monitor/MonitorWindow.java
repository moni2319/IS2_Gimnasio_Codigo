package presentacion.monitor;

import javax.swing.JFrame;

public class MonitorWindow extends JFrame {
	private static MonitorWindow instancia;

	public static MonitorWindow obtenerInstancia() {
		if (instancia == null) {
			instancia = new MonitorWindowImp();
		}
		return instancia;
	}

	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
}
