package presentacion.actividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class MostrarActividad extends JFrame {
	private JTextField txtIdActividad;

	public MostrarActividad() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Mostrar Actividad");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id de la actividad:");
		txtIdActividad = new JTextField(20);

		JButton bajaButton = new JButton("Mostrar Actividad");

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
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id de la actividad.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtIdActividad.getText());
						Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_ACTIVIDAD, id);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el id sea válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al mostrar la actividad: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
