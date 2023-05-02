package presentacion.monitor;

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

public class ModificarMonitor extends JFrame {
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtSalario;

	public ModificarMonitor() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Monitor");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del monitor:");
		txtId = new JTextField(20);

		JLabel labelNombre = new JLabel("Nombre del monitor:");
		txtNombre = new JTextField(20);

		JLabel labelStock = new JLabel("Cantidad de monitor:");
		txtSalario = new JTextField(20);

		JButton modificarButton = new JButton("Modificar monitor");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelStock);
		panel.add(txtSalario);

		panel.add(modificarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de modificar
		modificarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtNombre.getText().isEmpty() || txtSalario.getText().isEmpty() || txtId.getText().isEmpty()
						|| Integer.parseInt(txtSalario.getText()) <= 0) {
					if (Integer.parseInt(txtSalario.getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "Por favor, el salario debe ser > 0.");
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
					}
				} else {

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						int i = Integer.parseInt(txtId.getText());
						int s = Integer.parseInt(txtSalario.getText());
						String n = txtNombre.getText();

						TransMonitor tMonitor = new TransMonitor(i, n, s);

						Controlador.obtenerInstancia().Accion(Eventos.MODIFICAR_MONITOR, tMonitor);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al modificar el monitor: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
