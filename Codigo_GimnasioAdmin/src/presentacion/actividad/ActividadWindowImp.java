package presentacion.actividad;

import javax.swing.*;

import negocio.actividad.SAActividad;
import negocio.actividad.TransActividad;
import presentacion.controlador.Eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActividadWindowImp extends ActividadWindow {

	public ActividadWindowImp() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Actividades");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de actividad
		JButton altaActividadButton = new JButton("Alta Actividad");
		JButton bajaActividadButton = new JButton("Baja Actividad");
		JButton modificarActividadButton = new JButton("Modificar Actividad");
		JButton mostrarActividadButton = new JButton("Mostrar Actividad");
		JButton listaActividadButton = new JButton("Lista de Actividades");

		// Agregar botones al panel
		panel.add(altaActividadButton);
		panel.add(bajaActividadButton);
		panel.add(modificarActividadButton);
		panel.add(mostrarActividadButton);
		panel.add(listaActividadButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de actividad
		altaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para alta de actividad
				AltaActividad altaActividad = new AltaActividad();
				altaActividad.setVisible(true);

			}
		});

		bajaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de actividad
				BajaActividad bajaActividad = new BajaActividad();
				bajaActividad.setVisible(true);
			}
		});

		modificarActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				ModificarActividad modificarActividad = new ModificarActividad();
				modificarActividad.setVisible(true);
			}
		});
		mostrarActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarActividad mostrarActividad =new MostrarActividad();
				mostrarActividad.setVisible(true);
			}
		});
		listaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				JOptionPane.showMessageDialog(ActividadWindowImp.this, "Funcionalidad de Listar Actividad");
			}
		});

		pack();
	}

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

		}
	}
}
