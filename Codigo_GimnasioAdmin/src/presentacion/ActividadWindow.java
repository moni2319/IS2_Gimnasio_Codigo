package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ActividadWindow extends JFrame{
	public ActividadWindow() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Clientes");

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de actividad
		JButton altaActividadButton = new JButton("Alta Actividad");
		JButton bajaActividadButton = new JButton("Baja Actividad");
		JButton modificarActividadButton = new JButton("Modificar Actividad");
		JButton mostrarActividadButton = new JButton("Mostrar Actividad");
		JButton listaActividadButton = new JButton("Lista de Actividades");

		// Agregar botones al panel
		panel.add(altaActividadButton);
		panel.add(bajaActividadButton);
		panel.add(modificarActividadButton);
		panel.add(mostrarActividadButton);
		panel.add(listaActividadButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de actividad
		altaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para alta de actividad
				JOptionPane.showMessageDialog(ActividadWindow.this, "Funcionalidad de Alta Actividad");
			}
		});

		bajaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de actividad
				JOptionPane.showMessageDialog(ActividadWindow.this, "Funcionalidad de Baja Actividad");
			}
		});

		modificarActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				JOptionPane.showMessageDialog(ActividadWindow.this, "Funcionalidad de Modificar Actividad");
			}
		});
		mostrarActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				JOptionPane.showMessageDialog(ActividadWindow.this, "Funcionalidad de Mostrar Actividad");
			}
		});
		listaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				JOptionPane.showMessageDialog(ActividadWindow.this, "Funcionalidad de Listar Actividad");
			}
		});

		pack();
	}
}
