package presentacion.main;

import javax.swing.*;

import presentacion.actividad.ActividadWindowImp;
import presentacion.cliente.ClienteWindowImp;
import presentacion.entrenamiento.EntrenamientoWindowImp;
import presentacion.factura.FacturaWindowImp;
import presentacion.material.MaterialWindowImp;
import presentacion.monitor.MonitorWindowImp;
import presentacion.sesion.SesionWindowImp;

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
		JButton sesionButton = new JButton("Sesiones");
		JButton materialButton = new JButton("Materiales");
		JButton facturaButton = new JButton("Facturas");

		// añadir botones
		panel.add(clienteButton);
		panel.add(monitorButton);
		panel.add(sesionButton);
		panel.add(materialButton);
		panel.add(facturaButton);
		// añadir el panel
		getContentPane().add(panel);

		// Acciones de los botones
		clienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de clientes
				ClienteWindowImp clientWindow = new ClienteWindowImp();
				clientWindow.setVisible(true);
			}
		});

		monitorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de monitores
				MonitorWindowImp monitorWindow = new MonitorWindowImp();
				monitorWindow.setVisible(true);
			}
		});

		sesionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de entrenamiento
				SesionWindowImp sesionWindow = new SesionWindowImp();
				sesionWindow.setVisible(true);

			}
		});

		

		materialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de materiales
				MaterialWindowImp materialWindow = new MaterialWindowImp();
				materialWindow.setVisible(true);

			}
		});
		facturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de facturas
				FacturaWindowImp facturaWindow = new FacturaWindowImp();
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