package presentacion.sesion;

import javax.swing.*;


import negocio.actividad.TransActividad;
import negocio.sesion.TransSesion;
import presentacion.actividad.AltaActividad;

import presentacion.actividad.ModificarActividad;

import presentacion.actividad.MostrarActividadWindow;
import presentacion.cliente.MostrarSesionesWindow;
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
		JButton mostrarClientesButton = new JButton("Mostrar Clientes de Sesion");

		// Agregar botones al panel
		panel.add(altaSesionButton);
		panel.add(bajaSesionButton);
		panel.add(modificarSesionButton);
		panel.add(mostrarSesionButton);
		panel.add(mostrarClientesButton);
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
				// L�gica para baja de actividad
				BajaSesion bajaActividad = new BajaSesion();
				bajaActividad.setVisible(true);
			}
		});

		modificarSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para modificar actividad
				ModificarSesion modificarSesion = new ModificarSesion();
				modificarSesion.setVisible(true);
			}
		});
		mostrarSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarSesion mostrarSesion = new MostrarSesion();
				mostrarSesion.setVisible(true);
			}
		});
		mostrarClientesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarClientes mostrarClientes = new MostrarClientes();
				mostrarClientes.setVisible(true);
			}
		});
		listaSesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EleccionMostrar eleccionMostrar = new EleccionMostrar();
				eleccionMostrar.setVisible(true);
			}
		});

		pack();
	}

	public void Actualizar(int evento, Object data) {
		
		switch (evento) {
		
		case Eventos.MOSTRAR_LISTA_SESION_BIEN: {

			ArrayList<TransSesion> lista = (ArrayList<TransSesion>) data;

			MostrarSesionWindow mostrarWindow = new MostrarSesionWindow(lista);
			mostrarWindow.setVisible(true);

			break;
		}
		case Eventos.MOSTRAR_CLIENTES_SESION_BIEN: {
			
			
			ArrayList<Object[]> lista = (ArrayList<Object[]>) data;

			MostrarClientesWindow clientesWindow = new MostrarClientesWindow(lista);
			clientesWindow.setVisible(true);

			break;
		}

		}
	}
}
