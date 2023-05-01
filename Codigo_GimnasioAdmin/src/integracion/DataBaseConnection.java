package integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	/** Parametros de conexion **/
	private static String bd = "cliente";
	private static String login = "XYZ";
	private static String password = "ABC";
	private static String url = "jdbc:mysql://localhost/" + bd;
	private Connection connection = null;

	public DataBaseConnection() {
		try {
			// String url = " jdbc : mysql :// hostname / database - name ";
			connection = DriverManager.getConnection(url, login, password);
		} catch (SQLException ex) {
			connection = null;
			ex.printStackTrace();
			System.err.println(" SQLException : " + ex.getMessage());
			System.err.println(" SQLState : " + ex.getSQLState());
			System.err.println(" VendorError : " + ex.getErrorCode());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}
