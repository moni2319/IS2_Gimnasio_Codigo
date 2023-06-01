package presentacion.actividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import negocio.sesion.SASesion;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class AltaActividad extends JFrame {
	private JTextField txtIdActividad;
	private JTextField txtNombreActividad;
	private JTextField txtCodigoMonitor;
	private JTextField txtPrecioActividad;
	private JTextField txtAforoActividad;

	public AltaActividad() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Alta Actividad");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id de la actividad:");
		txtIdActividad = new JTextField(20);

		JLabel labelNomActividad = new JLabel("Nombre de la actividad:");
		txtNombreActividad = new JTextField(20);

		JLabel labelCodMonitor = new JLabel("Código del monitor:");
		txtCodigoMonitor = new JTextField(20);

		JLabel labelPrecio = new JLabel("Precio de la actividad:");
		txtPrecioActividad = new JTextField(20);

		JLabel labelAforo = new JLabel("Aforo de la actividad:");
		txtAforoActividad = new JTextField(20);

		JButton altaButton = new JButton("Dar de alta");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtIdActividad);
		panel.add(labelNomActividad);
		panel.add(txtNombreActividad);
		panel.add(labelCodMonitor);
		panel.add(txtCodigoMonitor);
		panel.add(labelPrecio);
		panel.add(txtPrecioActividad);
		panel.add(labelAforo);
		panel.add(txtAforoActividad);
		panel.add(altaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de alta
		altaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtNombreActividad.getText().isEmpty() || txtCodigoMonitor.getText().isEmpty()
						|| txtIdActividad.getText().isEmpty() || txtPrecioActividad.getText().isEmpty()
						|| txtAforoActividad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
				} else {
					// Realizar la lógica de alta de la actividad en la base de
					// datos

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						int id = Integer.parseInt(txtIdActividad.getText());
						int idM = Integer.parseInt(txtCodigoMonitor.getText());
						int a = Integer.parseInt(txtAforoActividad.getText());
						int p = Integer.parseInt(txtPrecioActividad.getText());
						String nombreActividad = txtNombreActividad.getText();

						SASesion tActividad = new SASesion(id, idM, p, a, nombreActividad);

						Controlador.obtenerInstancia().Accion(Eventos.ALTA_ACTIVIDAD, tActividad);

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
