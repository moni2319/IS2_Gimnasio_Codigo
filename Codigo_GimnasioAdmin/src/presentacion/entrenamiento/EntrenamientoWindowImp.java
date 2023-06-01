package presentacion.entrenamiento;

import javax.swing.*;

import negocio.entrenamiento.TransEntrenamiento;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EntrenamientoWindowImp extends EntrenamientoWindow {

	public EntrenamientoWindowImp() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Entrenamientos");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de entrenamiento
		JButton altaEntrenamientoButton = new JButton("Alta Entrenamiento");
		
		JButton modificarEntrenamientoButton = new JButton("Modificar Entrenamiento");
		JButton mostrarEntrenamientoButton = new JButton("Mostrar Entrenamiento");
		JButton listaEntrenamientoButton = new JButton("Lista de Entrenamientos");

		// Agregar botones al panel
		panel.add(altaEntrenamientoButton);
		panel.add(modificarEntrenamientoButton);
		panel.add(mostrarEntrenamientoButton);
		panel.add(listaEntrenamientoButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de entrenamiento
		altaEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaEntrenamiento altaEntrenamiento = new AltaEntrenamiento();
				altaEntrenamiento.setVisible(true);
			}
		});

	

		modificarEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarEntrenamiento modificarEntrenamiento = new ModificarEntrenamiento();
				modificarEntrenamiento.setVisible(true);
			}
		});
		mostrarEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarEntrenamiento mostrarEntrenamiento = new MostrarEntrenamiento();
				mostrarEntrenamiento.setVisible(true);
			}
		});
		listaEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_LISTA_ENTRENAMIENTO, null);
			}
		});

		pack();
	}

	public void Actualizar(int evento, Object data) {
		switch (evento) {
		case Eventos.ALTA_ENTRENAMIENTO_BIEN: {
			TransEntrenamiento entrenamiento = (TransEntrenamiento) data;
			int id = entrenamiento.getId();
			JOptionPane.showMessageDialog(EntrenamientoWindowImp.this,
					"Entrenamiento: " + id + " dado de alta correctamente");
			break;
		}
		case Eventos.BAJA_ENTRENAMIENTO_BIEN: {
			int id = (int) data;
			JOptionPane.showMessageDialog(EntrenamientoWindowImp.this,
					"Entrenamiento: " + id + " dado de baja correctamente");
			break;
		}
		case Eventos.MODIFICAR_ENTRENAMIENTO_BIEN: {
			TransEntrenamiento entrenamiento = (TransEntrenamiento) data;
			int id = entrenamiento.getId();
			JOptionPane.showMessageDialog(EntrenamientoWindowImp.this,
					"Entrenamiento: " + id + " modificado correctamente");
			break;
		}
		case Eventos.MOSTRAR_ENTRENAMIENTO_BIEN: {
			TransEntrenamiento entrenamiento = (TransEntrenamiento) data;
			ArrayList<TransEntrenamiento> lista = new ArrayList<TransEntrenamiento>();
			lista.add(entrenamiento);

			MostrarEntrenamientoWindow mostrarWindow = new MostrarEntrenamientoWindow(lista);
			mostrarWindow.setVisible(true);

			break;
		}
		case Eventos.MOSTRAR_LISTA_ENTRENAMIENTO_BIEN: {

			ArrayList<TransEntrenamiento> lista = (ArrayList<TransEntrenamiento>) data;

			MostrarEntrenamientoWindow mostrarWindow = new MostrarEntrenamientoWindow(lista);
			mostrarWindow.setVisible(true);

			break;
		}
		}

	}

}
