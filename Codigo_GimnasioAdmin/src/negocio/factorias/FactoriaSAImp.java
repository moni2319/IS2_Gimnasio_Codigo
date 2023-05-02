package negocio.factorias;

import negocio.actividad.SAActividad;
import negocio.actividad.SAActividadImp;
import negocio.cliente.SACliente;
import negocio.cliente.SAClienteImp;
import negocio.entrenamiento.SAEntrenamiento;
import negocio.entrenamiento.SAEntrenamientoImp;
import negocio.factura.SAFactura;
import negocio.factura.SAFacturaImp;
import negocio.material.SAMaterial;
import negocio.material.SAMaterialImp;
import negocio.monitor.SAMonitor;
import negocio.monitor.SAMonitorImp;

public class FactoriaSAImp implements FactoriaSA {

	public SAActividad getInstanciaSAActividad() {
		return new SAActividadImp();
	}

	public SAEntrenamiento getInstanciaSAEntrenamiento() {
		return new SAEntrenamientoImp();
	}

	public SACliente getInstanciaSACliente() {
		return new SAClienteImp();
	}

	public SAFactura getInstanciaSAFactura() {
		return new SAFacturaImp();
	}

	public SAMaterial getInstanciaSAMaterial() {
		return new SAMaterialImp();
	}

	public SAMonitor getInstanciaSAMonitor() {
		return new SAMonitorImp();
	}

}
