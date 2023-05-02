package presentacion.factura;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.factura.TransFactura;

public class MostrarFacturaWindow extends JFrame {

	private JTable tablaFacturas;
	private DefaultTableModel modeloTabla;
	ArrayList<TransFactura> lista;

	public MostrarFacturaWindow(ArrayList<TransFactura> l) {
		setTitle("Facturas");
		setSize(800, 500);
		setLocation(400, 500);
		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Cod");
		modeloTabla.addColumn("IDCliente");
		modeloTabla.addColumn("Importe");

		tablaFacturas = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(tablaFacturas);

		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel);

		for (TransFactura factura : l) {
			Object[] datosFactura = { factura.getCod(), factura.getIdCliente(), factura.getImporte() };
			modeloTabla.addRow(datosFactura);

		}
	}
}
