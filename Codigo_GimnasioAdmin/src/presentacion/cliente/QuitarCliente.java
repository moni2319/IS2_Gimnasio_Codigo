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

public class QuitarCliente extends JFrame{
	private JTextField txtIdC;
	private JTextField txtIdS;

	public QuitarCliente() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Quitar Cliente de Sesion");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelIdC = new JLabel("Id del cliente:");
		txtIdC = new JTextField(20);
		JLabel labelIdS = new JLabel("Id de la sesion:");
		txtIdS = new JTextField(20);

		JButton bajaButton = new JButton("Quitar de Sesion");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelIdC);
		panel.add(txtIdC);
		panel.add(labelIdS);
		panel.add(txtIdS);
		panel.add(bajaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de baja
		bajaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtIdC.getText().isEmpty()|| txtIdS.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el los Ids.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int idC = Integer.parseInt(txtIdC.getText());
						int idS = Integer.parseInt(txtIdS.getText());
						Object[] object = {idC , idS};
						Controlador.obtenerInstancia().Accion(Eventos.QUITAR_CLIENTE, object);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que los ids sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al quitar el cliente: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
