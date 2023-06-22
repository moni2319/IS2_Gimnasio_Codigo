	package integracion.sesion;



import java.util.ArrayList;

import negocio.sesion.TransSesion;

public interface DAOSesion {
	public boolean altaSesion(TransSesion tSesion);

	public boolean bajaSesion(int id);

	public TransSesion buscar(int id); 

	public boolean modificarSesion(TransSesion tSesion);

	public ArrayList<TransSesion> listaSesiones();

	public Object buscarClientesSesion(int id);
	
}
