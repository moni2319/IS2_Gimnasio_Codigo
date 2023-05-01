package presentacion.actividad;

import javax.swing.JFrame;

public abstract class ActividadWindow extends JFrame {
	private static ActividadWindow instancia;

	public static ActividadWindow obtenerInstancia() {
		if (instancia == null) {
			instancia = new ActividadWindowImp();
		}
		return instancia;
	}

	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
}
