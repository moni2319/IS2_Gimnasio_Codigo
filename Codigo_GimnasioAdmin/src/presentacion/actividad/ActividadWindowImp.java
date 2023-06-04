package presentacion.actividad;

import javax.swing.*;

import negocio.actividad.SAActividad;
import negocio.actividad.TransActividad;
import negocio.sesion.SASesion;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActividadWindowImp extends ActividadWindow {

	

	public void Actualizar(int evento, Object data) {
		switch (evento) {
		case Eventos.ALTA_ACTIVIDAD_BIEN: {
			TransActividad actividad = (TransActividad) data;
			int id = actividad.getId();
			JOptionPane.showMessageDialog(ActividadWindowImp.this, "Actividad: " + id + " dada de alta correctamente");
			break;
		}
		case Eventos.BAJA_ACTIVIDAD_BIEN: {
			int id = (int) data;
			JOptionPane.showMessageDialog(ActividadWindowImp.this, "Actividad: " + id + " dada de baja correctamente");
			break;
		}
		case Eventos.MODIFICAR_ACTIVIDAD_BIEN: {
			TransActividad actividad = (TransActividad) data;
			int id = actividad.getId();
			JOptionPane.showMessageDialog(ActividadWindowImp.this, "Actividad: " + id + " modificada correctamente");
			break;
		}
		case Eventos.MOSTRAR_ACTIVIDAD_BIEN: {
			TransActividad actividad = (TransActividad) data;
			ArrayList<TransActividad> lista = new ArrayList<TransActividad>();
			lista.add(actividad);

			MostrarActividadWindow mostrarWindow = new MostrarActividadWindow(lista);
			mostrarWindow.setVisible(true);

			break;
		}
		case Eventos.MOSTRAR_LISTA_ACTIVIDAD_BIEN: {

			ArrayList<TransActividad> lista = (ArrayList<TransActividad>) data;

			MostrarActividadWindow mostrarWindow = new MostrarActividadWindow(lista);
			mostrarWindow.setVisible(true);

			break;
		}

		}
	}
}
