package presentacion.cliente;

import javax.swing.JFrame;

public class ClienteWindow extends JFrame {
	private static ClienteWindow instancia;

	public static ClienteWindow obtenerInstancia() {
		if (instancia == null) {
			instancia = new ClienteWindowImp();
		}
		return instancia;
	}

	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
}
