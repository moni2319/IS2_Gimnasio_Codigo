package negocio.actividad;

import java.util.ArrayList;



public interface SAActividad {

	public int AltaActividad(SAActividad tActividad);

	public SAActividad MostrarActividad(int id);

	public ArrayList<SAActividad> ListarActividad();

	public int ModificarActividad(SAActividad tActividad);

	public int BajaActividad(int id);

}
