package presentacion.cliente;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.cliente.TransCliente;

public class MostrarClienteWindow extends JFrame {
	private JTable tabla;
	private DefaultTableModel modeloTabla;

	public MostrarClienteWindow(ArrayList<TransCliente> l) {
		setTitle("Clientes");
		setSize(800, 500);
		setLocation(400, 500);
		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Salario");

		tabla = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(tabla);

		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel);

		for (TransCliente cliente : l) {
			Object[] datos = { cliente.getId(), cliente.getNombre(), cliente.getTelefono() };
			modeloTabla.addRow(datos);

		}
	}
}
