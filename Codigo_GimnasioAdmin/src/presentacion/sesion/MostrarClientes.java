package presentacion.sesion;

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

public class MostrarClientes extends JFrame{
	private JTextField txtId;

	public MostrarClientes() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Clientes de la Sesion");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id de la Sesion:");
		txtId = new JTextField(20);

		JButton mostrarButton = new JButton("Mostrar Clientes");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(mostrarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		mostrarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id de la sesion.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtId.getText());
						Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_CLIENTES_SESION, id);
						
						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el id sea válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al mostrar la sesion: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
