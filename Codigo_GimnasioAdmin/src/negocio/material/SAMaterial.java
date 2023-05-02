package negocio.material;

import java.util.ArrayList;

public interface SAMaterial {
	public int AltaMaterial(TransMaterial tMaterial);

	public int BajaMaterial(int id);

	public int ModificarMaterial(TransMaterial tMaterial);

	public TransMaterial MostrarMaterial(int id);

	public ArrayList<TransMaterial> ListarMateriañ();

}
