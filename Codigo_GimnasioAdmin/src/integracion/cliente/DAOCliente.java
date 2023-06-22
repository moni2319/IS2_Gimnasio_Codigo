package integracion.cliente;

import java.util.ArrayList;

import negocio.cliente.SAClienteImp.Nivel;
import negocio.cliente.TransCliente;

public interface DAOCliente {
	public boolean altaCliente(TransCliente tCliente);

	public boolean bajaCliente(int id);

	public boolean modificarCliente(TransCliente tCliente);

	public TransCliente buscarCliente(int id);

	public ArrayList<TransCliente> listarCliente();

	public boolean apuntarCliente(int s, int c, Nivel nivelEnum);

	public ArrayList<Object[]> listarSesiones(int id);

	public Object buscarClienteSesion(int id);

	
}
