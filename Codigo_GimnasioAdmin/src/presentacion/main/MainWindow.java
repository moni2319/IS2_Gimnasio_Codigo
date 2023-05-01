package presentacion.main;

import javax.swing.*;

import presentacion.actividad.ActividadWindowImp;
import presentacion.cliente.ClientWindow;
import presentacion.entrenamiento.EntrenamientoWindow;
import presentacion.factura.FacturaWindow;
import presentacion.material.MaterialWindow;
import presentacion.monitor.MonitorWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

	public MainWindow() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gimnasio");

		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// panel
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// botones principales
		JButton clienteButton = new JButton("Clientes");
		JButton monitorButton = new JButton("Monitores");
		JButton entrenamientoButton = new JButton("Entrenamientos");
		JButton actividadButton = new JButton("Actividades");
		JButton materialButton = new JButton("Materiales");
		JButton facturaButton = new JButton("Facturas");

		// añadir botones
		panel.add(clienteButton);
		panel.add(monitorButton);
		panel.add(entrenamientoButton);
		panel.add(actividadButton);
		panel.add(materialButton);
		panel.add(facturaButton);
		// añadir el panel
		getContentPane().add(panel);

		// Acciones de los botones
		clienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de clientes
				ClientWindow clientWindow = new ClientWindow();
				clientWindow.setVisible(true);
			}
		});

		monitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de monitores
				MonitorWindow monitorWindow = new MonitorWindow();
				monitorWindow.setVisible(true);
			}
		});

		entrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de entrenamiento
				EntrenamientoWindow entrenamientoWindow = new EntrenamientoWindow();
				entrenamientoWindow.setVisible(true);

			}
		});

		actividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de actividades
				ActividadWindowImp actividadWindow = new ActividadWindowImp();
				actividadWindow.setVisible(true);
			}
		});

		materialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de materiales
				MaterialWindow materialWindow = new MaterialWindow();
				materialWindow.setVisible(true);

			}
		});
		facturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de facturas
				FacturaWindow facturaWindow = new FacturaWindow();
				facturaWindow.setVisible(true);

			}
		});

		pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow mainWindow = new MainWindow();
				mainWindow.setVisible(true);
			}
		});
	}
}