package integracion.sesion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import negocio.sesion.SASesion;
import negocio.sesion.TransSesion;

public class DAOSesionImp implements DAOSesion {

	private Connection connection;
	private static DAOSesionImp daoSesion;

	public DAOSesionImp(Connection connect) {
		connection = connect;
	}

	static public DAOSesionImp getInstance(Connection connection) {
		if (daoSesion == null)
			daoSesion = new DAOSesionImp(connection);
		return daoSesion;
	}

	public int setSesion(PreparedStatement st, TransSesion tSesion) throws SQLException {
		
		st.setInt(2, tSesion.getIdM());
		st.setString(3, tSesion.getNombre());
		st.setDouble(4, tSesion.getPrecio());

		return st.executeUpdate();
	}

	public boolean altaSesion(TransSesion tSesion) {
		String query = "INSERT INTO sesion (id, idMonitor, nombre, precio) VALUES (?, ?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			TransSesion.ID_CONTADOR++;
			st.setInt(1, TransSesion.ID_CONTADOR);
			return setSesion(st, tSesion) > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean bajaSesion(int id) {
		String query = "DELETE FROM sesion WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public TransSesion buscar(int id) {
		String query = "SELECT * FROM sesion WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			return getNextSesion(rs);
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public TransSesion getNextSesion(ResultSet rs) {

		TransSesion sesion = null;
		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				int idM = rs.getInt("idMonitor");
				String nombre = rs.getString("nombre");
				int p = rs.getInt("precio");
				sesion = new TransSesion(id, idM, p, nombre);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sesion;
	}

	public boolean modificarSesion(TransSesion tSesion) {
		String query = "UPDATE sesion SET idMonitor = ?, nombre = ?, precio = ?, WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {

			return setSesion(st, tSesion) > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<TransSesion> listaSesiones() {
		ArrayList<TransSesion> sesiones = new ArrayList<>();
		String query = "SELECT * FROM sesion";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				sesiones.add(getNextSesion(rs));
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return sesiones;
	}

}
