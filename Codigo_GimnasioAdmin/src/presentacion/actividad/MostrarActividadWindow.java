package presentacion.actividad;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.actividad.TransActividad;

public class MostrarActividadWindow extends JFrame {
	private JTable tablaActividades;
	private DefaultTableModel modeloTabla;
	private ArrayList<TransActividad> lista;

	public MostrarActividadWindow(ArrayList<TransActividad> l) {
		initComponents();
		lista = l;
	}

	public void initComponents() {
		setTitle("Actividades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);

		// Crear el modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("IDMonitor");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Precio");
		modeloTabla.addColumn("Aforo");

		// Crear la tabla y establecer el modelo
		tablaActividades = new JTable(modeloTabla);

		// Agregar la tabla a un panel con barra de desplazamiento
		JScrollPane scrollPane = new JScrollPane(tablaActividades);

		// Agregar el panel al marco
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel);

		for (TransActividad actividad : lista) {
            Object[] datosActividad = { actividad.getId(),actividad.getIdM(), actividad.getNombre(), actividad.getPrecio(), actividad.getAforo() };
            modeloTabla.addRow(datosActividad);
        }

	}

}
