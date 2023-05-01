package integracion.actividad;

import java.util.ArrayList;
import java.util.List;

import negocio.actividad.TransActividad;

public interface DAOActividad {
	public boolean altaActividad(TransActividad tActividad);

	public boolean bajaActividad(int id);

	public TransActividad buscar(int id); // es el mostar realmente

	public boolean modificarActividad(TransActividad tActividad);

	public ArrayList<TransActividad> listaActividades();
}
