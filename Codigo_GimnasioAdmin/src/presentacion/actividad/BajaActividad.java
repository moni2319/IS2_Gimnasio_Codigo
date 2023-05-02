package presentacion.actividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.actividad.TransActividad;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class BajaActividad extends JFrame {
	private JTextField txtIdActividad;

	public BajaActividad() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Baja Actividad");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id de la actividad:");
		txtIdActividad = new JTextField(20);

		JButton bajaButton = new JButton("Dar de baja");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtIdActividad);
		panel.add(bajaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de baja
		bajaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtIdActividad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id a dar de baja.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtIdActividad.getText());
						Controlador.obtenerInstancia().Accion(Eventos.BAJA_ACTIVIDAD, id);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al dar de alta la actividad: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
