package negocio.actividad;

public class TransActividad{
	private int id;
	private int precio;
	private int aforo;
	private String nombre;
	private int idMonitor;
	// meter despues

	public TransActividad(int i, int idM, int p, int a, String n) {
		id = i;
		precio = p;
		aforo = a;
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

	public int getAforo() {
		return aforo;
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

	public void setAforo(int a) {
		aforo = a;
	}

	public void setNombre(String n) {
		nombre = n;
	}

}
