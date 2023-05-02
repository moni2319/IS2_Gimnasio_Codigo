package integracion.factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.factura.TransFactura;

public class DAOFacturaImp implements DAOFactura {

	private Connection connection;
	private static DAOFacturaImp daoFactura;

	public DAOFacturaImp(Connection connect) {
		connection = connect;
	}

	static public DAOFacturaImp getInstance(Connection connection) {
		if (daoFactura == null)
			daoFactura = new DAOFacturaImp(connection);
		return daoFactura;
	}

	public boolean abrirFactura(TransFactura tFactura) {
		String query = "INSERT INTO factura (cod, idCliente, importe) VALUES (?, ?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tFactura.getCod());
			st.setInt(2, tFactura.getIdCliente());
			st.setInt(3, tFactura.getImporte());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public TransFactura buscarFactura(int cod) {
		String query = "SELECT * FROM factura WHERE cod = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, cod);
			ResultSet rs = st.executeQuery();
			return getNextFactura(rs);
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public TransFactura getNextFactura(ResultSet rs) {

		TransFactura factura = null;
		try {
			if (rs.next()) {
				int cod = rs.getInt("cod");
				int idC = rs.getInt("idCliente");
				int imp = rs.getInt("importe");

				factura = new TransFactura(cod, idC, imp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return factura;
	}

	public ArrayList<TransFactura> buscarFacturasCliente(int idCliente) {
		ArrayList<TransFactura> facturas = new ArrayList<>();
		String query = "SELECT * FROM factura WHERE idCliente = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, idCliente);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int cod = rs.getInt("cod");
				int idC = rs.getInt("idCliente");
				int imp = rs.getInt("importe");
				TransFactura factura = new TransFactura(cod, idC, imp);
				facturas.add(factura);
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return facturas;
	}

	public ArrayList<TransFactura> listarFactura() {
		ArrayList<TransFactura> facturas = new ArrayList<>();
		String query = "SELECT * FROM factura";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int cod = rs.getInt("cod");
				int idC = rs.getInt("idCliente");
				int imp = rs.getInt("importe");
				TransFactura factura = new TransFactura(cod, idC, imp);
				facturas.add(factura);
			}
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return facturas;
	}

	public boolean modificarFactura(TransFactura tFactura) {
		String query = "UPDATE factura SET idCliente = ?, importe = ? WHERE cod = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, tFactura.getIdCliente());
			st.setInt(2, tFactura.getImporte());
			st.setInt(3, tFactura.getCod());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean cerrarFactura(int cod) {
		String query = "DELETE FROM factura WHERE cod = ?";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, cod);
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
