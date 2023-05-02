package integracion.monitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarMonitor(TransMonitor tMonitor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TransMonitor buscarMonitor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransMonitor> listarMonitor() {
		// TODO Auto-generated method stub
		return null;
	}

}
