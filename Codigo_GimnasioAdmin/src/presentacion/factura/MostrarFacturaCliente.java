package presentacion.factura;

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

public class MostrarFacturaCliente extends JFrame {
	private JTextField txtCodFactura;

	public MostrarFacturaCliente() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Mostrar Factura Cliente");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del Cliente:");
		txtCodFactura = new JTextField(20);

		JButton mostrarButton = new JButton("Mostrar Facturas");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtCodFactura);
		panel.add(mostrarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de abrirFactura
		mostrarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtCodFactura.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id del Cliente.");
				} else {
					setVisible(false);
					// hacer try y catch de numeros
					try {
						int cod = Integer.parseInt(txtCodFactura.getText());

						Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_FACTURA_CLIENTE, cod);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el codigo sea un número válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al mostrar las facturas: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
