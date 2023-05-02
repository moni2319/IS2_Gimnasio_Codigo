package integracion;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	/** Parametros de conexion **/
	private static String bd = "gimnasio";
	private static String login = "root";
	private static String password = "Gimnasio1234";
	private static String url = "jdbc:mysql://localhost:3306/" + bd;
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
