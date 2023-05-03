package negocio.cliente;

import java.util.ArrayList;

import integracion.cliente.DAOCliente;
import integracion.factoria.FactoriaDAOImp;

public class SAClienteImp implements SACliente {

	private DAOCliente daoCliente;

	public SAClienteImp() {
		daoCliente = new FactoriaDAOImp().getDAOCliente();
	}

	public int AltaCliente(TransCliente tCliente) {
		if (daoCliente.buscarCliente(tCliente.getId()) != null) {
			throw new IllegalArgumentException("Ya existe un cliente con id " + tCliente.getId());
		}
		boolean exito = daoCliente.altaCliente(tCliente);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos el cliente");
		}
		return 1;
	}

	public int BajaCliente(int id) {
		if (daoCliente.buscarCliente(id) == null) {
			throw new IllegalArgumentException("No existe un cliente con id " + id);
		}
		boolean exito = daoCliente.bajaCliente(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo dar de baja el cliente");
		}
		return 1;
	}

	public int ModificarCliente(TransCliente tCliente) {
		if (daoCliente.buscarCliente(tCliente.getId()) == null) {
			throw new IllegalArgumentException("No existe un cliente con id " + tCliente.getId());
		}
		boolean exito = daoCliente.modificarCliente(tCliente);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos el cliente");
		}
		return 1;
	}

	public TransCliente MostrarCliente(int id) {
		if (daoCliente.buscarCliente(id) == null) {
			throw new IllegalArgumentException("No existe un cliente con id " + id);
		}
		return daoCliente.buscarCliente(id);
	}

	public ArrayList<TransCliente> ListarCliente() {
		return daoCliente.listarCliente();
	}

}
