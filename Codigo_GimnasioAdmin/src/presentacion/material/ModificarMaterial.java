package presentacion.material;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.actividad.TransActividad;
import negocio.material.TransMaterial;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class ModificarMaterial extends JFrame {
	private JTextField txtIdMaterial;
	private JTextField txtNombreMaterial;
	private JTextField txtStockMaterial;

	public ModificarMaterial() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Material");
		setSize(300, 400);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id del material:");
		txtIdMaterial = new JTextField(20);

		JLabel labelNombre = new JLabel("Nombre del material:");
		txtNombreMaterial = new JTextField(20);

		JLabel labelStock = new JLabel("Cantidad de material:");
		txtStockMaterial = new JTextField(20);

		JButton modificarButton = new JButton("Modificar material");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtIdMaterial);
		panel.add(labelNombre);
		panel.add(txtNombreMaterial);
		panel.add(labelStock);
		panel.add(txtStockMaterial);

		panel.add(modificarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de modificar
		modificarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtNombreMaterial.getText().isEmpty() || txtStockMaterial.getText().isEmpty()
						|| txtIdMaterial.getText().isEmpty() || Integer.parseInt(txtStockMaterial.getText()) <= 0) {
					if (Integer.parseInt(txtStockMaterial.getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "Por favor, la cantidad debe ser > 0.");
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos.");
					}
				} else {
					// Realizar la lógica de modificar de la actividad en la
					// BBDD

					setVisible(false);
					// hacer try y catch de numeros y strings
					try {
						int i = Integer.parseInt(txtIdMaterial.getText());
						int s = Integer.parseInt(txtStockMaterial.getText());
						String n = txtNombreMaterial.getText();

						TransMaterial tMaterial = new TransMaterial(i, n, s);

						Controlador.obtenerInstancia().Accion(Eventos.MODIFICAR_MATERIAL, tMaterial);

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que todos los campos numéricos sean válidos.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al modificar el material: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
