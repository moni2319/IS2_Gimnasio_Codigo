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

	public void Accion(int event, Object info) {
		switch (event) {
		//ACTIVIDAD
		case Eventos.ALTA_ACTIVIDAD: {
			TransActividad tActividad = (TransActividad) info;
			SAActividad actividad = factoria.getInstanciaSAActividad();
			try {
				int resultado = actividad.AltaActividad(tActividad);

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.BAJA_ACTIVIDAD: {
			int id = (int) info;
			SAActividad actividad = factoria.getInstanciaSAActividad();
			try {
				int resultado = actividad.BajaActividad(id);

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MODIFICAR_ACTIVIDAD: {
			TransActividad tActividad = (TransActividad) info;
			SAActividad actividad = factoria.getInstanciaSAActividad();
			try {
				int resultado = actividad.ModificarActividad(tActividad);

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		}
	}

}
