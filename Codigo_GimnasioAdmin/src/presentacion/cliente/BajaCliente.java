package presentacion.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class BajaCliente extends JFrame {
	private JTextField txtId;

	public BajaCliente() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Baja Cliente");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del cliente:");
		txtId = new JTextField(20);

		JButton bajaButton = new JButton("Dar de baja");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(bajaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de baja
		bajaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id a dar de baja.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtId.getText());
						Controlador.obtenerInstancia().Accion(Eventos.BAJA_CLIENTE, id);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el id sean válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al dar de baja el cliente: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
