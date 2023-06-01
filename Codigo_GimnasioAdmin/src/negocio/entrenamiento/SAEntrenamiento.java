package negocio.entrenamiento;

import java.util.ArrayList;

public interface SAEntrenamiento{
	public int AltaEntrenamiento(TransEntrenamiento tEntrenamiento);

	public TransEntrenamiento MostrarEntrenamiento(int id);

	public ArrayList<TransEntrenamiento> ListarEntrenamiento();

	public int ModificarEntrenamiento(TransEntrenamiento tEntrenamiento);

	public int BajaEntrenamiento(int id);
}
