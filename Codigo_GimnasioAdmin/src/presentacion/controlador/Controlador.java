package presentacion.controlador;



public abstract class Controlador {
	private static Controlador instancia;
	

	public static Controlador obtenerInstancia() {
		if (instancia == null) {
			instancia = new ControladorImp();
		}
		return instancia;
	}
	public abstract void Accion(int event, Object trans);

}
