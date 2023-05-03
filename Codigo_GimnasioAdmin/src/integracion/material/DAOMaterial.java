package integracion.material;

import java.util.ArrayList;

import negocio.material.TransMaterial;

public interface DAOMaterial {
	public boolean altaMaterial(TransMaterial tMaterial);

	public boolean bajaMaterial(int id);

	public boolean modificarMaterial(TransMaterial tMaterial);

	public TransMaterial buscarMaterial(int id);

	public ArrayList<TransMaterial> listarMaterial();

}
