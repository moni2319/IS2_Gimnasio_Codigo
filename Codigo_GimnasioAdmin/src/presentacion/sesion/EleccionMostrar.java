package presentacion.sesion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;


public class EleccionMostrar extends JFrame {
	public EleccionMostrar() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Alta Sesion");
		setSize(500, 400);
		setLocationRelativeTo(null);

		JButton ActividadButton = new JButton("Actividades");
		JButton EntrenamientoButton = new JButton("Entrenamientos");
		JButton SesionButton = new JButton("Sesiones");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

		panel.add(ActividadButton);
		panel.add(EntrenamientoButton);
		panel.add(SesionButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Botón de alta
		ActividadButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_LISTA_ACTIVIDAD, null);
			}

		});
		EntrenamientoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_LISTA_ENTRENAMIENTO, null);

			}

		});
		SesionButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_LISTA_ENTRENAMIENTO, null);

			}

		});
		setVisible(true);

	}
}
