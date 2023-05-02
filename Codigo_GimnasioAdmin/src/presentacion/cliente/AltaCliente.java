package presentacion.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.monitor.TransMonitor;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class AltaCliente extends JFrame {
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtTelefono;

	public AltaCliente() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Alta Cliente");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del cliente:");
		txtId = new JTextField(20);

		JLabel labelNombre = new JLabel("Nombre del cliente:");
		txtNombre = new JTextField(20);

		JLabel labelSalario = new JLabel("Telefono del cliente:");
		txtTelefono = new JTextField(20);

		JButton altaButton = new JButton("Dar de alta");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelSalario);
		panel.add(txtTelefono);
		panel.add(altaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de alta
		altaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty()
						|| txtId.getText().isEmpty() || Integer.parseInt(txtTelefono.getText()) <= 0) {
					if (Integer.parseInt(txtTelefono.getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "Por favor, el salario debe ser > 0.");
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
					}

				} else {
					
					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						int i = Integer.parseInt(txtId.getText());
						int s = Integer.parseInt(txtTelefono.getText());
						String n = txtNombre.getText();

						TransMonitor tMonitor = new TransMonitor(i, n, s);

						Controlador.obtenerInstancia().Accion(Eventos.ALTA_MONITOR, tMonitor);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al dar de alta el monitor: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}

}
