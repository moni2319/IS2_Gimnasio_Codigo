package integracion.actividad;

import java.sql.Connection;

import negocio.actividad.TransActividad;

public class DAOActividadImp implements DAOActividad {
	private Connection connection;

	public DAOActividadImp(Connection connect) {
		connection = connect;
	}

	@Override
	public boolean AltaActividad(TransActividad tActividad) {
		// TODO Auto-generated method stub
		return false;
	}

}
