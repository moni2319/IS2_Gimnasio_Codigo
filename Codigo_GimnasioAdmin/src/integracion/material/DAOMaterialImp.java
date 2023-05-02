package integracion.material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.material.TransMaterial;

public class DAOMaterialImp implements DAOMaterial {

	private Connection connection;
	private static DAOMaterialImp daoMaterial;

	public DAOMaterialImp(Connection connect) {
		connection = connect;
	}

	static public DAOMaterialImp getInstance(Connection connection) {
		if (daoMaterial == null)
			daoMaterial = new DAOMaterialImp(connection);
		return daoMaterial;
	}

	public boolean altaMaterial(TransMaterial tMaterial) {
		String query = "INSERT INTO material (id, nombre, stock) VALUES (?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tMaterial.getId());
			st.setString(2, tMaterial.getNombre());
			st.setInt(3, tMaterial.getStock());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean bajaMaterial(int id) {
		String query = "DELETE FROM material WHERE id = ?";
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

	public boolean modificarMaterial(TransMaterial tMaterial) {
		String query = "UPDATE material SET nombre = ?, stock = ? WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setString(1, tMaterial.getNombre());
			st.setInt(2, tMaterial.getStock());
			st.setInt(3, tMaterial.getId());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public TransMaterial buscarMaterial(int id) {
		String query = "SELECT * FROM material WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			return getNextMaterial(rs);
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public TransMaterial getNextMaterial(ResultSet rs) {

		TransMaterial material = null;
		try {
			if (rs.next()) {
				int i = rs.getInt("id");
				String n = rs.getString("nombre");
				int s = rs.getInt("stock");

				material = new TransMaterial(i, n, s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return material;
	}

	public ArrayList<TransMaterial> listarMaterial() {
		ArrayList<TransMaterial> materiales = new ArrayList<>();
		String query = "SELECT * FROM material";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("id");
				String n = rs.getString("nombre");
				int s = rs.getInt("stock");
				TransMaterial material = new TransMaterial(i, n, s);
				materiales.add(material);
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return materiales;
	}

}
