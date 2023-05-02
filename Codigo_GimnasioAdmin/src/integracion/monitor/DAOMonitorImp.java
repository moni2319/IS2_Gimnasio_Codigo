package integracion.monitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.material.TransMaterial;
import negocio.monitor.TransMonitor;

public class DAOMonitorImp implements DAOMonitor {

	private Connection connection;
	private static DAOMonitorImp daoMonitor;

	public DAOMonitorImp(Connection connect) {
		connection = connect;
	}

	static public DAOMonitorImp getInstance(Connection connection) {
		if (daoMonitor == null)
			daoMonitor = new DAOMonitorImp(connection);
		return daoMonitor;
	}

	public boolean altaMonitor(TransMonitor tMonitor) {
		String query = "INSERT INTO monitor (id, nombre, salario) VALUES (?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tMonitor.getId());
			st.setString(2, tMonitor.getNombre());
			st.setInt(3, tMonitor.getSalario());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean bajaMonitor(int id) {
		String query = "DELETE FROM monitor WHERE id = ?";
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

	public boolean modificarMonitor(TransMonitor tMonitor) {
		String query = "UPDATE monitor SET nombre = ?, stock = ? WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setString(1, tMonitor.getNombre());
			st.setInt(2, tMonitor.getSalario());
			st.setInt(3, tMonitor.getId());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public TransMonitor buscarMonitor(int id) {
		String query = "SELECT * FROM material WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			return getNextMonitor(rs);
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public TransMonitor getNextMonitor(ResultSet rs) {

		TransMonitor monitor = null;
		try {
			if (rs.next()) {
				int i = rs.getInt("id");
				String n = rs.getString("nombre");
				int s = rs.getInt("stock");

				monitor = new TransMonitor(i, n, s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return monitor;
	}

	public ArrayList<TransMonitor> listarMonitor() {
		ArrayList<TransMonitor> monitores = new ArrayList<>();
		String query = "SELECT * FROM monitor";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("id");
				String n = rs.getString("nombre");
				int s = rs.getInt("salario");
				TransMonitor monitor = new TransMonitor(i, n, s);
				monitores.add(monitor);
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return monitores;

	}

}
