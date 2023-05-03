package presentacion.entrenamiento;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.entrenamiento.TransEntrenamiento;

public class MostrarEntrenamientoWindow extends JFrame {
	private JTable tabla;
	private DefaultTableModel modeloTabla;

	public MostrarEntrenamientoWindow(ArrayList<TransEntrenamiento> l) {

		// lista = new ArrayList<TransActividad>(); no me funcionaba
		// lista = l;
		//

		setTitle("Entrenamientos");
		setSize(800, 500);
		setLocation(400, 500);
		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("IDMonitor");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Precio");

		tabla = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(tabla);

		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel);

		for (TransEntrenamiento entrenamiento : l) {
			Object[] datos = { entrenamiento.getId(), entrenamiento.getIdM(), entrenamiento.getNombre(),
					entrenamiento.getPrecio() };
			modeloTabla.addRow(datos);

		}
	}
}
