package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaterialWindow extends JFrame {

	public MaterialWindow() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Clientes");

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de material
		JButton altaMaterialButton = new JButton("Alta Material");
		JButton bajaMaterialButton = new JButton("Baja Material");
		JButton modificarMaterialButton = new JButton("Modificar Material");
		JButton mostrarMaterialButton = new JButton("Mostrar Material");
		JButton listaMaterialButton = new JButton("Lista de Materiales");

		// Agregar botones al panel
		panel.add(altaMaterialButton);
		panel.add(bajaMaterialButton);
		panel.add(modificarMaterialButton);
		panel.add(mostrarMaterialButton);
		panel.add(listaMaterialButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de material
		altaMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para alta de material
				JOptionPane.showMessageDialog(MaterialWindow.this, "Funcionalidad de Alta Cliente");
			}
		});

		bajaMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de material
				JOptionPane.showMessageDialog(MaterialWindow.this, "Funcionalidad de Baja Cliente");
			}
		});

		modificarMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar material
				JOptionPane.showMessageDialog(MaterialWindow.this, "Funcionalidad de Modificar Cliente");
			}
		});
		mostrarMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar material
				JOptionPane.showMessageDialog(MaterialWindow.this, "Funcionalidad de Mostrar Cliente");
			}
		});
		listaMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar material
				JOptionPane.showMessageDialog(MaterialWindow.this, "Funcionalidad de Listar Cliente");
			}
		});

		pack();
	}
}
