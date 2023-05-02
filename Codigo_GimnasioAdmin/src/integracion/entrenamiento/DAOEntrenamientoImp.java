package integracion.entrenamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.actividad.TransActividad;
import negocio.entrenamiento.TransEntrenamiento;

public class DAOEntrenamientoImp implements DAOEntrenamiento {

	private Connection connection;
	private static DAOEntrenamientoImp daoEntrenamiento;

	public DAOEntrenamientoImp(Connection connect) {
		connection = connect;
	}

	static public DAOEntrenamientoImp getInstance(Connection connection) {
		if (daoEntrenamiento == null)
			daoEntrenamiento = new DAOEntrenamientoImp(connection);
		return daoEntrenamiento;
	}

	public boolean altaEntrenamiento(TransEntrenamiento tEntrenamiento) {
		String query = "INSERT INTO entrenamiento (id, idMonitor, nombre, precio) VALUES (?, ?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tEntrenamiento.getId());
			st.setInt(2, tEntrenamiento.getIdM());
			st.setString(3, tEntrenamiento.getNombre());
			st.setInt(4, tEntrenamiento.getPrecio());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean bajaEntrenamiento(int id) {
		String query = "DELETE FROM entrenamiento WHERE id = ?";
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

	public TransEntrenamiento buscarEntrenamiento(int id) {
		String query = "SELECT * FROM entrenamiento WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {

			// Dar valores a parametro de busqueda
			st.setInt(1, id);
			// Ejecuta la query
			ResultSet rs = st.executeQuery();
			return getNextEntrenamiento(rs);
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public TransEntrenamiento getNextEntrenamiento(ResultSet rs) {
		TransEntrenamiento entrenamiento = null;
		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				int idM = rs.getInt("idMonitor");
				String nombre = rs.getString("nombre");
				int p = rs.getInt("precio");

				entrenamiento = new TransEntrenamiento(id, idM, p, nombre);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entrenamiento;
	}

	public boolean modificarEntrenamiento(TransEntrenamiento tEntrenamiento) {
		String query = "UPDATE entrenamiento SET idMonitor = ?, nombre = ?, precio = ? WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tEntrenamiento.getIdM());
			st.setString(2, tEntrenamiento.getNombre());
			st.setInt(3, tEntrenamiento.getPrecio());
			st.setInt(5, tEntrenamiento.getId());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<TransEntrenamiento> listaEntrenamiento() {
		ArrayList<TransEntrenamiento> entrenamientos = new ArrayList<>();
		String query = "SELECT * FROM entrenamiento";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int idM = rs.getInt("idMonitor");
				String nombre = rs.getString("nombre");
				int p = rs.getInt("precio");
				TransEntrenamiento entrenamiento = new TransEntrenamiento(id, idM, p, nombre);
				entrenamientos.add(entrenamiento);
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return entrenamientos;
	}

}
