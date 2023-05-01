package presentacion;

import javax.swing.*;

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

		// a�adir botones
		panel.add(clienteButton);
		panel.add(monitorButton);
		panel.add(entrenamientoButton);
		panel.add(actividadButton);
		panel.add(materialButton);
		panel.add(facturaButton);
		// a�adir el panel
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
				ActividadWindow actividadWindow = new ActividadWindow();
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