package presentacion.sesion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.entrenamiento.TransEntrenamiento;
import presentacion.actividad.AltaActividad;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.entrenamiento.AltaEntrenamiento;

public class AltaSesion extends JFrame {
	

	public AltaSesion() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Alta Sesion");
		setSize(500, 400);
		setLocationRelativeTo(null);

	

		JButton ActividadButton = new JButton("Actividad");
		JButton EntrenamientoButton = new JButton("Entrenamiento");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		
		panel.add(ActividadButton);
		panel.add(EntrenamientoButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Botón de alta
		ActividadButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AltaActividad altaActividad = new AltaActividad();
				altaActividad.setVisible(true);
				}
			
		});
		EntrenamientoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AltaEntrenamiento altaEntrenamiento = new AltaEntrenamiento();
				altaEntrenamiento.setVisible(true);
					
				}
			
		});
		setVisible(true);

	}
}
