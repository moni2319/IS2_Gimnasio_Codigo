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

public class BajaEntrenamiento extends JFrame {
	private JTextField txtId;

	public BajaEntrenamiento() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Baja Entrenamiento");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del entrenamiento:");
		txtId = new JTextField(20);

		JButton bajaButton = new JButton("Dar de baja");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(bajaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de baja
		bajaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id a dar de baja.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtId.getText());
						Controlador.obtenerInstancia().Accion(Eventos.BAJA_ENTRENAMIENTO, id);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el id sean válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null,
								"Error al dar de baja el entrenamiento: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
