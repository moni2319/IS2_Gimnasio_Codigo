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
import negocio.sesion.SASesion;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class ModificarActividad extends JFrame {
	
	private JTextField txtNombreActividad;
	private JTextField txtCodigoMonitor;
	private JTextField txtPrecioActividad;
	private JTextField txtAforoActividad;

	public ModificarActividad(int id) {
		initComponents(id);
	}

	private void initComponents(int id) {
		setTitle("Modificar Actividad");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelNomActividad = new JLabel("Nombre de la actividad:");
		txtNombreActividad = new JTextField(20);

		JLabel labelCodMonitor = new JLabel("Código del monitor:");
		txtCodigoMonitor = new JTextField(20);

		JLabel labelPrecio = new JLabel("Precio de la actividad:");
		txtPrecioActividad = new JTextField(20);

		JLabel labelAforo = new JLabel("Aforo de la actividad:");
		txtAforoActividad = new JTextField(20);

		JButton modificarButton = new JButton("Modificar actividad");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		
		panel.add(labelNomActividad);
		panel.add(txtNombreActividad);
		panel.add(labelCodMonitor);
		panel.add(txtCodigoMonitor);
		panel.add(labelPrecio);
		panel.add(txtPrecioActividad);
		panel.add(labelAforo);
		panel.add(txtAforoActividad);
		panel.add(modificarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de modificar
		modificarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtNombreActividad.getText().isEmpty() || txtCodigoMonitor.getText().isEmpty()
						||  txtPrecioActividad.getText().isEmpty()
						|| txtAforoActividad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
				} else {
					// Realizar la lógica de modificar de la actividad en la
					// BBDD

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						
						int idM = Integer.parseInt(txtCodigoMonitor.getText());
						int a = Integer.parseInt(txtAforoActividad.getText());
						int p = Integer.parseInt(txtPrecioActividad.getText());
						String nombreActividad = txtNombreActividad.getText();

						TransActividad tActividad = new TransActividad(id, idM, p, a, nombreActividad);

						Controlador.obtenerInstancia().Accion(Eventos.MODIFICAR_ACTIVIDAD, tActividad);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al modificar la actividad: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
