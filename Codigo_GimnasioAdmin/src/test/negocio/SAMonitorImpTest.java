package test.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import integracion.cliente.DAOCliente;
import integracion.factoria.FactoriaDAO;
import integracion.factoria.FactoriaDAOImp;
import integracion.monitor.DAOMonitor;
import negocio.cliente.SAClienteImp;
import negocio.cliente.TransCliente;
import negocio.monitor.SAMonitorImp;
import negocio.monitor.TransMonitor;

public class SAMonitorImpTest {
	private SAMonitorImp saMonitor;
	private DAOMonitor daoMonitor;
	

	@Before
	public void setUp() {
		// Conectar a la base de datos

		FactoriaDAO factoriaDAO = new FactoriaDAOImp();
		
		daoMonitor = factoriaDAO.getDAOMonitor();
		saMonitor = new SAMonitorImp();
		
	}

	@Test
	public void testAltaExitoso() {
		// Preparación de datos de prueba
		TransMonitor monitor = new TransMonitor(1, "Monitor 1", 2);

		// Ejecución del método a probar
		int resultado = saMonitor.AltaMonitor(monitor);

		// Verificación de resultados
		assertEquals(1, resultado);
		saMonitor.BajaMonitor(1);
	}

	@Test
	public void testAltaExistente() {
		// Preparación de datos de prueba
		TransMonitor monitor1 = new TransMonitor(1, "Monitor 1", 2);

		boolean exito1 = daoMonitor.altaMonitor(monitor1);

		assertTrue(exito1);

		// Ejecución del método a probar
		try {
			saMonitor.AltaMonitor(monitor1);
			fail("Se esperaba una excepción IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Verificación de resultados
			assertEquals("Ya existe un monitor con id 1", e.getMessage());
		}
		saMonitor.BajaMonitor(1);
	}

	

	@Test
	public void testBajaExitoso() {
		// Preparación de datos de prueba
		TransMonitor monitor1 = new TransMonitor(1, "Monitor 1", 2);
		daoMonitor.altaMonitor(monitor1);

		// Ejecución del método a probar
		int resultado = saMonitor.BajaMonitor(1);

		// Verificación de resultados
		assertEquals(1, resultado);
	}

	@Test
	public void testBajaExistente() {
		// Preparación de datos de prueba
		TransMonitor monitor1 = new TransMonitor(1, "Monitor 1", 2);

		
		boolean exito = daoMonitor.altaMonitor(monitor1);
		assertTrue(exito);

		// Ejecución del método a probar
		int resultado = saMonitor.BajaMonitor(monitor1.getId());

		// Verificación de resultados
		assertEquals(1, resultado);

		// Verificar que ya no existe en la base de datos
		TransMonitor borrado = daoMonitor.buscarMonitor(monitor1.getId());
		assertNull(borrado);
	}

	@Test
	public void testBajaNoExistente() {
		// Preparación de datos de prueba
		int idNoExistente = 100;

		// Ejecución del método a probar y verificación de resultados
		try {
			saMonitor.BajaMonitor(idNoExistente);
			fail("Se esperaba una excepción IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Excepción esperada, se considera un caso de éxito
		}
	}

	@Test
	public void testMostrar() {
		// Crear una actividad en la base de datos
		TransMonitor monitor1 = new TransMonitor(1, "Monitor 1", 2);

		daoMonitor.altaMonitor(monitor1);
		// Mostrar la actividad
		TransMonitor mostrado = saMonitor.MostrarMonitor(monitor1.getId());
		assertNotNull(mostrado);
		assertEquals(monitor1.getId(), mostrado.getId());
		assertEquals(monitor1.getNombre(), mostrado.getNombre());
		saMonitor.BajaMonitor(1);
	}

	@Test
	public void testListar() {
		// Preparación de datos de prueba
		TransMonitor monitor1 = new TransMonitor(1, "Monitor 1", 2);
		TransMonitor monitor2 = new TransMonitor(2, "Monitor 2", 3);
		saMonitor.AltaMonitor(monitor1);
		saMonitor.AltaMonitor(monitor2);

		// Obtener la lista de clientes
		ArrayList<TransMonitor> lista = saMonitor.ListarMonitor();

		// Verificar que la lista no está vacía y contiene los clientes
		// esperados
		assertNotNull(lista);
		assertEquals(2, lista.size());

		saMonitor.BajaMonitor(1);
		saMonitor.BajaMonitor(2);
	}
}
