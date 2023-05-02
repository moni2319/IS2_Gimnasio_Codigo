package integracion.factura;

import java.util.ArrayList;

import negocio.factura.TransFactura;

public interface DAOFactura {
	public boolean abrirFactura(TransFactura tFactura);

	public TransFactura buscarFactura(int cod);

	public ArrayList<TransFactura> buscarFacturasCliente(int idCliente);

	public ArrayList<TransFactura> listarFactura();

	public boolean modificarFactura(TransFactura tActividad);

	public boolean cerrarActividad(int cod);
}
