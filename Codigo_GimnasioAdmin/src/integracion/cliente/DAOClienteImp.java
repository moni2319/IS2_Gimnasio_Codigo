package integracion.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.cliente.SAClienteImp.Nivel;
import negocio.cliente.TransCliente;
import negocio.monitor.TransMonitor;
import negocio.sesion.TransSesion;

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

	public int setCliente(PreparedStatement st, TransCliente tCliente) throws SQLException {

		st.setInt(1, tCliente.getId());
		st.setString(2, tCliente.getNombre());
		st.setInt(3, tCliente.getTelefono());

		return st.executeUpdate();
	}

	public boolean altaCliente(TransCliente tCliente) {
		String query = "INSERT INTO cliente (id, nombre, telefono) VALUES (?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			while (buscarCliente(TransCliente.ID_CONTADOR) != null) {
				TransCliente.ID_CONTADOR++;
			}
			tCliente.setId(TransCliente.ID_CONTADOR);

			return setCliente(st, tCliente) > 0;
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

	public boolean apuntarCliente(int s, int c, Nivel nivelEnum) {
		String query = "INSERT INTO niveles (idS, idC, nivel) VALUES (?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {

			st.setInt(1, s);
			st.setInt(2, c);
			st.setString(3, nivelEnum.toString());

			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	
	public ArrayList<Object[]> listarSesiones(int id) {
		ArrayList<Object[]> sesiones = new ArrayList<>();
		String query = "SELECT idS, nivel FROM niveles WHERE idC = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int s = rs.getInt("idS");
				String n = rs.getString("nivel");
			
				Object[] objecto = {s , n };
				sesiones.add(objecto);
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return sesiones;
	}

	
	public Object buscarClienteSesion(int id) {
		String query = "SELECT * FROM niveles WHERE idC = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			Object hay = null;
			if (rs.next()) {

				hay = rs.getInt("idC");
			}
			return hay;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Object buscarClienteSesion(int idC ,int idS) {
		String query = "SELECT * FROM niveles WHERE idC = ? AND idC = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, idC);
			st.setInt(2, idS);
			ResultSet rs = st.executeQuery();
			Object hay = null;
			if (rs.next()) {

				hay = rs.getInt("idS");
			}
			return hay;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
