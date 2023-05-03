package presentacion.monitor;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.monitor.TransMonitor;

public class MostrarMonitorWindow extends JFrame {
	private JTable tabla;
	private DefaultTableModel modeloTabla;

	public MostrarMonitorWindow(ArrayList<TransMonitor> l) {
		setTitle("Monitores");
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

		for (TransMonitor monitor : l) {
			Object[] datos = { monitor.getId(), monitor.getNombre(), monitor.getSalario() };
			modeloTabla.addRow(datos);

		}
	}

}
