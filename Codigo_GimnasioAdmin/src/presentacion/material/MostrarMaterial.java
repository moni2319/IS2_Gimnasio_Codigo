package presentacion.material;

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

public class MostrarMaterial extends JFrame{
	private JTextField txtIdMaterial;

	public MostrarMaterial() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Mostrar AMaterial");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del material:");
		txtIdMaterial = new JTextField(20);

		JButton mostrarButton = new JButton("Mostrar Material");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtIdMaterial);
		panel.add(mostrarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de baja
		mostrarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtIdMaterial.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id del material.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtIdMaterial.getText());
						Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_MATERIAL, id);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el id sea válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al mostrar el material: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
