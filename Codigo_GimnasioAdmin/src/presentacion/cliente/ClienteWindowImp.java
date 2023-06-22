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

public class ClienteWindowImp extends ClienteWindow {

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
		JButton apuntarClienteButton = new JButton("Apuntar Cliente a Sesion");
		JButton quitarClienteButton = new JButton("Quitar Cliente de Sesion");
		JButton bajaClienteButton = new JButton("Baja Cliente");
		JButton modificarClienteButton = new JButton("Modificar Cliente");
		JButton mostrarClienteButton = new JButton("Mostrar Cliente");
		JButton listaClienteButton = new JButton("Lista de Clientes");
		JButton sesionesClienteButton = new JButton("Sesiones del Cliente");

		// Agregar botones al panel
		panel.add(altaClienteButton);
		panel.add(bajaClienteButton);
		panel.add(apuntarClienteButton);
		panel.add(quitarClienteButton);
		panel.add(modificarClienteButton);
		panel.add(mostrarClienteButton);
		panel.add(sesionesClienteButton);
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

		apuntarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApuntarCliente apuntarCliente = new ApuntarCliente();
				apuntarCliente.setVisible(true);
			}
		});
		quitarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuitarCliente quitarCliente = new QuitarCliente();
				quitarCliente.setVisible(true);
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

		sesionesClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarSesiones mostrarSesiones = new MostrarSesiones();
				mostrarSesiones.setVisible(true);
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
		case Eventos.APUNTAR_CLIENTE_BIEN: {
			Object[] cliente = (Object[]) data;
			int id = (int) cliente[1];
			JOptionPane.showMessageDialog(ClienteWindowImp.this, "Cliente: " + id + " apuntado correctamente");
			break;
		}
		case Eventos.BAJA_CLIENTE_BIEN: {
			int id = (int) data;
			JOptionPane.showMessageDialog(ClienteWindowImp.this, "Cliente: " + id + " dado de baja correctamente");
			break;
		}
		case Eventos.QUITAR_CLIENTE_BIEN: {
			Object[] object = (Object[]) data;
			JOptionPane.showMessageDialog(ClienteWindowImp.this, "Cliente: " + object[0] + " se ha quitado correctamente de la sesion");
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
		case Eventos.MOSTRAR_SESIONES_CLIENTE_BIEN: {
		

			ArrayList<Object[]> lista = (ArrayList<Object[]>) data;

			MostrarSesionesWindow sesionesWindow = new MostrarSesionesWindow(lista);
			sesionesWindow.setVisible(true);

			break;
		}

		}

	}
}
