package presentacion.sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import integracion.actividad.DAOActividad;
import integracion.entrenamiento.DAOEntrenamiento;
import integracion.factoria.FactoriaDAOImp;
import negocio.sesion.SASesion;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class BajaSesion extends JFrame {
	private JTextField txtIdSesion;
	private DAOActividad daoActividad;
	private DAOEntrenamiento daoEntrenamiento;

	public BajaSesion() {
		daoActividad = new FactoriaDAOImp().getDAOActividad();
		daoEntrenamiento = new FactoriaDAOImp().getDAOEntrenamiento();
		initComponents();
	}

	private void initComponents() {
		setTitle("Baja Sesion");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id de la sesion:");
		txtIdSesion = new JTextField(20);

		JButton bajaButton = new JButton("Dar de baja");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtIdSesion);
		panel.add(bajaButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de baja
		bajaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtIdSesion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id a dar de baja.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtIdSesion.getText());
						if (daoActividad.buscar(id)!= null) {
							Controlador.obtenerInstancia().Accion(Eventos.BAJA_ACTIVIDAD, id);
						}
						else{
							Controlador.obtenerInstancia().Accion(Eventos.BAJA_ENTRENAMIENTO, id);
						}

						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el id sean válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al dar de baja la Sesion: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
