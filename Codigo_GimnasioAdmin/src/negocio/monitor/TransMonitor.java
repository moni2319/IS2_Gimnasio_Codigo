package negocio.monitor;

public class TransMonitor {
	private int id;
	private String nombre;
	private int salario;

	public TransMonitor(int i, String n, int s) {
		id = i;
		nombre = n;
		salario = s;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getSalario() {
		return salario;
	}

	public void setId(int i) {
		id = i;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public void setSalario(int s) {
		salario = s;
	}
}
