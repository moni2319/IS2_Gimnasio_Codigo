package negocio.factura;

import java.util.ArrayList;

import integracion.cliente.DAOCliente;
import integracion.factoria.FactoriaDAOImp;
import integracion.factura.DAOFactura;

public class SAFacturaImp implements SAFactura {

	private DAOFactura daoFactura;
	private DAOCliente daoCliente;

	public SAFacturaImp() {
		daoFactura = new FactoriaDAOImp().getDAOFactura();
		daoCliente = new FactoriaDAOImp().getDAOCliente();
	}

	public int AbrirFactura(TransFactura tFactura) {
		if (daoFactura.buscarFactura(tFactura.getCod()) != null) {
			throw new IllegalArgumentException("Ya existe una factura con codigo " + tFactura.getCod());
		}
		if (daoCliente.buscarCliente(tFactura.getIdCliente()) == null) {
			throw new IllegalArgumentException("No existe un cliente con id " + tFactura.getIdCliente());
		}
		boolean exito = daoFactura.abrirFactura(tFactura);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos la factura");
		}
		return 1;
	}

	public TransFactura MostrarFactura(int cod) {
		if (daoFactura.buscarFactura(cod) == null) {
			throw new IllegalArgumentException("No existe una factura con codigo " + cod);
		}
		return daoFactura.buscarFactura(cod);
	}

	public ArrayList<TransFactura> MostrarFacturasCliente(int idCliente) {
		ArrayList<TransFactura> lista = daoFactura.buscarFacturasCliente(idCliente);
		if (lista.isEmpty()) {
			throw new IllegalArgumentException("No hay clientes activos con el id de  " + idCliente);
		}
		return lista;
	}

	public ArrayList<TransFactura> ListarFactura() {
		return daoFactura.listarFactura();
	}

	public int ModificarFactura(TransFactura tFactura) {
		if (daoFactura.buscarFactura(tFactura.getCod()) == null) {
			throw new IllegalArgumentException("No existe una factura con codigo " + tFactura.getCod());
		}
		if (daoCliente.buscarCliente(tFactura.getIdCliente()) == null) {
			throw new IllegalArgumentException("No existe un cliente con id " + tFactura.getIdCliente());
		}
		boolean exito = daoFactura.modificarFactura(tFactura);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos la factura");
		}
		return 1;
	}

	public int CerrarFactura(int cod) {
		if (daoFactura.buscarFactura(cod) == null) {
			throw new IllegalArgumentException("No existe una factura con codigo " + cod);
		}
		boolean exito = daoFactura.cerrarFactura(cod);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo cerrar la factura");
		}
		return 1;
	}

}
