package negocio.actividad;

import negocio.sesion.TransSesion;

public class TransActividad extends TransSesion {

	private int aforo;

	public TransActividad(int idM, int p, int a, String n) {
		super(idM, p, n);
		aforo = a;
	}

	public TransActividad(int i, int idM, int p, int a, String n) {
		super(i, idM, p, n);
		aforo = a;
	}

	public int getAforo() {
		return aforo;
	}

}
