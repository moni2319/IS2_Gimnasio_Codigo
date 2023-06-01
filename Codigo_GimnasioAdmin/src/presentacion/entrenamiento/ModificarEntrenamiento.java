package presentacion.entrenamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.entrenamiento.TransEntrenamiento;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class ModificarEntrenamiento extends JFrame {
	
	private JTextField txtNombre;
	private JTextField txtCodigoMonitor;
	private JTextField txtPrecio;

	public ModificarEntrenamiento(int id) {
		initComponents(id);
	}

	private void initComponents(int id) {
		setTitle("Modificar Entrenamiento");
		setSize(300, 400);
		setLocationRelativeTo(null);

		

		JLabel labelNombre = new JLabel("Nombre del entrenamiento:");
		txtNombre = new JTextField(20);

		JLabel labelCodMonitor = new JLabel("Id del monitor:");
		txtCodigoMonitor = new JTextField(20);

		JLabel labelPrecio = new JLabel("Precio del entrenamiento:");
		txtPrecio = new JTextField(20);

		JButton modificarButton = new JButton("Modificar Entrenamiento");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelCodMonitor);
		panel.add(txtCodigoMonitor);
		panel.add(labelPrecio);
		panel.add(txtPrecio);
		panel.add(modificarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de modificar
		modificarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtNombre.getText().isEmpty() || txtCodigoMonitor.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						
						int idM = Integer.parseInt(txtCodigoMonitor.getText());
						int p = Integer.parseInt(txtPrecio.getText());
						String nombre = txtNombre.getText();

						TransEntrenamiento tEntrenamiento = new TransEntrenamiento(id, idM, p, nombre);

						Controlador.obtenerInstancia().Accion(Eventos.MODIFICAR_ENTRENAMIENTO, tEntrenamiento);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null,
								"Error al modificar el entrenamiento: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
