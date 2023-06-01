package presentacion.actividad;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.sesion.SASesion;

public class MostrarActividadWindow extends JFrame {
	private JTable tablaActividades;
	private DefaultTableModel modeloTabla;
	private ArrayList<SASesion> lista;

	public MostrarActividadWindow(ArrayList<SASesion> l) {

		// lista = new ArrayList<TransActividad>(); no me funcionaba
		// lista = l;
		//

		setTitle("Actividades");
		setSize(800, 500);
		setLocation(400, 500);
		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("IDMonitor");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Precio");
		modeloTabla.addColumn("Aforo");

		tablaActividades = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(tablaActividades);

		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel);

		for (SASesion actividad : l) {
			Object[] datosActividad = { actividad.getId(), actividad.getIdM(), actividad.getNombre(),
					actividad.getPrecio(), actividad.getAforo() };
			modeloTabla.addRow(datosActividad);

		}
	}

}
