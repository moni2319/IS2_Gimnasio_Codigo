package presentacion.entrenamiento;

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

public class MostrarEntrenamiento extends JFrame {
	private JTextField txtId;

	public MostrarEntrenamiento() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Mostrar Entrenamiento");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del entrenamiento:");
		txtId = new JTextField(20);

		JButton mostrarButton = new JButton("Mostrar Entrenamiento");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(mostrarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de baja
		mostrarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id del entrenamiento.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtId.getText());
						Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_ENTRENAMIENTO, id);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el id sea válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al mostrar el entrenamiento: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
