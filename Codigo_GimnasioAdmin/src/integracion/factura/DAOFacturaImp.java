package integracion.factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	@Override
	public TransFactura buscarFactura(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransFactura> buscarFacturasCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransFactura> listarFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarFactura(TransFactura tActividad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cerrarActividad(int cod) {
		// TODO Auto-generated method stub
		return false;
	}

}
