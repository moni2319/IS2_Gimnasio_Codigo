package negocio.cliente;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import integracion.cliente.DAOCliente;
import integracion.factoria.FactoriaDAOImp;
import integracion.sesion.DAOSesion;

public class SAClienteImp implements SACliente {

	private DAOCliente daoCliente;
	private DAOSesion daoSesion;
	
	public enum Nivel {
	    INTERMEDIO,
	    NUEVO,
	    EXPERTO
	}

	public SAClienteImp() {
		daoCliente = new FactoriaDAOImp().getDAOCliente();
		daoSesion = new FactoriaDAOImp().getDAOSesion();
	}

	public int AltaCliente(TransCliente tCliente) {
		
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
		if (daoCliente.buscarClienteSesion(id) != null) {
			throw new IllegalArgumentException("No puedes darle de baja si tiene sesiones");
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

	
	public int ApuntarCliente(Object[] info) {
		
		int s = (int)info[0];
		int c = (int)info[1];
		String n = (String)info[2];
		Nivel nivelEnum;
		try {
		 nivelEnum = Nivel.valueOf(n.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("El nivel ingresado no es válido.");
		}
		if (daoCliente.buscarCliente(c) == null) {
			throw new IllegalArgumentException("No existe un cliente con id " + c);
		}
		if (daoSesion.buscar(s) == null) {
			throw new IllegalArgumentException("No existe una sesion con id " + s);
		}
		if (daoCliente.buscarClienteSesion(c, s) != null) {
			throw new IllegalArgumentException("Ya está en esa sesion");
		}
		boolean exito = daoCliente.apuntarCliente(s, c , nivelEnum);
		
		if (!exito) {
			throw new IllegalArgumentException("No se pudo apuntar al cliente en la sesion");
		}
		return 1;
	}

	
	public ArrayList<Object[]> ListarSesiones(int id) {
		if (daoCliente.buscarCliente(id) == null) {
			throw new IllegalArgumentException("No existe un cliente con id " + id);
		}
		
		return daoCliente.listarSesiones(id);
	}

	
	public int QuitarCliente(Object[] info) {
		int idC = (int)info[0];
		int idS = (int)info[1];
		if (daoCliente.buscarCliente(idC) == null) {
			throw new IllegalArgumentException("No existe un cliente con id " + idC);
		}
		if (daoCliente.buscarClienteSesion(idC) == null) {
			throw new IllegalArgumentException("No tiene sesiones");
		}
		if (daoCliente.buscarClienteSesion(idC, idS) == null) {
			throw new IllegalArgumentException("No esta en esa sesion");
		}
		boolean exito = daoCliente.quitarCliente( idC, idS);
		
		if (!exito) {
			throw new IllegalArgumentException("No se pudo quitar de la sesion");
		}
		return 1;
	}

}
