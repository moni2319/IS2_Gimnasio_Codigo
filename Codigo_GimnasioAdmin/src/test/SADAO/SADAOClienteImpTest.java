package test.SADAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import java.util.ArrayList;

import integracion.cliente.DAOCliente;
import integracion.cliente.DAOClienteImp;
import integracion.factoria.FactoriaDAO;
import integracion.factoria.FactoriaDAOImp;
import negocio.cliente.SAClienteImp;
import negocio.cliente.TransCliente;

import org.junit.Before;
import org.junit.Test;

public class SADAOClienteImpTest {
	private SAClienteImp saCliente;
	private DAOCliente daoCliente;
	

	@Before
	public void setUp() {
		// Conectar a la base de datos

		FactoriaDAO factoriaDAO = new FactoriaDAOImp();
		// Inicializar el DAOCliente y SACliente
		daoCliente = factoriaDAO.getDAOCliente();
		saCliente = new SAClienteImp();
	}

	@Test
	public void testAltaExitoso() {
		// Preparación de datos de prueba
		TransCliente cliente = new TransCliente(1, "Cliente 1", 2);

		// Ejecución del método a probar
		int resultado = saCliente.AltaCliente(cliente);

		// Verificación de resultados
		assertEquals(1, resultado);
		saCliente.BajaCliente(1);
	}

	@Test
	public void testAltaExistente() {
		// Preparación de datos de prueba
		TransCliente cliente1 = new TransCliente(1, "Cliente 1", 2);

		boolean exito1 = daoCliente.altaCliente(cliente1);

		assertTrue(exito1);

		// Ejecución del método a probar
		try {
			saCliente.AltaCliente(cliente1);
			fail("Se esperaba una excepción IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Verificación de resultados
			assertEquals("Ya existe un cliente con id 1", e.getMessage());
		}
		saCliente.BajaCliente(1);
	}

	

	@Test
	public void testBajaExitoso() {
		// Preparación de datos de prueba
		TransCliente cliente1 = new TransCliente(1, "Cliente 1", 2);
		daoCliente.altaCliente(cliente1);

		// Ejecución del método a probar
		int resultado = saCliente.BajaCliente(1);

		// Verificación de resultados
		assertEquals(1, resultado);
	}

	@Test
	public void testBajaExistente() {
		// Preparación de datos de prueba
		TransCliente cliente1 = new TransCliente(1, "Cliente 1", 2);

		
		boolean exito = daoCliente.altaCliente(cliente1);
		assertTrue(exito);

		// Ejecución del método a probar
		int resultado = saCliente.BajaCliente(cliente1.getId());

		// Verificación de resultados
		assertEquals(1, resultado);

		// Verificar que la actividad ya no existe en la base de datos
		TransCliente clienteBorrada = daoCliente.buscarCliente(cliente1.getId());
		assertNull(clienteBorrada);
	}

	@Test
	public void testBajaNoExistente() {
		// Preparación de datos de prueba
		int idNoExistente = 100;

		// Ejecución del método a probar y verificación de resultados
		try {
			saCliente.BajaCliente(idNoExistente);
			fail("Se esperaba una excepción IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Excepción esperada, se considera un caso de éxito
		}
	}

	@Test
	public void testMostrar() {
		// Crear una actividad en la base de datos
		TransCliente cliente1 = new TransCliente(1, "Cliente 1", 2);

		daoCliente.altaCliente(cliente1);
		// Mostrar la actividad
		TransCliente clienteMostrado = saCliente.MostrarCliente(cliente1.getId());
		assertNotNull(clienteMostrado);
		assertEquals(cliente1.getId(), clienteMostrado.getId());
		assertEquals(cliente1.getNombre(), clienteMostrado.getNombre());
		saCliente.BajaCliente(1);
	}

	@Test
	public void testListar() {
		// Preparación de datos de prueba
		TransCliente cliente1 = new TransCliente(1, "Cliente 1", 123456789);
		TransCliente cliente2 = new TransCliente(2, "Cliente 2", 987654321);
		saCliente.AltaCliente(cliente1);
		saCliente.AltaCliente(cliente2);

		// Obtener la lista de clientes
		ArrayList<TransCliente> clientes = saCliente.ListarCliente();

		// Verificar que la lista no está vacía y contiene los clientes
		// esperados
		assertNotNull(clientes);
		assertEquals(2, clientes.size());

		saCliente.BajaCliente(1);
		saCliente.BajaCliente(2);
	}
}
