package presentacion.monitor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MonitorWindow extends JFrame {
	public MonitorWindow() {
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
				JOptionPane.showMessageDialog(MonitorWindow.this, "Funcionalidad de Alta Monitor");
			}
		});

		bajaMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de monitor
				JOptionPane.showMessageDialog(MonitorWindow.this, "Funcionalidad de Baja Monitor");
			}
		});

		modificarMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar monitor
				JOptionPane.showMessageDialog(MonitorWindow.this, "Funcionalidad de Modificar Monitor");
			}
		});
		mostrarMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar monitor
				JOptionPane.showMessageDialog(MonitorWindow.this, "Funcionalidad de Mostrar Monitor");
			}
		});
		listaMonitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar monitor
				JOptionPane.showMessageDialog(MonitorWindow.this, "Funcionalidad de Listar Monitor");
			}
		});

		pack();
	}

}
