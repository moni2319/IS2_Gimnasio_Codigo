package negocio.cliente;

public class TransCliente {
	private int id;
	private String nombre;
	private int telefono;

	public TransCliente(int i, String n, int t) {
		id = i;
		nombre = n;
		telefono = t;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setId(int i) {
		id = i;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public void setTelefono(int t) {
		telefono = t;
	}
}
