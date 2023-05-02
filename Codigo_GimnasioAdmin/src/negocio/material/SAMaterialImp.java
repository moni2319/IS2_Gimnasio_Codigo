package negocio.material;

import java.util.ArrayList;

import integracion.material.DAOMaterial;

public class SAMaterialImp implements SAMaterial{
	private DAOMaterial daoMaterial;
	@Override
	public int AltaMaterial(TransMaterial tMaterial) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int BajaMaterial(int id) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int ModificarMaterial(TransMaterial tMaterial) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public TransMaterial MostrarMaterial(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransMaterial> ListarMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

}
