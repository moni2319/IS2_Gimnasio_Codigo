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

public class MostrarFactura extends JFrame {
	private JTextField txtCodFactura;

	public MostrarFactura() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Mostrar Factura");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Codigo de la factura:");
		txtCodFactura = new JTextField(20);

		JButton mostrarButton = new JButton("Mostrar Factura");

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
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el codigo de la factura.");
				} else {
					setVisible(false);
					// hacer try y catch de numeros
					try {
						int cod = Integer.parseInt(txtCodFactura.getText());

						Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_FACTURA, cod);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el codigo sea un número válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al mostrar la factura: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
