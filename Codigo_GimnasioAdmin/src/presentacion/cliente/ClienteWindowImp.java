package presentacion.cliente;

import javax.swing.*;

import negocio.cliente.TransCliente;
import negocio.monitor.TransMonitor;
import presentacion.controlador.Controlador;
import presentacion.controlador.Eventos;
import presentacion.monitor.MonitorWindowImp;
import presentacion.monitor.MostrarMonitorWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClienteWindowImp extends ClienteWindow{

	public ClienteWindowImp() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Clientes");
		setPreferredSize(new Dimension(800, 650));
		setLocation(500, 300);

		// Panel principal
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Botones de cliente
		JButton altaClienteButton = new JButton("Alta Cliente");
		JButton bajaClienteButton = new JButton("Baja Cliente");
		JButton modificarClienteButton = new JButton("Modificar Cliente");
		JButton mostrarClienteButton = new JButton("Mostrar Cliente");
		JButton listaClienteButton = new JButton("Lista de Clientes");

		// Agregar botones al panel
		panel.add(altaClienteButton);
		panel.add(bajaClienteButton);
		panel.add(modificarClienteButton);
		panel.add(mostrarClienteButton);
		panel.add(listaClienteButton);

		// Agregar panel a la ventana
		getContentPane().add(panel);

		// Configurar acciones de los botones de cliente
		altaClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaCliente altaCliente = new AltaCliente();
				altaCliente.setVisible(true);
			}
		});

		bajaClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaCliente bajaCliente = new BajaCliente();
				bajaCliente.setVisible(true);
			}
		});

		modificarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCliente modificarCliente = new ModificarCliente();
				modificarCliente.setVisible(true);
			}
		});
		mostrarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarCliente mostrarCliente = new MostrarCliente();
				mostrarCliente.setVisible(true);
			}
		});
		listaClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.obtenerInstancia().Accion(Eventos.MOSTRAR_LISTA_CLIENTE, null);
			}
		});

		pack();
	}
	
	public void Actualizar(int evento, Object data) {
		switch (evento) {
		case Eventos.ALTA_CLIENTE_BIEN: {
			TransCliente cliente = (TransCliente) data;
			int id = cliente.getId();
			JOptionPane.showMessageDialog(ClienteWindowImp.this, "Cliente: " + id + " dado de alta correctamente");
			break;
		}
		case Eventos.BAJA_CLIENTE_BIEN: {
			int id = (int) data;
			JOptionPane.showMessageDialog(ClienteWindowImp.this, "Cliente: " + id + " dado de baja correctamente");
			break;
		}
		case Eventos.MODIFICAR_CLIENTE_BIEN: {
			TransCliente cliente = (TransCliente) data;
			int id = cliente.getId();
			JOptionPane.showMessageDialog(ClienteWindowImp.this, "Cliente: " + id + " modificado correctamente");
			break;
		}
		case Eventos.MOSTRAR_CLIENTE_BIEN: {
			TransCliente cliente = (TransCliente) data;
			ArrayList<TransCliente> lista = new ArrayList<TransCliente>();
			lista.add(cliente);

			MostrarClienteWindow mostrarWindow = new MostrarClienteWindow(lista);
			mostrarWindow.setVisible(true);

			break;
		}
		case Eventos.MOSTRAR_LISTA_CLIENTE_BIEN: {

			ArrayList<TransCliente> lista = (ArrayList<TransCliente>) data;

			MostrarClienteWindow mostrarWindow = new MostrarClienteWindow(lista);
			mostrarWindow.setVisible(true);

			break;
		}

		}

	}
}
