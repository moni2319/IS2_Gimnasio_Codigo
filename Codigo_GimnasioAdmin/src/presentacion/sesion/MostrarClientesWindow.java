package presentacion.sesion;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarClientesWindow extends JFrame{
	private JTable tabla;
	private DefaultTableModel modeloTabla;

	public MostrarClientesWindow(ArrayList<Object[]> l) {
		setTitle("Clientes de sesion");
		setSize(800, 500);
		setLocation(400, 500);
		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("IDCliente");
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
