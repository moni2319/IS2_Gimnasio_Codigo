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

public class AltaEntrenamiento extends JFrame{
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtCodigoMonitor;
	private JTextField txtPrecio;

	public AltaEntrenamiento() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Alta Entrenamiento");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del entrenamiento:");
		txtId = new JTextField(20);

		JLabel labelNomActividad = new JLabel("Nombre del entrenamiento:");
		txtNombre = new JTextField(20);

		JLabel labelCodMonitor = new JLabel("Id del monitor:");
		txtCodigoMonitor = new JTextField(20);

		JLabel labelPrecio = new JLabel("Precio del entrenamiento:");
		txtPrecio = new JTextField(20);

		JButton altaButton = new JButton("Dar de alta");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(labelNomActividad);
		panel.add(txtNombre);
		panel.add(labelCodMonitor);
		panel.add(txtCodigoMonitor);
		panel.add(labelPrecio);
		panel.add(txtPrecio);
		panel.add(altaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de alta
		altaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtNombre.getText().isEmpty() || txtCodigoMonitor.getText().isEmpty()
						|| txtId.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
				} else {
					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						int id = Integer.parseInt(txtId.getText());
						int idM = Integer.parseInt(txtCodigoMonitor.getText());
						int p = Integer.parseInt(txtPrecio.getText());
						String nombreActividad = txtNombre.getText();

						TransEntrenamiento tEntrenamiento = new TransEntrenamiento(id, idM, p, nombreActividad);

						Controlador.obtenerInstancia().Accion(Eventos.ALTA_ENTRENAMIENTO, tEntrenamiento);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al dar de alta el entrenamiento: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
