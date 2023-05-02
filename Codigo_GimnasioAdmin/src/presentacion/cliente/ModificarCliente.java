package presentacion.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.cliente.TransCliente;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class ModificarCliente extends JFrame {
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtTelefono;

	public ModificarCliente() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Cliente");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del cliente:");
		txtId = new JTextField(20);

		JLabel labelNombre = new JLabel("Nombre del cliente:");
		txtNombre = new JTextField(20);

		JLabel labelStock = new JLabel("Telefono de cliente:");
		txtTelefono = new JTextField(20);

		JButton modificarButton = new JButton("Modificar cliente");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelStock);
		panel.add(txtTelefono);

		panel.add(modificarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de modificar
		modificarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtId.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");

				} else {

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						int i = Integer.parseInt(txtId.getText());
						int s = Integer.parseInt(txtTelefono.getText());
						String n = txtNombre.getText();

						TransCliente tCliente = new TransCliente(i, n, s);

						Controlador.obtenerInstancia().Accion(Eventos.MODIFICAR_CLIENTE, tCliente);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al modificar el cliente: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);
	}
}
