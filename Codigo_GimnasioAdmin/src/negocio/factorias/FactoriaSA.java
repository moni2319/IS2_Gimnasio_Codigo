package negocio.factorias;

import negocio.actividad.SAActividad;
import negocio.factura.SAFactura;
import negocio.material.SAMaterial;

// ir descomentando mientras vayais haciendo
public interface FactoriaSA {
	public SAActividad getInstanciaSAActividad();
	// public SAEntrenamiento getInstanciaSAEntrenamiento();
	// public SACliente getInstanciaSACliente();
	 public SAFactura getInstanciaSAFactura();
	 public SAMaterial getInstanciaSAMaterial();
	// public SAMonitor getInstanciaSAMonitor();

}
