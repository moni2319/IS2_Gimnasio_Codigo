package negocio.factura;

import java.util.ArrayList;

public interface SAFactura {
	public int AbrirFactura(TransFactura tFactura);

	public TransFactura MostrarFactura(int cod);

	public ArrayList<TransFactura> MostrarFacturasCliente(int idCliente);

	public ArrayList<TransFactura> ListarFactura();

	public int ModificarFactura(TransFactura tFactura);

	public int CerrarActividad(int cod);
}
