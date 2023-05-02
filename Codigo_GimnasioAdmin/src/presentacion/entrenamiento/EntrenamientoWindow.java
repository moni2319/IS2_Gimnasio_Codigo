package presentacion.entrenamiento;

import javax.swing.JFrame;


public class EntrenamientoWindow extends JFrame{
	private static EntrenamientoWindow instancia;

	public static EntrenamientoWindow obtenerInstancia() {
		if (instancia == null) {
			instancia = new EntrenamientoWindowImp();
		}
		return instancia;
	}

	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
}
