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

public class CerrarFactura extends JFrame {
	private JTextField txtCodFactura;

	public CerrarFactura() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Cerrar Factura");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Codigo de la factura:");
		txtCodFactura = new JTextField(20);

		JButton cerrarButton = new JButton("Cerrar Factura");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtCodFactura);
		panel.add(cerrarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Bot�n de abrirFactura
		cerrarButton.addActionListener(new ActionListener() {

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

						Controlador.obtenerInstancia().Accion(Eventos.CERRAR_FACTURA, cod);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Aseg�rate de que el codigo sea un n�mero v�lido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al cerrar la factura: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
