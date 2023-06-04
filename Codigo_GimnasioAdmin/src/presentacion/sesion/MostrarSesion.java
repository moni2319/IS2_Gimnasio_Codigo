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
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;

public class MostrarSesion extends JFrame {
	private JTextField txtId;
	private DAOActividad daoActividad;
	private DAOEntrenamiento daoEntrenamiento;
	public MostrarSesion() {
		daoActividad = new FactoriaDAOImp().getDAOActividad();
		daoEntrenamiento = new FactoriaDAOImp().getDAOEntrenamiento();
		initComponents();
	}

	private void initComponents() {
		setTitle("Mostrar Sesion");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id de la sesion:");
		txtId = new JTextField(20);

		JButton mostrarButton = new JButton("Mostrar");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtId);
		panel.add(mostrarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de baja
		mostrarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Obtener los datos de entrada

				// Comprobar que este relleno
				if (txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el id de la sesion.");
				} else {

					setVisible(false);
					// hacer try y catch de numeros
					try {
						int id = Integer.parseInt(txtId.getText());
						if (daoActividad.buscar(id)!= null) {
							Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_ACTIVIDAD, id);
						}
						else if (daoEntrenamiento.buscarEntrenamiento(id)!= null){
							Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_ENTRENAMIENTO, id);
						}
						setVisible(false);
					} catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(null,
								"Error al ingresar los datos. Asegúrate de que el id sea válido.");
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error al mostrar el entrenamiento: " + error.getMessage());
					}
					setVisible(false);
				}
			}
		});
		setVisible(true);

	}
}
