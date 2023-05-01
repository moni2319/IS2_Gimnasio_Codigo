package presentacion.actividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import negocio.actividad.TransActividad;
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
		setSize(300, 200);
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

				String nombreActividad = txtNombreActividad.getText();
				String codigoMonitor = txtCodigoMonitor.getText();

				// Comprobar que este relleno
				if (nombreActividad.isEmpty() || codigoMonitor.isEmpty() || txtIdActividad.getText().isEmpty()
						|| txtPrecioActividad.getText().isEmpty() || txtAforoActividad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
				} else {
					// Realizar la lógica de alta de la actividad en la base de
					// datos
					// boolean exito = altaActividad(nombreActividad,
					// codigoMonitor);
					boolean exito = true;
					setVisible(false);
					// hacer try y catch de numeros y strings
					int id = Integer.parseInt(txtIdActividad.getText());
					int idM = Integer.parseInt(txtCodigoMonitor.getText());
					int a = Integer.parseInt(txtAforoActividad.getText());
					int p = Integer.parseInt(txtPrecioActividad.getText());

					TransActividad tActividad = new TransActividad(id, idM, p, a, nombreActividad);
					Controlador.obtenerInstancia().Accion(Eventos.ALTA_ACTIVIDAD, tActividad);

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
