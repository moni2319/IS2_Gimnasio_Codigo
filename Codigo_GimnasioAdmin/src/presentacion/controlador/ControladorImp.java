package presentacion.controlador;

import negocio.actividad.SAActividad;
import negocio.actividad.TransActividad;
import presentacion.actividad.ActividadWindow;

public class ControladorImp extends Controlador {
	// FactoriaNegocio factNegocio;

	public ControladorImp() {
		// factNegocio = Controlador.obtenerInstancia(); crear factoria de
		// negocios en negocio

	}

	public void Accion(int event, Object trans) {
		switch (event) {
		case Eventos.ALTA_ACTIVIDAD: {
			TransActividad tActividad = (TransActividad) trans;
			// Modelo

			// HAY q crear las instanicas
			int resultado = SAActividad.AltaActividad(tActividad);
			if (resultado > 0) // pasarle la ventana
				ActividadWindow.Actualizar(Eventos.RES_ALTA_ACTIVIDAD_OK, resultado);
			else
				ActividadWindow.Actualizar(Eventos.RES_ALTA_ACTIVIDAD_KO, resultado);
			break;
		}
		// case Evento.BAJA_USUARIO: { …… }

		}
	}

}
