package integracion.factoria;

import java.sql.Connection;

import integracion.DataBaseConnection;
import integracion.actividad.DAOActividad;
import integracion.actividad.DAOActividadImp;
import integracion.cliente.DAOCliente;
import integracion.cliente.DAOClienteImp;
import integracion.factura.DAOFactura;
import integracion.factura.DAOFacturaImp;
import integracion.material.DAOMaterial;
import integracion.material.DAOMaterialImp;
import integracion.monitor.DAOMonitor;
import integracion.monitor.DAOMonitorImp;

public class FactoriaDAOImp implements FactoriaDAO {
	private Connection connection;

	public FactoriaDAOImp() {
		DataBaseConnection DBConnection = new DataBaseConnection();
		connection = DBConnection.getConnection();
	}

	public DAOActividad getDAOActividad() {
		return new DAOActividadImp(connection);
	}



	// public DAOEntrenamiento getDAOEntrenamiento() {
	// return new DAOEntrenamientoImp(connection);
	// }
	//
	public DAOCliente getDAOACliente() {
		return new DAOClienteImp(connection);
	}

	public DAOFactura getDAOFactura() {
		return new DAOFacturaImp(connection);
	}

	public DAOMaterial getDAOMaterial() {
		return new DAOMaterialImp(connection);
	}

	public DAOMonitor getDAOMonitor() {
		return new DAOMonitorImp(connection);
	}
}
