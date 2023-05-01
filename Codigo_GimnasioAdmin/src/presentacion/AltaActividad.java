package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AltaActividad extends JFrame {
	private JTextField txtNombreActividad;
	private JTextField txtCodigoMonitor;

	public AltaActividad() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Alta Actividad");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelNomActividad = new JLabel("Nombre de la actividad:");
		txtNombreActividad = new JTextField(20);

		JLabel labelCodMonitor = new JLabel("Código del monitor:");
		txtCodigoMonitor = new JTextField(20);

		JButton altaButton = new JButton("Dar de alta");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelNomActividad);
		panel.add(txtNombreActividad);
		panel.add(labelCodMonitor);
		panel.add(txtCodigoMonitor);
		panel.add(altaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de alta
		altaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada
				String nombreActividad = txtNombreActividad.getText();
				String codigoMonitor = txtCodigoMonitor.getText();

				// Comprobar que este relleno
				if (nombreActividad.isEmpty() || codigoMonitor.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
				} else {
					// Realizar la lógica de alta de la actividad en la base de datos
					// boolean exito = altaActividad(nombreActividad, codigoMonitor);
					boolean exito = true;
					if (exito) {
						JOptionPane.showMessageDialog(null, "La actividad se dio de alta correctamente.");
					} else {
						JOptionPane.showMessageDialog(null, "Error al dar de alta la actividad.");
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}

}
