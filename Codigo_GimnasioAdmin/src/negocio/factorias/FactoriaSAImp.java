package negocio.factorias;

import negocio.actividad.SAActividad;
import negocio.actividad.SAActividadImp;
import negocio.factura.SAFactura;
import negocio.factura.SAFacturaImp;
import negocio.material.SAMaterial;
import negocio.material.SAMaterialImp;

public class FactoriaSAImp implements FactoriaSA {

	// ir descomentando mientras vayais haciendo
	@Override
	public SAActividad getInstanciaSAActividad() {
		return new SAActividadImp();
	}

	// @Override
	// public SAEntrenamiento getInstanciaSAEntrenamiento() {
	// return new SAEntrenamientoImp();
	// }
	//
	// @Override
	// public SACliente getInstanciaSACliente() {
	// return new SAClienteImp();
	// }
	//

	public SAFactura getInstanciaSAFactura() {
		return new SAFacturaImp();
	}

	public SAMaterial getInstanciaSaServicio() {
		return new SAMaterialImp();
	}

	// @Override
	// public SAMonitor getInstanciaSATren() {
	// return new SAMonitorImp();
	// }

}
