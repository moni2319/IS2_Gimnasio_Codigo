package integracion.factoria;

import java.sql.Connection;

import integracion.DataBaseConnection;
import integracion.actividad.DAOActividad;
import integracion.actividad.DAOActividadImp;

public class FactoriaDAOImp implements FactoriaDAO {
	private Connection connection;

	public FactoriaDAOImp() {
		DataBaseConnection DBConnection = new DataBaseConnection();
		connection = DBConnection.getConnection();
	}

	public DAOActividad getDAOActividad() {
		return new DAOActividadImp(connection);
	}

	// descomentar mientras se va haciendo

	// public DAOEntrenamiento getDAOEntrenamiento() {
	// return new DAOEntrenamientoImp(connection);
	// }
	//
	// public DAOCliente getDAOACliente(){
	// return new DAOClienteImp(connection);
	// }
	//
	// public DAOFactura getDAOFactura(){
	// return new DAOFacturaImp(connection);
	// }
	//
	// public DAOMaterial getDAOServicio(){
	// return new DAOMaterialImp(connection);
	// }
	//
	// public DAOMonitor getDAOTren(){
	// return new DAOMonitorImp(connection);
	// }
}
