package presentacion.controlador;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import negocio.actividad.SAActividad;
import negocio.actividad.TransActividad;
import negocio.cliente.SACliente;
import negocio.cliente.TransCliente;
import negocio.entrenamiento.SAEntrenamiento;
import negocio.entrenamiento.TransEntrenamiento;
import negocio.factorias.FactoriaSA;
import negocio.factorias.FactoriaSAImp;
import negocio.factura.SAFactura;
import negocio.factura.TransFactura;
import negocio.material.SAMaterial;
import negocio.material.TransMaterial;
import negocio.monitor.SAMonitor;
import negocio.monitor.TransMonitor;
import presentacion.actividad.ActividadWindow;
import presentacion.cliente.ClienteWindow;
import presentacion.entrenamiento.EntrenamientoWindow;
import presentacion.factura.FacturaWindow;
import presentacion.material.MaterialWindow;
import presentacion.monitor.MonitorWindow;

public class ControladorImp extends Controlador {
	FactoriaSA factoria;

	public ControladorImp() {

		factoria = new FactoriaSAImp();
	}

	public void Accion(int event, Object info) {
		switch (event) {
		// ACTIVIDAD
		case Eventos.ALTA_ACTIVIDAD: {
			TransActividad tActividad = (TransActividad) info;
			SAActividad actividad = factoria.getInstanciaSAActividad();
			try {
				int resultado = actividad.AltaActividad(tActividad);
				if (resultado > 0) {
					ActividadWindow.obtenerInstancia().Actualizar(Eventos.ALTA_ACTIVIDAD_BIEN, tActividad);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.BAJA_ACTIVIDAD: {
			int id = (int) info;
			SAActividad actividad = factoria.getInstanciaSAActividad();
			try {
				int resultado = actividad.BajaActividad(id);
				if (resultado > 0) {
					ActividadWindow.obtenerInstancia().Actualizar(Eventos.BAJA_ACTIVIDAD_BIEN, id);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MODIFICAR_ACTIVIDAD: {
			TransActividad tActividad = (TransActividad) info;
			SAActividad actividad = factoria.getInstanciaSAActividad();
			try {
				int resultado = actividad.ModificarActividad(tActividad);
				if (resultado > 0) {
					ActividadWindow.obtenerInstancia().Actualizar(Eventos.MODIFICAR_ACTIVIDAD_BIEN, tActividad);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.MOSTRAR_ACTIVIDAD: {
			int id = (int) info;
			SAActividad actividad = factoria.getInstanciaSAActividad();
			try {

				TransActividad tActividad = actividad.MostrarActividad(id);
				if (tActividad != null) {
					ActividadWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_ACTIVIDAD_BIEN, tActividad);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}
		case Eventos.MOSTRAR_LISTA_ACTIVIDAD: {

			SAActividad actividad = factoria.getInstanciaSAActividad();
			try {

				ArrayList<TransActividad> lista = actividad.ListarActividad();
				if (lista != null) {
					ActividadWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_LISTA_ACTIVIDAD_BIEN, lista);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}
		// FACTURA
		case Eventos.ABRIR_FACTURA: {
			TransFactura tFactura = (TransFactura) info;
			SAFactura factura = factoria.getInstanciaSAFactura();
			try {
				int resultado = factura.AbrirFactura(tFactura);
				if (resultado > 0) {
					FacturaWindow.obtenerInstancia().Actualizar(Eventos.ABRIR_FACTURA_BIEN, tFactura);
				}
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.CERRAR_FACTURA: {
			int cod = (int) info;
			SAFactura factura = factoria.getInstanciaSAFactura();
			try {
				int resultado = factura.CerrarFactura(cod);
				if (resultado > 0) {
					FacturaWindow.obtenerInstancia().Actualizar(Eventos.CERRAR_FACTURA_BIEN, cod);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MODIFICAR_FACTURA: {
			TransFactura tFactura = (TransFactura) info;
			SAFactura factura = factoria.getInstanciaSAFactura();
			try {
				int resultado = factura.ModificarFactura(tFactura);
				if (resultado > 0) {
					FacturaWindow.obtenerInstancia().Actualizar(Eventos.MODIFICAR_FACTURA_BIEN, tFactura);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.MOSTRAR_FACTURA: {
			int cod = (int) info;
			SAFactura factura = factoria.getInstanciaSAFactura();
			try {
				TransFactura tFactura = factura.MostrarFactura(cod);
				if (tFactura != null) {
					FacturaWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_FACTURA_BIEN, tFactura);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MOSTRAR_FACTURA_CLIENTE: {
			int idC = (int) info;
			SAFactura factura = factoria.getInstanciaSAFactura();
			try {
				ArrayList<TransFactura> lista = factura.MostrarFacturasCliente(idC);
				if (lista != null) {
					FacturaWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_FACTURA_CLIENTE_BIEN, lista);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MOSTRAR_LISTA_FACTURA: {

			SAFactura factura = factoria.getInstanciaSAFactura();
			try {

				ArrayList<TransFactura> lista = factura.ListarFactura();
				if (lista != null) {
					FacturaWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_LISTA_FACTURA_BIEN, lista);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}

		// MATERIAL

		case Eventos.ALTA_MATERIAL: {
			TransMaterial tMaterial = (TransMaterial) info;
			SAMaterial material = factoria.getInstanciaSAMaterial();
			try {
				int resultado = material.AltaMaterial(tMaterial);
				if (resultado > 0) {
					MaterialWindow.obtenerInstancia().Actualizar(Eventos.ALTA_MATERIAL_BIEN, tMaterial);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.BAJA_MATERIAL: {
			int id = (int) info;
			SAMaterial material = factoria.getInstanciaSAMaterial();
			try {
				int resultado = material.BajaMaterial(id);
				if (resultado > 0) {
					MaterialWindow.obtenerInstancia().Actualizar(Eventos.BAJA_MATERIAL_BIEN, id);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MODIFICAR_MATERIAL: {
			TransMaterial tMaterial = (TransMaterial) info;
			SAMaterial material = factoria.getInstanciaSAMaterial();
			try {
				int resultado = material.ModificarMaterial(tMaterial);
				if (resultado > 0) {
					MaterialWindow.obtenerInstancia().Actualizar(Eventos.MODIFICAR_MATERIAL_BIEN, tMaterial);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.MOSTRAR_MATERIAL: {
			int id = (int) info;
			SAMaterial material = factoria.getInstanciaSAMaterial();
			try {

				TransMaterial tMaterial = material.MostrarMaterial(id);
				if (tMaterial != null) {
					MaterialWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_MATERIAL_BIEN, tMaterial);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}
		case Eventos.MOSTRAR_LISTA_MATERIAL: {

			SAMaterial material = factoria.getInstanciaSAMaterial();
			try {

				ArrayList<TransMaterial> lista = material.ListarMaterial();
				if (lista != null) {
					MaterialWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_LISTA_MATERIAL_BIEN, lista);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}

		// MONITOR

		case Eventos.ALTA_MONITOR: {
			TransMonitor tMonitor = (TransMonitor) info;
			SAMonitor monitor = factoria.getInstanciaSAMonitor();
			try {
				int resultado = monitor.AltaMonitor(tMonitor);
				if (resultado > 0) {
					MonitorWindow.obtenerInstancia().Actualizar(Eventos.ALTA_MONITOR_BIEN, tMonitor);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.BAJA_MONITOR: {
			int id = (int) info;
			SAMonitor monitor = factoria.getInstanciaSAMonitor();
			try {
				int resultado = monitor.BajaMonitor(id);
				if (resultado > 0) {
					MonitorWindow.obtenerInstancia().Actualizar(Eventos.BAJA_MONITOR_BIEN, id);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MODIFICAR_MONITOR: {
			TransMonitor tMonitor = (TransMonitor) info;
			SAMonitor monitor = factoria.getInstanciaSAMonitor();
			try {
				int resultado = monitor.ModificarMonitor(tMonitor);
				if (resultado > 0) {
					MonitorWindow.obtenerInstancia().Actualizar(Eventos.MODIFICAR_MONITOR_BIEN, tMonitor);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.MOSTRAR_MONITOR: {
			int id = (int) info;
			SAMonitor monitor = factoria.getInstanciaSAMonitor();
			try {

				TransMonitor tMonitor = monitor.MostrarMonitor(id);
				if (tMonitor != null) {
					MonitorWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_MONITOR_BIEN, tMonitor);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}
		case Eventos.MOSTRAR_LISTA_MONITOR: {

			SAMonitor monitor = factoria.getInstanciaSAMonitor();
			try {

				ArrayList<TransMonitor> lista = monitor.ListarMonitor();
				if (lista != null) {
					MonitorWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_LISTA_MONITOR_BIEN, lista);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}

		// CLIENTE

		case Eventos.ALTA_CLIENTE: {
			TransCliente tCliente = (TransCliente) info;
			SACliente cliente = factoria.getInstanciaSACliente();
			try {
				int resultado = cliente.AltaCliente(tCliente);
				if (resultado > 0) {
					ClienteWindow.obtenerInstancia().Actualizar(Eventos.ALTA_CLIENTE_BIEN, tCliente);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.BAJA_CLIENTE: {
			int id = (int) info;
			SACliente cliente = factoria.getInstanciaSACliente();
			try {
				int resultado = cliente.BajaCliente(id);
				if (resultado > 0) {
					ClienteWindow.obtenerInstancia().Actualizar(Eventos.BAJA_CLIENTE_BIEN, id);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MODIFICAR_CLIENTE: {
			TransCliente tCliente = (TransCliente) info;
			SACliente cliente = factoria.getInstanciaSACliente();
			try {
				int resultado = cliente.ModificarCliente(tCliente);
				if (resultado > 0) {
					ClienteWindow.obtenerInstancia().Actualizar(Eventos.MODIFICAR_CLIENTE_BIEN, tCliente);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.MOSTRAR_CLIENTE: {
			int id = (int) info;
			SACliente cliente = factoria.getInstanciaSACliente();
			try {

				TransCliente tCliente = cliente.MostrarCliente(id);
				if (tCliente != null) {
					ClienteWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_CLIENTE_BIEN, tCliente);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}
		case Eventos.MOSTRAR_LISTA_CLIENTE: {

			SACliente cliente = factoria.getInstanciaSACliente();
			try {

				ArrayList<TransCliente> lista = cliente.ListarCliente();
				if (lista != null) {
					ClienteWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_LISTA_CLIENTE_BIEN, lista);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}

		// ENTRENAMIENTO

		case Eventos.ALTA_ENTRENAMIENTO: {
			TransEntrenamiento tEntrenamiento = (TransEntrenamiento) info;
			SAEntrenamiento entrenamiento = factoria.getInstanciaSAEntrenamiento();
			try {
				int resultado = entrenamiento.AltaEntrenamiento(tEntrenamiento);
				if (resultado > 0) {
					EntrenamientoWindow.obtenerInstancia().Actualizar(Eventos.ALTA_ENTRENAMIENTO_BIEN, tEntrenamiento);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.BAJA_ENTRENAMIENTO: {
			int id = (int) info;
			SAEntrenamiento entrenamiento = factoria.getInstanciaSAEntrenamiento();
			try {
				int resultado = entrenamiento.BajaEntrenamiento(id);
				if (resultado > 0) {
					EntrenamientoWindow.obtenerInstancia().Actualizar(Eventos.BAJA_ENTRENAMIENTO_BIEN, id);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
		case Eventos.MODIFICAR_ENTRENAMIENTO: {
			TransEntrenamiento tEntrenamiento = (TransEntrenamiento) info;
			SAEntrenamiento entrenamiento = factoria.getInstanciaSAEntrenamiento();
			try {
				int resultado = entrenamiento.ModificarEntrenamiento(tEntrenamiento);
				if (resultado > 0) {
					EntrenamientoWindow.obtenerInstancia().Actualizar(Eventos.MODIFICAR_ENTRENAMIENTO_BIEN,
							tEntrenamiento);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
		case Eventos.MOSTRAR_ENTRENAMIENTO: {
			int id = (int) info;
			SAEntrenamiento entrenamiento = factoria.getInstanciaSAEntrenamiento();
			try {

				TransEntrenamiento tEntrenamiento = entrenamiento.MostrarEntrenamiento(id);
				if (tEntrenamiento != null) {
					EntrenamientoWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_ENTRENAMIENTO_BIEN,
							tEntrenamiento);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}
		case Eventos.MOSTRAR_LISTA_ENTRENAMIENTO: {

			SAEntrenamiento entrenamiento = factoria.getInstanciaSAEntrenamiento();
			try {

				ArrayList<TransEntrenamiento> lista = entrenamiento.ListarEntrenamiento();
				if (lista != null) {
					EntrenamientoWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_LISTA_ENTRENAMIENTO_BIEN, lista);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}

		}

	}

}
