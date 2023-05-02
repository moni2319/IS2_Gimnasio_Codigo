package presentacion.factura;

import javax.swing.*;

import negocio.factura.TransFactura;
import presentacion.actividad.ActividadWindowImp;
import presentacion.controlador.Eventos;

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
		JButton cerrarFacturaButton = new JButton("Cerrar Factura");
		JButton modificarFacturaButton = new JButton("Modificar Factura");
		JButton mostrarFacturaButton = new JButton("Mostrar Factura");
		JButton mostrarFacturaClienteButton = new JButton("Mostrar Facturas de Cliente");
		JButton listaFacturaButton = new JButton("Lista de Facturas");

		// Agregar botones al panel
		panel.add(abrirFacturaButton);
		panel.add(cerrarFacturaButton);
		panel.add(modificarFacturaButton);
		panel.add(mostrarFacturaButton);
		panel.add(mostrarFacturaClienteButton);
		panel.add(listaFacturaButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de factura
		abrirFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para alta de factura
				AbrirFactura abrirFactura = new AbrirFactura();
				abrirFactura.setVisible(true);
			}
		});

		cerrarFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de factura
				CerrarFactura cerrarFactura = new CerrarFactura();
				cerrarFactura.setVisible(true);
			}
		});

		modificarFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarFactura modificarFactura = new ModificarFactura();
				modificarFactura.setVisible(true);
			}
		});
		mostrarFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindowImp.this, "Funcionalidad de Mostrar Cliente");
			}
		});
		mostrarFacturaClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindowImp.this, "Funcionalidad de Mostrar Cliente");
			}
		});
		listaFacturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar factura
				JOptionPane.showMessageDialog(FacturaWindowImp.this, "Funcionalidad de Listar Cliente");
			}
		});

		pack();
	}

	public void Actualizar(int evento, Object data) {
		switch (evento) {
		case Eventos.ABRIR_FACTURA_BIEN: {
			TransFactura tFactura = (TransFactura) data;
			int cod = tFactura.getCod();
			JOptionPane.showMessageDialog(FacturaWindowImp.this, "Factura " + cod + " abierta correctamente");

			break;
		}
		case Eventos.CERRAR_FACTURA_BIEN: {

			int cod = (int) data;
			JOptionPane.showMessageDialog(FacturaWindowImp.this, "Factura " + cod + " cerrada correctamente");

			break;
		}
		case Eventos.MODIFICAR_FACTURA_BIEN: {
			TransFactura tFactura = (TransFactura) data;
			int cod = tFactura.getCod();
			JOptionPane.showMessageDialog(FacturaWindowImp.this, "Factura " + cod + " modificada correctamente");

			break;
		}

		}
	}
}
