package integracion.sesion;

import java.util.ArrayList;
import java.util.List;

import negocio.sesion.SASesion;

public interface DAOSesion {
	public boolean altaSesion(SASesion tSesion);

	public boolean bajaSesion(int id);

	public SASesion buscar(int id); // es el mostrar realmente

	public boolean modificarSesion(SASesion tSesion);

	public ArrayList<SASesion> listaSesiones();
}
