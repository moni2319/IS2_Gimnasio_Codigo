package negocio.factura;

public class TransFactura {
	private int idCliente;
	private int cod;
	private int importe;

	public TransFactura(int c, int iC, int imp) {
		cod = c;
		idCliente = iC;
		importe = imp;
	}

	public int getCod() {
		return cod;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public int getImporte() {
		return importe;
	}

	public void setCod(int c) {
		cod = c;
	}

	public void setIdCliente(int iC) {
		idCliente = iC;
	}

	public void setImporte(int imp) {
		importe = imp;
	}
}
