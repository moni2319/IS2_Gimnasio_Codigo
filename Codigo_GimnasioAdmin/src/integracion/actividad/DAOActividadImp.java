package integracion.actividad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.actividad.TransActividad;


public class DAOActividadImp implements DAOActividad {

	private Connection connection;
	private static DAOActividadImp daoActividad;

	public DAOActividadImp(Connection connect) {
		connection = connect;
	}

	static public DAOActividadImp getInstance(Connection connection) {
		if (daoActividad == null)
			daoActividad = new DAOActividadImp(connection);
		return daoActividad;
	}

	public boolean altaActividad(TransActividad tActividad) {
		String query = "INSERT INTO actividad (id, idMonitor, nombre, precio, aforo) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tActividad.getId());
			st.setInt(2, tActividad.getIdM());
			st.setString(3, tActividad.getNombre());
			st.setDouble(4, tActividad.getPrecio());
			st.setInt(5, tActividad.getAforo());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean bajaActividad(int id) {
		String query = "DELETE FROM actividad WHERE id = ?";
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

	public TransActividad buscar(int id) {
		String query = "SELECT * FROM actividad WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {

			// Dar valores a parametro de busqueda
			st.setInt(1, id);
			// Ejecuta la query
			ResultSet rs = st.executeQuery();
			return getNextActividad(rs);
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public TransActividad getNextActividad(ResultSet rs) { // tomar la actividad
															// de la BBDD
		TransActividad actividad = null;
		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				int idM = rs.getInt("idMonitor");
				String nombre = rs.getString("nombre");
				int p = rs.getInt("precio");
				int a = rs.getInt("aforo");

				actividad = new TransActividad(id, idM, p, a, nombre);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actividad;
	}

	public boolean modificarActividad(TransActividad tActividad) {
		String query = "UPDATE actividad SET idMonitor = ?, nombre = ?, precio = ?, aforo = ? WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tActividad.getIdM());
			st.setString(2, tActividad.getNombre());
			st.setDouble(3, tActividad.getPrecio());
			st.setInt(4, tActividad.getAforo());
			st.setInt(5, tActividad.getId());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<TransActividad> listaActividades() {
		ArrayList<TransActividad> actividades = new ArrayList<>();
		String query = "SELECT * FROM actividad";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int idM = rs.getInt("idMonitor");
				String nombre = rs.getString("nombre");
				int p = rs.getInt("precio");
				int a = rs.getInt("aforo");
				TransActividad actividad = new TransActividad(id, idM, p, a, nombre);
				actividades.add(actividad);
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return actividades;
	}

}
