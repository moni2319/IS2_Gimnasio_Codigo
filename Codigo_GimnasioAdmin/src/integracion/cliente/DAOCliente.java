package integracion.cliente;

import java.util.ArrayList;

import negocio.cliente.TransCliente;

public interface DAOCliente {
	public boolean altaCliente(TransCliente tCliente);

	public boolean bajaCliente(int id);

	public boolean modificarCliente(TransCliente tCliente);

	public TransCliente buscarCliente(int id);

	public ArrayList<TransCliente> listarCliente();
}
