package presentacion.material;

import javax.swing.*;

import negocio.actividad.TransActividad;
import negocio.material.TransMaterial;
import presentacion.actividad.ActividadWindowImp;
import presentacion.actividad.MostrarActividadWindow;
import presentacion.controlador.Eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MaterialWindowImp extends MaterialWindow {

	public MaterialWindowImp() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Materiales");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de material
		JButton altaMaterialButton = new JButton("Alta Material");
		JButton bajaMaterialButton = new JButton("Baja Material");
		JButton modificarMaterialButton = new JButton("Modificar Material");
		JButton mostrarMaterialButton = new JButton("Mostrar Material");
		JButton listaMaterialButton = new JButton("Lista de Materiales");

		// Agregar botones al panel
		panel.add(altaMaterialButton);
		panel.add(bajaMaterialButton);
		panel.add(modificarMaterialButton);
		panel.add(mostrarMaterialButton);
		panel.add(listaMaterialButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de material
		altaMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaMaterial altaMaterial = new AltaMaterial();
				altaMaterial.setVisible(true);
			}
		});

		bajaMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaMaterial bajaMaterial = new BajaMaterial();
				bajaMaterial.setVisible(true);
			}
		});

		modificarMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar material
				JOptionPane.showMessageDialog(MaterialWindowImp.this, "Funcionalidad de Modificar Cliente");
			}
		});
		mostrarMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar material
				JOptionPane.showMessageDialog(MaterialWindowImp.this, "Funcionalidad de Mostrar Cliente");
			}
		});
		listaMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para modificar material
				JOptionPane.showMessageDialog(MaterialWindowImp.this, "Funcionalidad de Listar Cliente");
			}
		});

		pack();
	}
	public void Actualizar(int evento, Object data) {
		switch (evento) {
		case Eventos.ALTA_MATERIAL_BIEN: {
			TransMaterial material = (TransMaterial) data;
			int id = material.getId();
			JOptionPane.showMessageDialog(MaterialWindowImp.this, "Material: " + id + " dado de alta correctamente");
			break;
		}
		case Eventos.BAJA_MATERIAL_BIEN: {
			int id = (int) data;
			JOptionPane.showMessageDialog(MaterialWindowImp.this, "Material: " + id + " dado de baja correctamente");
			break;
		}
		case Eventos.MODIFICAR_MATERIAL_BIEN: {
			TransMaterial material = (TransMaterial) data;
			int id = material.getId();
			JOptionPane.showMessageDialog(MaterialWindowImp.this, "Material: " + id + " modificado correctamente");
			break;
		}
		case Eventos.MOSTRAR_MATERIAL_BIEN: {
			TransMaterial material = (TransMaterial) data;
			ArrayList<TransMaterial> lista = new ArrayList<TransMaterial>();
			lista.add(material);
		
			//MostrarMaterialWindow mostrarWindow = new MostrarMaterialWindow(lista);
			//mostrarWindow.setVisible(true);

			break;
		}
		case Eventos.MOSTRAR_LISTA_MATERIAL_BIEN: {
			
			ArrayList<TransMaterial> lista = (ArrayList<TransMaterial>) data;
			
			//MostrarMaterialWindow mostrarWindow = new MostrarMaterialWindow(lista);
		//	mostrarWindow.setVisible(true);

			break;
		}

		}

	}
	
}
