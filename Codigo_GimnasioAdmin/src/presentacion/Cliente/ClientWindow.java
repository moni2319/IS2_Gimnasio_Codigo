package presentacion.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame {

	public ClientWindow() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Clientes");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de cliente
		JButton altaClienteButton = new JButton("Alta Cliente");
		JButton bajaClienteButton = new JButton("Baja Cliente");
		JButton modificarClienteButton = new JButton("Modificar Cliente");
		JButton mostrarClienteButton = new JButton("Mostrar Cliente");
		JButton listaClienteButton = new JButton("Lista de Clientes");

		// Agregar botones al panel
		panel.add(altaClienteButton);
		panel.add(bajaClienteButton);
		panel.add(modificarClienteButton);
		panel.add(mostrarClienteButton);
		panel.add(listaClienteButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de cliente
		altaClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para alta de cliente
				JOptionPane.showMessageDialog(ClientWindow.this, "Funcionalidad de Alta Cliente");
			}
		});

		bajaClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de cliente
				JOptionPane.showMessageDialog(ClientWindow.this, "Funcionalidad de Baja Cliente");
			}
		});

		modificarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar cliente
				JOptionPane.showMessageDialog(ClientWindow.this, "Funcionalidad de Modificar Cliente");
			}
		});
		mostrarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar cliente
				JOptionPane.showMessageDialog(ClientWindow.this, "Funcionalidad de Mostrar Cliente");
			}
		});
		listaClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar cliente
				JOptionPane.showMessageDialog(ClientWindow.this, "Funcionalidad de Listar Cliente");
			}
		});

		pack();
	}
}
