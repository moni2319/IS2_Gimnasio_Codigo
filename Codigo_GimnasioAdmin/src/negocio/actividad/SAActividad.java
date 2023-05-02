package negocio.actividad;

import java.util.ArrayList;

public interface SAActividad {

	public int AltaActividad(TransActividad tActividad);

	public TransActividad MostrarActividad(int id);

	public ArrayList<TransActividad> ListarActividad();

	public int ModificarActividad(TransActividad tActividad);

	public int BajaActividad(int id);

}
