package negocio.actividad;

import java.util.ArrayList;

import integracion.actividad.DAOActividad;
import integracion.factoria.FactoriaDAOImp;

public class SAActividadImp implements SAActividad {

	private DAOActividad daoActividad;

	public SAActividadImp() {
		daoActividad = new FactoriaDAOImp().getDAOActividad();
	}

	// comprobar que son validos los datos de tActividad, si no lo son,
	// devolvemos
	// -1 o numero que indique error

	// Ver si ya existe, si existe igual devolver -1
	// crear funcion que lea las actividades de la base de datos para ver si
	// esta

	// Si cumple con ambas llamo al DAO de AltaActividad (el dao es igual q
	// el SA)
	// DAO comprueba con BBDD
	// Crear factoria para DAOS
	// De ahi hacen cadena de resultados para saber ssi se ha hecho o no

	@Override
	public int AltaActividad(TransActividad tActividad) {

		if (daoActividad.buscar(tActividad.getId()) != null) {
			throw new IllegalArgumentException("Ya existe una actividad con id " + tActividad.getId());
		}
		boolean exito = daoActividad.altaActividad(tActividad);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo guarda en la base de datos la actividad");
		}

		return 0;
	}
	
	@Override
	public int BajaActividad(int id) {
		if (daoActividad.buscar(id) == null) {
			throw new IllegalArgumentException("No existe una actividad con id " + id);
		}
		boolean exito = daoActividad.bajaActividad(id);
		if (!exito) {
			throw new IllegalArgumentException("No se pudo quitar en la base de datos la actividad");
		}
		return 0;
	}

	@Override
	public TransActividad MostrarActividad(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransActividad> ListarActividad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Modificar(TransActividad tActividad) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
