package presentacion.sesion;

import javax.swing.*;


import negocio.actividad.TransActividad;

import presentacion.actividad.AltaActividad;

import presentacion.actividad.ModificarActividad;
import presentacion.actividad.MostrarActividad;
import presentacion.actividad.MostrarActividadWindow;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SesionWindowImp extends SesionWindow {

	public SesionWindowImp() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Sesiones");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de actividad
		JButton altaSesionButton = new JButton("Alta Sesion");
		JButton bajaSesionButton = new JButton("Baja Sesion");
		JButton modificarSesionButton = new JButton("Modificar Sesion");
		JButton mostrarSesionButton = new JButton("Mostrar Sesion");
		JButton listaSesionButton = new JButton("Lista de Sesiones");

		// Agregar botones al panel
		panel.add(altaSesionButton);
		panel.add(bajaSesionButton);
		panel.add(modificarSesionButton);
		panel.add(mostrarSesionButton);
		panel.add(listaSesionButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de actividad
		altaSesionButton.addActionListener(new ActionListener() { // preguntar uno u otro
			public void actionPerformed(ActionEvent e) {
				
				AltaSesion altaSesion = new AltaSesion();
				altaSesion.setVisible(true);

			}
		});

		bajaSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de actividad
				BajaSesion bajaActividad = new BajaSesion();
				bajaActividad.setVisible(true);
			}
		});

		modificarSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				ModificarSesion modificarSesion = new ModificarSesion();
				modificarSesion.setVisible(true);
			}
		});
		mostrarSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarActividad mostrarActividad = new MostrarActividad();
				mostrarActividad.setVisible(true);
			}
		});
		listaSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_LISTA_ACTIVIDAD, null);
			}
		});

		pack();
	}

	public void Actualizar(int evento, Object data) {
		switch (evento) {
		
		case Eventos.MOSTRAR_LISTA_ACTIVIDAD_BIEN: {

			ArrayList<TransActividad> lista = (ArrayList<TransActividad>) data;

			MostrarActividadWindow mostrarWindow = new MostrarActividadWindow(lista);
			mostrarWindow.setVisible(true);

			break;
		}

		}
	}
}
