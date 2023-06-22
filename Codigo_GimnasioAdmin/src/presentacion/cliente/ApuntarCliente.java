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

public class ApuntarCliente extends JFrame{
	private JTextField txtCliente;
	private JTextField txtSesion;
	private JTextField txtNivel;
	public ApuntarCliente() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Apuntar Cliente");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelCliente = new JLabel("ID del cliente:");
		txtCliente = new JTextField(20);

		JLabel labelSesion = new JLabel("ID de la Sesion");
		txtSesion = new JTextField(20);
		
		JLabel labelNivel = new JLabel("Nivel");
		txtSesion = new JTextField(20);

		JButton apuntarButton = new JButton("Apuntar");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();

		panel.add(labelCliente);
		panel.add(txtCliente);
		panel.add(labelNivel);
		panel.add(txtSesion);
		panel.add(apuntarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de alta
		apuntarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtCliente.getText().isEmpty() || txtSesion.getText().isEmpty() || txtNivel.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");

				} else {

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {

						int s = Integer.parseInt(txtSesion.getText());
						int c = Integer.parseInt(txtCliente.getText());
						String n = txtNivel.getText();

						Object[] parametros = {s, c, n};
						

						Controlador.obtenerInstancia().Accion(Eventos.APUNTAR_CLIENTE, parametros);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
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
