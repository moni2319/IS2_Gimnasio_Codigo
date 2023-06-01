package negocio.sesion;

public class TransSesion{
	protected int id;
	protected double precio;
	protected String nombre;
	protected int idMonitor;
	// meter despues

	public TransSesion(int i, int idM, double p, String n) {
		id = i;
		precio = p;
		nombre = n;
		idMonitor = idM;
	}

	public int getId() {
		return id;
	}

	public int getIdM() {
		return idMonitor;
	}

	public double getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(int i) {
		id = i;
	}

	public void setIdM(int iM) {
		idMonitor = iM;
	}

	public void setPrecio(int p) {
		precio = p;
	}

	public void setNombre(String n) {
		nombre = n;
	}

}
