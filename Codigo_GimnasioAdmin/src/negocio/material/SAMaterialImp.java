package negocio.material;

import java.util.ArrayList;

import integracion.factoria.FactoriaDAOImp;
import integracion.material.DAOMaterial;

public class SAMaterialImp implements SAMaterial {
	private DAOMaterial daoMaterial;

	public SAMaterialImp() {
		daoMaterial = new FactoriaDAOImp().getDAOMaterial();
	}

	public int AltaMaterial(TransMaterial tMaterial) {
		if (daoMaterial.buscarMaterial(tMaterial.getId()) != null) {
			throw new IllegalArgumentException("Ya existe un material con id " + tMaterial.getId());
		}
		boolean exito = daoMaterial.altaMaterial(tMaterial);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guardar en la base de datos el material");
		}
		return 1;
	}

	public int BajaMaterial(int id) {
		if (daoMaterial.buscarMaterial(id) == null) {
			throw new IllegalArgumentException("No existe un material con id " + id);
		}
		boolean exito = daoMaterial.bajaMaterial(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo dar de baja un material");
		}
		return 1;
	}

	public int ModificarMaterial(TransMaterial tMaterial) {
		if (daoMaterial.buscarMaterial(tMaterial.getId()) == null) {
			throw new IllegalArgumentException("No existe un material con id " + tMaterial.getId());
		}
		boolean exito = daoMaterial.modificarMaterial(tMaterial);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo modificar en la base de datos el material");
		}
		return 1;
	}

	public TransMaterial MostrarMaterial(int id) {
		if (daoMaterial.buscarMaterial(id) == null) {
			throw new IllegalArgumentException("No existe un material con id " + id);
		}
		return daoMaterial.buscarMaterial(id);
	}

	public ArrayList<TransMaterial> ListarMaterial() {
		return daoMaterial.listarMaterial();
	}

}
