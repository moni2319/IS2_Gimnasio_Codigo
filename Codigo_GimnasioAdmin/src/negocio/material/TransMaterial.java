package negocio.material;

public class TransMaterial {
	private int id;
	private String nombre;
	private int stock;

	public TransMaterial(int i, String n, int s) {
		id = i;
		nombre = n;
		s = stock;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setId(int i) {
		id = i;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public void setStock(int s) {
		stock = s;
	}
}
