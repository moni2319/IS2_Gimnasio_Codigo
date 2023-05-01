package negocio.actividad;

import java.util.ArrayList;

public class SAActividadImp implements SAActividad{

	@Override
	public int AltaActividad(TransActividad tActividad) {
		// TODO Auto-generated method stub
		
		// comprobar que son validos los datos de tActividad, si no lo son, devolvemos 
		// -1 o numero que indique error 
		
		// Ver si ya existe, si existe igual devolver -1
		// crear funcion que lea las actividades de la base de datos para ver si esta
		
		// Si cumple con ambas llamo al DAO de AltaActividad (el dao es igual q el SA)
		//DAO comprueba con BBDD
		//Crear factoria para DAOS
		// De ahi hacen cadena de resultados para saber ssi se ha hecho o no
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

	@Override
	public int BajaActividad(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
