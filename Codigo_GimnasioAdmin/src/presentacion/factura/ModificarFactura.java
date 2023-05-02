package presentacion.factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.factura.TransFactura;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class ModificarFactura extends JFrame {
	private JTextField txtCodFactura;
	private JTextField txtIdCliente;
	private JTextField txtImporteFactura;

	public ModificarFactura() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Factura");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Codigo de la factura:");
		txtCodFactura = new JTextField(20);

		JLabel labelCodMonitor = new JLabel("Id del Cliente:");
		txtIdCliente = new JTextField(20);

		JLabel labelPrecio = new JLabel("Importe de la factura:");
		txtImporteFactura = new JTextField(20);

		JButton modificarButton = new JButton("Modificar Factura");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtCodFactura);
		panel.add(labelCodMonitor);
		panel.add(txtIdCliente);
		panel.add(labelPrecio);
		panel.add(txtImporteFactura);
		panel.add(modificarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de abrirFactura
		modificarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtIdCliente.getText().isEmpty() || txtCodFactura.getText().isEmpty()
						|| txtImporteFactura.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
				} else {
					setVisible(false);
					// hacer try y catch de numeros
					try {
						int cod = Integer.parseInt(txtCodFactura.getText());
						int idC = Integer.parseInt(txtIdCliente.getText());
						int imp = Integer.parseInt(txtImporteFactura.getText());

						TransFactura tFactura = new TransFactura(cod, idC, imp);

						Controlador.obtenerInstancia().Accion(Eventos.MODIFICAR_FACTURA, tFactura);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al modificar la factura: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
