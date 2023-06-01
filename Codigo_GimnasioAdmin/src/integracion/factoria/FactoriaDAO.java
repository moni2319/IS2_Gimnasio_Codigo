package integracion.factoria;

import integracion.actividad.DAOActividad;
import integracion.cliente.DAOCliente;
import integracion.entrenamiento.DAOEntrenamiento;
import integracion.factura.DAOFactura;
import integracion.material.DAOMaterial;
import integracion.monitor.DAOMonitor;
import integracion.sesion.DAOSesion;

public interface FactoriaDAO {

	public DAOActividad getDAOActividad();

	public DAOEntrenamiento getDAOEntrenamiento();

	public DAOCliente getDAOCliente();

	public DAOFactura getDAOFactura();

	public DAOMaterial getDAOMaterial();

	public DAOMonitor getDAOMonitor();

	public DAOSesion getDAOSesion();
}
