package integracion.factoria;

import integracion.actividad.DAOActividad;
import integracion.factura.DAOFactura;
import integracion.material.DAOMaterial;
import integracion.monitor.DAOMonitor;

public interface FactoriaDAO {
	// descomentar mientras se va haciendo
	public DAOActividad getDAOActividad();

	// public DAOEntrenamiento getDAOEntrenamiento();
	// public DAOCliente getDAOACliente();
	public DAOFactura getDAOFactura();

	public DAOMaterial getDAOMaterial();
	public DAOMonitor getDAOMonitor();
}
