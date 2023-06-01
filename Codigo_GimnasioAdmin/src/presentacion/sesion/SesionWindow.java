package presentacion.sesion;

import javax.swing.JFrame;

public abstract class SesionWindow extends JFrame {
	private static SesionWindow instancia;

	public static SesionWindow obtenerInstancia() {
		if (instancia == null) {
			instancia = new SesionWindowImp();
		}
		return instancia;
	}

	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
}
