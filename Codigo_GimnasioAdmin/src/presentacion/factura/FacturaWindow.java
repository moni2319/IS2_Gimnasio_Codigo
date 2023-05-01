package presentacion.factura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturaWindow extends JFrame {

	public FacturaWindow() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Facturas");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);
		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de factura
		JButton altaFacturaButton = new JButton("Alta Factura");
		JButton bajaFacturaButton = new JButton("Baja Factura");
		JButton modificarFacturaButton = new JButton("Modificar Factura");
		JButton mostrarFacturaButton = new JButton("Mostrar Factura");
		JButton listaFacturaButton = new JButton("Lista de Facturas");

		// Agregar botones al panel
		panel.add(altaFacturaButton);
		panel.add(bajaFacturaButton);
		panel.add(modificarFacturaButton);
		panel.add(mostrarFacturaButton);
		panel.add(listaFacturaButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de factura
		altaFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para alta de factura
				JOptionPane.showMessageDialog(FacturaWindow.this, "Funcionalidad de Alta Cliente");
			}
		});

		bajaFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para baja de factura
				JOptionPane.showMessageDialog(FacturaWindow.this, "Funcionalidad de Baja Cliente");
			}
		});

		modificarFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindow.this, "Funcionalidad de Modificar Cliente");
			}
		});
		mostrarFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindow.this, "Funcionalidad de Mostrar Cliente");
			}
		});
		listaFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindow.this, "Funcionalidad de Listar Cliente");
			}
		});

		pack();
	}
}
