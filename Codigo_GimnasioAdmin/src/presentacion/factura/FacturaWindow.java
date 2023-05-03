package presentacion.factura;

import javax.swing.JFrame;

public abstract class FacturaWindow extends JFrame {
	private static FacturaWindow instancia;

	public static FacturaWindow obtenerInstancia() {
		if (instancia == null) {
			instancia = new FacturaWindowImp();
		}
		return instancia;
	}

	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
}
