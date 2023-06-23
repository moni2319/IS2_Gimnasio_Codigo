package negocio.sesion;

import java.util.ArrayList;



public interface SASesion {

	public int AltaSesion(TransSesion tSesion);

	public TransSesion MostrarSesion(int id);

	public ArrayList<TransSesion> ListarSesion();

	public int ModificarSesion(TransSesion tSesion);

	public int BajaSesion(int id);

	public ArrayList<Object[]> ListarClientes(int id);

}
