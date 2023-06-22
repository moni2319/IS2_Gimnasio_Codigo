package presentacion.cliente;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MostrarSesionesWindow extends JFrame{
	private JTable tabla;
	private DefaultTableModel modeloTabla;

	public MostrarSesionesWindow(ArrayList<Object[]> l) {
		setTitle("Sesiones de cliente");
		setSize(800, 500);
		setLocation(400, 500);
		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("IDSesion");
		modeloTabla.addColumn("Nivel");
		

		tabla = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(tabla);

		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel);

		for ( Object[] sesiones: l) {
			modeloTabla.addRow(sesiones);

		}
	}
	
}
