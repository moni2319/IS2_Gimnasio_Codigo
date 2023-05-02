package negocio.factorias;

import negocio.actividad.SAActividad;
import negocio.cliente.SACliente;
import negocio.entrenamiento.SAEntrenamiento;
import negocio.factura.SAFactura;
import negocio.material.SAMaterial;
import negocio.monitor.SAMonitor;

public interface FactoriaSA {
	public SAActividad getInstanciaSAActividad();

	public SAEntrenamiento getInstanciaSAEntrenamiento();

	public SACliente getInstanciaSACliente();

	public SAFactura getInstanciaSAFactura();

	public SAMaterial getInstanciaSAMaterial();

	public SAMonitor getInstanciaSAMonitor();

}
