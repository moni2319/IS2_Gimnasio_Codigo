package presentacion.controlador;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import negocio.actividad.SAActividad;
import negocio.actividad.TransActividad;
import negocio.factorias.FactoriaSA;
import negocio.factorias.FactoriaSAImp;
import negocio.factura.SAFactura;
import negocio.factura.TransFactura;
import presentacion.actividad.ActividadWindow;
import presentacion.factura.FacturaWindow;

public class ControladorImp extends Controlador {
	FactoriaSA factoria;

	public ControladorImp() {

		// negocios en negocio
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
				if (lista!= null) {
					FacturaWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_FACTURA_CLIENTE_BIEN,lista);
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
					FacturaWindow.obtenerInstancia().Actualizar(Eventos.MOSTRAR_LISTA_FACTURA_BIEN,lista);
				}

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			break;
		}
		}
		
	}

}
