package negocio.cliente;

import java.util.ArrayList;

public interface SACliente {
	public int AltaCliente(TransCliente tCliente);

	public int BajaCliente(int id);

	public int ModificarCliente(TransCliente tCliente);

	public TransCliente MostrarCliente(int id);

	public ArrayList<TransCliente> ListarCliente();

	public int ApuntarCliente(Object[] info);

	public ArrayList<Object[]> ListarSesiones(int id);

	public int QuitarCliente(Object[] info);
}
