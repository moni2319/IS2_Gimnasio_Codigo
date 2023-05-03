package negocio.entrenamiento;

public class TransEntrenamiento {
	private int id;
	private String nombre;
	private int precio;
	private int idMonitor;

	public TransEntrenamiento(int i, int idM, int p, String n) {
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

	public int getPrecio() {
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
