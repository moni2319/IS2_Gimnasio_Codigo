package integracion.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.cliente.TransCliente;
import negocio.monitor.TransMonitor;

public class DAOClienteImp implements DAOCliente {

	private Connection connection;
	private static DAOClienteImp daoCliente;

	public DAOClienteImp(Connection connect) {
		connection = connect;
	}

	static public DAOClienteImp getInstance(Connection connection) {
		if (daoCliente == null)
			daoCliente = new DAOClienteImp(connection);
		return daoCliente;
	}

	public boolean altaCliente(TransCliente tCliente) {
		String query = "INSERT INTO cliente (id, nombre, telefono) VALUES (?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tCliente.getId());
			st.setString(2, tCliente.getNombre());
			st.setInt(3, tCliente.getTelefono());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean bajaCliente(int id) {
		String query = "DELETE FROM cliente WHERE id = ?";
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

	public boolean modificarCliente(TransCliente tCliente) {
		String query = "UPDATE cliente SET nombre = ?, telefono = ? WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setString(1, tCliente.getNombre());
			st.setInt(2, tCliente.getTelefono());
			st.setInt(3, tCliente.getId());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public TransCliente buscarCliente(int id) {
		String query = "SELECT * FROM cliente WHERE id = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			return getNextCliente(rs);
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public TransCliente getNextCliente(ResultSet rs) {

		TransCliente cliente = null;
		try {
			if (rs.next()) {
				int i = rs.getInt("id");
				String n = rs.getString("nombre");
				int s = rs.getInt("telefono");

				cliente = new TransCliente(i, n, s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public ArrayList<TransCliente> listarCliente() {
		ArrayList<TransCliente> clientes = new ArrayList<>();
		String query = "SELECT * FROM cliente";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("id");
				String n = rs.getString("nombre");
				int s = rs.getInt("telefono");
				TransCliente monitor = new TransCliente(i, n, s);
				clientes.add(monitor);
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return clientes;
	}

}
