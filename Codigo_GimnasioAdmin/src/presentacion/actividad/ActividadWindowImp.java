package presentacion.actividad;

import javax.swing.*;

import negocio.actividad.SAActividad;
import negocio.actividad.TransActividad;
import presentacion.controlador.Eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActividadWindowImp extends ActividadWindow {

	public ActividadWindowImp() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Actividades");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de actividad
		JButton altaActividadButton = new JButton("Alta Actividad");
		JButton bajaActividadButton = new JButton("Baja Actividad");
		JButton modificarActividadButton = new JButton("Modificar Actividad");
		JButton mostrarActividadButton = new JButton("Mostrar Actividad");
		JButton listaActividadButton = new JButton("Lista de Actividades");

		// Agregar botones al panel
		panel.add(altaActividadButton);
		panel.add(bajaActividadButton);
		panel.add(modificarActividadButton);
		panel.add(mostrarActividadButton);
		panel.add(listaActividadButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de actividad
		altaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para alta de actividad
				AltaActividad altaActividad = new AltaActividad();
				altaActividad.setVisible(true);

			}
		});

		bajaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para baja de actividad
				JOptionPane.showMessageDialog(ActividadWindowImp.this, "Funcionalidad de Baja Actividad");
			}
		});

		modificarActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				JOptionPane.showMessageDialog(ActividadWindowImp.this, "Funcionalidad de Modificar Actividad");
			}
		});
		mostrarActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				JOptionPane.showMessageDialog(ActividadWindowImp.this, "Funcionalidad de Mostrar Actividad");
			}
		});
		listaActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar actividad
				JOptionPane.showMessageDialog(ActividadWindowImp.this, "Funcionalidad de Listar Actividad");
			}
		});

		pack();
	}

	public void Actualizar(int evento, Object data) {
		// CREAR GUIERROR
		switch (evento) {
		case Eventos.RES_ALTA_ACTIVIDAD_OK: {
			// POP UP SE ha creado correctamente
			JOptionPane.showMessageDialog(ActividadWindowImp.this, "Se ha creado correctamente");
			break;
		}
		case Eventos.RES_ALTA_ACTIVIDAD_KO: {
			// POP UP SE ha dado error
			JOptionPane.showMessageDialog(ActividadWindowImp.this, "Error al dar de alta la actividad: " );
			break;
		}
		}
	}
}
