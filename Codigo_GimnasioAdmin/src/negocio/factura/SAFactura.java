package negocio.factura;

import java.util.ArrayList;

import negocio.actividad.TransActividad;

public interface SAFactura {
	public int AbrirFactura(TransActividad tActividad);

	public TransActividad MostrarActividad(int id);

	public ArrayList<TransActividad> ListarActividad();

	public int Modificar(TransActividad tActividad);

	public int BajaActividad(int id);
}
