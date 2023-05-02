package presentacion.entrenamiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntrenamientoWindowImp extends EntrenamientoWindow {

	public EntrenamientoWindowImp() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Entrenamientos");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de entrenamiento
		JButton altaEntrenamientoButton = new JButton("Alta Entrenamiento");
		JButton bajaEntrenamientoButton = new JButton("Baja Entrenamiento");
		JButton modificarEntrenamientoButton = new JButton("Modificar Entrenamiento");
		JButton mostrarEntrenamientoButton = new JButton("Mostrar Entrenamiento");
		JButton listaEntrenamientoButton = new JButton("Lista de Entrenamientos");

		// Agregar botones al panel
		panel.add(altaEntrenamientoButton);
		panel.add(bajaEntrenamientoButton);
		panel.add(modificarEntrenamientoButton);
		panel.add(mostrarEntrenamientoButton);
		panel.add(listaEntrenamientoButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de entrenamiento
		altaEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para alta de entrenamiento
				JOptionPane.showMessageDialog(EntrenamientoWindowImp.this, "Funcionalidad de Alta Cliente");
			}
		});

		bajaEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de entrenamiento
				JOptionPane.showMessageDialog(EntrenamientoWindowImp.this, "Funcionalidad de Baja Cliente");
			}
		});

		modificarEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar entrenamiento
				JOptionPane.showMessageDialog(EntrenamientoWindowImp.this, "Funcionalidad de Modificar Cliente");
			}
		});
		mostrarEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar entrenamiento
				JOptionPane.showMessageDialog(EntrenamientoWindowImp.this, "Funcionalidad de Mostrar Cliente");
			}
		});
		listaEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar entrenamiento
				JOptionPane.showMessageDialog(EntrenamientoWindowImp.this, "Funcionalidad de Listar Cliente");
			}
		});

		pack();
	}
	
	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
	
}
