package presentacion.material;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.material.TransMaterial;

public class MostrarMaterialWindow extends JFrame {
	private JTable tablaMateriales;
	private DefaultTableModel modeloTabla;
	private ArrayList<TransMaterial> lista;

	public MostrarMaterialWindow(ArrayList<TransMaterial> l) {
		setTitle("Materiales");
		setSize(800, 500);
		setLocation(400, 500);
		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Stock");

		tablaMateriales = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(tablaMateriales);

		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel);

		for (TransMaterial material : l) {
			Object[] datosMaterial = { material.getId(), material.getNombre(), material.getStock() };
			modeloTabla.addRow(datosMaterial);

		}
	}

}
