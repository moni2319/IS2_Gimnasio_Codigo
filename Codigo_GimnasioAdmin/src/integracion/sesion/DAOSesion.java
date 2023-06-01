package integracion.sesion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.sesion.SASesion;
import negocio.sesion.TransSesion;

public interface DAOSesion {
	public boolean altaSesion(TransSesion tSesion);

	public boolean bajaSesion(int id);

	public TransSesion buscar(int id); // es el mostrar realmente

	public boolean modificarSesion(TransSesion tSesion);

	public ArrayList<TransSesion> listaSesiones();
	
	public int setSesion(PreparedStatement st, TransSesion tSesion) throws SQLException;
}
