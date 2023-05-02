package presentacion.factura;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturaWindowImp extends FacturaWindow {

	public FacturaWindowImp() {
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
		JButton abrirFacturaButton = new JButton("Abrir Factura");
		JButton bajaFacturaButton = new JButton("Cerrar Factura");
		JButton modificarFacturaButton = new JButton("Modificar Factura");
		JButton mostrarFacturaButton = new JButton("Mostrar Factura");
		//MOSTRAR FACTURA CLIENTE
		JButton listaFacturaButton = new JButton("Lista de Facturas");

		// Agregar botones al panel
		panel.add(abrirFacturaButton);
		panel.add(bajaFacturaButton);
		panel.add(modificarFacturaButton);
		panel.add(mostrarFacturaButton);
		panel.add(listaFacturaButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de factura
		abrirFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para alta de factura
				AbrirFactura abrirFactura = new AbrirFactura();
				abrirFactura.setVisible(true);
			}
		});

		bajaFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para baja de factura
				JOptionPane.showMessageDialog(FacturaWindowImp.this, "Funcionalidad de Baja Cliente");
			}
		});

		modificarFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindowImp.this, "Funcionalidad de Modificar Cliente");
			}
		});
		mostrarFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindowImp.this, "Funcionalidad de Mostrar Cliente");
			}
		});
		listaFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// L�gica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindowImp.this, "Funcionalidad de Listar Cliente");
			}
		});

		pack();
	}
	public void Actualizar(int evento, Object data) {
		// TODO Auto-generated method stub

	}
}
