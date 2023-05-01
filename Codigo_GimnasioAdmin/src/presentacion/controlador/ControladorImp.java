package presentacion.controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import negocio.actividad.SAActividad;
import negocio.actividad.TransActividad;
import negocio.factorias.FactoriaSA;
import negocio.factorias.FactoriaSAImp;
import presentacion.actividad.ActividadWindow;

public class ControladorImp extends Controlador {
	FactoriaSA factoria;

	public ControladorImp() {

		// negocios en negocio
		factoria = new FactoriaSAImp();
	}

	public void Accion(int event, Object trans) {
		switch (event) {
		case Eventos.ALTA_ACTIVIDAD: {
			
			TransActividad tActividad = (TransActividad) trans;

			// Modelo
			SAActividad actividad = factoria.getInstanciaSAActividad();
			
			
			// HAY q crear las instanicas
			int resultado = actividad.AltaActividad(tActividad);
			
			if (resultado > 0) // pasarle la ventana
				ActividadWindow.obtenerInstancia().Actualizar(Eventos.RES_ALTA_ACTIVIDAD_OK, resultado);
			else
				ActividadWindow.obtenerInstancia().Actualizar(Eventos.RES_ALTA_ACTIVIDAD_KO, resultado);
			
			break;
		}
		// case Evento.BAJA_USUARIO: { …… }

		}
	}

}
