package integracion.entrenamiento;

import java.util.ArrayList;


import negocio.entrenamiento.TransEntrenamiento;

public interface DAOEntrenamiento { //usar solo especificos no comunes
	public boolean altaEntrenamiento(TransEntrenamiento tEntrenamiento);

	public boolean bajaEntrenamiento(int id);

	public TransEntrenamiento buscarEntrenamiento(int id);

	public boolean modificarEntrenamiento(TransEntrenamiento tEntrenamiento);

	public ArrayList<TransEntrenamiento> listaEntrenamiento();
}
