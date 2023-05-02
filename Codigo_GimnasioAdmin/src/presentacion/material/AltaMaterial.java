package presentacion.material;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.material.TransMaterial;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class AltaMaterial extends JFrame {
	private JTextField txtIdMaterial;
	private JTextField txtNombreMaterial;
	private JTextField txtStockMaterial;

	public AltaMaterial() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Alta Material");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del material:");
		txtIdMaterial = new JTextField(20);

		JLabel labelNombre = new JLabel("Nombre del material:");
		txtNombreMaterial = new JTextField(20);

		JLabel labelStock = new JLabel("Cantidad de material:");
		txtStockMaterial = new JTextField(20);

		JButton altaButton = new JButton("Dar de alta");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtIdMaterial);
		panel.add(labelNombre);
		panel.add(txtNombreMaterial);
		panel.add(labelStock);
		panel.add(txtStockMaterial);
		panel.add(altaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de alta
		altaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtNombreMaterial.getText().isEmpty() || txtStockMaterial.getText().isEmpty()
						|| txtIdMaterial.getText().isEmpty() || Integer.parseInt(txtStockMaterial.getText()) <= 0) {
					if (Integer.parseInt(txtStockMaterial.getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "Por favor, la cantidad debe ser > 0.");
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
					}

				} else {
					// Realizar la lógica de alta de la actividad en la base de
					// datos

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						int i = Integer.parseInt(txtIdMaterial.getText());
						int s = Integer.parseInt(txtStockMaterial.getText());
						String n = txtNombreMaterial.getText();

						TransMaterial tMaterial = new TransMaterial(i, n, s);

						Controlador.obtenerInstancia().Accion(Eventos.ALTA_MATERIAL, tMaterial);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al dar de alta el material: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
