package presentacion.material;

import javax.swing.JFrame;

public class MaterialWindow extends JFrame {
	private static MaterialWindow instancia;

	public static MaterialWindow obtenerInstancia() {
		if (instancia == null) {
			instancia = new MaterialWindowImp();
		}
		return instancia;
	}

	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
}
