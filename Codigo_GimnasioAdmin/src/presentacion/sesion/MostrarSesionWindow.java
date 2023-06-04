package presentacion.sesion;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.actividad.TransActividad;
import negocio.sesion.TransSesion;

public class MostrarSesionWindow extends JFrame{
	private JTable tablaActividades;
	private DefaultTableModel modeloTabla;


	public MostrarSesionWindow(ArrayList<TransSesion> l) {

		setTitle("Actividades");
		setSize(800, 500);
		setLocation(400, 500);
		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("IDMonitor");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Precio");
		

		tablaActividades = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(tablaActividades);

		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel);

		for (TransSesion sesion : l) {
			Object[] datosSesion = { sesion.getId(), sesion.getIdM(), sesion.getNombre(),
					sesion.getPrecio() };
			modeloTabla.addRow(datosSesion);

		}
	}
}
