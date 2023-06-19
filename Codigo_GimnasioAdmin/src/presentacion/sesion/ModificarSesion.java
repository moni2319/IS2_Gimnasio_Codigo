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
import negocio.actividad.TransActividad;
import negocio.sesion.SASesion;
import presentacion.actividad.AltaActividad;
import presentacion.actividad.ModificarActividad;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.entrenamiento.AltaEntrenamiento;
import presentacion.entrenamiento.ModificarEntrenamiento;

public class ModificarSesion extends JFrame {
	private JTextField txtIdSesion;
	private DAOActividad daoActividad;
	private DAOEntrenamiento daoEntrenamiento;

	public ModificarSesion() {
		daoActividad = new FactoriaDAOImp().getDAOActividad();
		daoEntrenamiento = new FactoriaDAOImp().getDAOEntrenamiento();
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Sesion");
		setSize(300, 200);
		setLocationRelativeTo(null);

		JLabel labelId = new JLabel("Id de la Sesion:");
		txtIdSesion = new JTextField(20);

		JButton modificarButton = new JButton("Modificar actividad");

		// Crear el panel y agregar los componentes
		JPanel panel = new JPanel();
		panel.add(labelId);
		panel.add(txtIdSesion);
		panel.add(modificarButton);

		// Agregar panel a la ventana
		setContentPane(panel);

		// Botón de modificar
		modificarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtIdSesion.getText());
				if (daoActividad.buscar(id) != null) {
					ModificarActividad modificarActividad = new ModificarActividad(id);
					modificarActividad.setVisible(true);
				} else if (daoEntrenamiento.buscarEntrenamiento(id) != null) {
					ModificarEntrenamiento modificarEntrenamiento = new ModificarEntrenamiento(id);
					modificarEntrenamiento.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "No hay sesiones con ese id.");
				}
				setVisible(false);

			}
		});
		setVisible(true);

	}
}
