package presentacion.monitor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.material.TransMaterial;
import negocio.monitor.TransMonitor;
import presentacion.controlador.Eventos;
import presentacion.material.MaterialWindowImp;
import presentacion.material.MostrarMaterialWindow;

public class MonitorWindowImp extends MonitorWindow {
	public MonitorWindowImp() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Monitores");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);
		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de monitor
		JButton altaMonitorButton = new JButton("Alta Monitor");
		JButton bajaMonitorButton = new JButton("Baja Monitor");
		JButton modificarMonitorButton = new JButton("Modificar Monitor");
		JButton mostrarMonitorButton = new JButton("Mostrar Monitor");
		JButton listaMonitorButton = new JButton("Lista de Monitores");

		// Agregar botones al panel
		panel.add(altaMonitorButton);
		panel.add(bajaMonitorButton);
		panel.add(modificarMonitorButton);
		panel.add(mostrarMonitorButton);
		panel.add(listaMonitorButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de monitor
		altaMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para alta de monitor
				JOptionPane.showMessageDialog(MonitorWindowImp.this, "Funcionalidad de Alta Monitor");
			}
		});

		bajaMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de monitor
				JOptionPane.showMessageDialog(MonitorWindowImp.this, "Funcionalidad de Baja Monitor");
			}
		});

		modificarMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar monitor
				JOptionPane.showMessageDialog(MonitorWindowImp.this, "Funcionalidad de Modificar Monitor");
			}
		});
		mostrarMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar monitor
				JOptionPane.showMessageDialog(MonitorWindowImp.this, "Funcionalidad de Mostrar Monitor");
			}
		});
		listaMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar monitor
				JOptionPane.showMessageDialog(MonitorWindowImp.this, "Funcionalidad de Listar Monitor");
			}
		});

		pack();
	}
	public void Actualizar(int evento, Object data) {
		switch (evento) {
		case Eventos.ALTA_MONITOR_BIEN: {
			TransMonitor monitor = (TransMonitor) data;
			int id = monitor.getId();
			JOptionPane.showMessageDialog(MonitorWindowImp.this, "Monitor: " + id + " dado de alta correctamente");
			break;
		}
		case Eventos.BAJA_MONITOR_BIEN: {
			int id = (int) data;
			JOptionPane.showMessageDialog(MonitorWindowImp.this, "Monitor: " + id + " dado de baja correctamente");
			break;
		}
		case Eventos.MODIFICAR_MONITOR_BIEN: {
			TransMonitor monitor = (TransMonitor) data;
			int id = monitor.getId();
			JOptionPane.showMessageDialog(MonitorWindowImp.this, "Monitor: " + id + " modificado correctamente");
			break;
		}
		case Eventos.MOSTRAR_MONITOR_BIEN: {
			TransMonitor monitor = (TransMonitor) data;
			ArrayList<TransMonitor> lista = new ArrayList<TransMonitor>();
			lista.add(monitor);

//			MostrarMonitorWindow mostrarWindow = new MostrarMonitorWindow(lista);
//			mostrarWindow.setVisible(true);

			break;
		}
		case Eventos.MOSTRAR_LISTA_MONITOR_BIEN: {

			ArrayList<TransMonitor> lista = (ArrayList<TransMonitor>) data;

//			MostrarMonitorWindow mostrarWindow = new MostrarMonitorWindow(lista);
//			mostrarWindow.setVisible(true);

			break;
		}

		}

	}

}
