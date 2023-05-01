
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

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones principales
		JButton clienteButton = new JButton("Clientes");
		JButton monitorButton = new JButton("Monitores");
		JButton entrenamientoButton = new JButton("Entrenamientos");
		JButton actividadButton = new JButton("Actividades");
		JButton materialButton = new JButton("Materiales");
		JButton facturaButton = new JButton("Facturas");

		// Agregar botones principales al panel
		panel.add(clienteButton);
		panel.add(monitorButton);
		panel.add(entrenamientoButton);
		panel.add(actividadButton);
		panel.add(materialButton);
		panel.add(facturaButton);

		getContentPane().add(panel);

		// Configurar acciones de los botones principales
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
				// MonitorWindow monitorWindow = new MonitorWindow();
				// monitorWindow.setVisible(true);
			}
		});

		entrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		actividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana de actividades
				// ActivityWindow activityWindow = new ActivityWindow();
				// activityWindow.setVisible(true);
			}
		});

		materialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		facturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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