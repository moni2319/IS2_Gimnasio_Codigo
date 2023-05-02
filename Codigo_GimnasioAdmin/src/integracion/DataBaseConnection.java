package integracion;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	/** Parametros de conexion **/
	private static String baseDatos = "gimnasio";
	private static String usuario = "root";
	private static String contraseña = "Gimnasio1234";
	private static String url = "jdbc:mysql://localhost:3306/" + baseDatos;
	private Connection connection = null;

	public DataBaseConnection() {
		try {
			// String url = " jdbc : mysql :// hostname / database - name ";
			connection = DriverManager.getConnection(url, usuario, contraseña);
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
