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

public class AltaCliente extends JFrame {

	private JTextField txtNombre;
	private JTextField txtTelefono;

	public AltaCliente() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Alta Cliente");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelNombre = new JLabel("Nombre del cliente:");
		txtNombre = new JTextField(20);

		JLabel labelSalario = new JLabel("Telefono del cliente:");
		txtTelefono = new JTextField(20);

		JButton altaButton = new JButton("Dar de alta");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();

		panel.add(labelNombre);
		panel.add(txtNombre);
		panel.add(labelSalario);
		panel.add(txtTelefono);
		panel.add(altaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Bot�n de alta
		altaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");

				} else {

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {

						int s = Integer.parseInt(txtTelefono.getText());
						String n = txtNombre.getText();

						TransCliente tCliente = new TransCliente(n, s);

						Controlador.obtenerInstancia().Accion(Eventos.ALTA_CLIENTE, tCliente);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Aseg�rate de que todos los campos num�ricos sean v�lidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al dar de alta el cliente: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}

}
