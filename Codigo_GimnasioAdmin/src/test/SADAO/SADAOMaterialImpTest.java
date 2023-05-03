package test.SADAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import integracion.factoria.FactoriaDAO;
import integracion.factoria.FactoriaDAOImp;
import integracion.material.DAOMaterial;

import negocio.material.SAMaterialImp;
import negocio.material.TransMaterial;


public class SADAOMaterialImpTest {
	private SAMaterialImp saMaterial;
	private DAOMaterial daoMaterial;
	

	@Before
	public void setUp() {
		// Conectar a la base de datos

		FactoriaDAO factoriaDAO = new FactoriaDAOImp();
		
		daoMaterial = factoriaDAO.getDAOMaterial();
		saMaterial = new SAMaterialImp();
		
	}

	@Test
	public void testAltaExitoso() {
		// Preparaci�n de datos de prueba
		TransMaterial material = new TransMaterial(1, "Material 1", 2);

		// Ejecuci�n del m�todo a probar
		int resultado = saMaterial.AltaMaterial(material);

		// Verificaci�n de resultados
		assertEquals(1, resultado);
		saMaterial.BajaMaterial(1);
	}

	@Test
	public void testAltaExistente() {
		// Preparaci�n de datos de prueba
		TransMaterial material1 = new TransMaterial(1, "Material 1", 2);

		boolean exito1 = daoMaterial.altaMaterial(material1);

		assertTrue(exito1);

		// Ejecuci�n del m�todo a probar
		try {
			saMaterial.AltaMaterial(material1);
			fail("Se esperaba una excepci�n IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Verificaci�n de resultados
			assertEquals("Ya existe un material con id 1", e.getMessage());
		}
		saMaterial.BajaMaterial(1);
	}

	

	@Test
	public void testBajaExitoso() {
		// Preparaci�n de datos de prueba
		TransMaterial material1 = new TransMaterial(1, "Material 1", 2);
		daoMaterial.altaMaterial(material1);

		// Ejecuci�n del m�todo a probar
		int resultado = saMaterial.BajaMaterial(1);

		// Verificaci�n de resultados
		assertEquals(1, resultado);
	}

	@Test
	public void testBajaExistente() {
		// Preparaci�n de datos de prueba
		TransMaterial material1 = new TransMaterial(1, "Material 1", 2);

		
		boolean exito = daoMaterial.altaMaterial(material1);
		assertTrue(exito);

		// Ejecuci�n del m�todo a probar
		int resultado = saMaterial.BajaMaterial(material1.getId());

		// Verificaci�n de resultados
		assertEquals(1, resultado);

		// Verificar que ya no existe en la base de datos
		TransMaterial borrado = daoMaterial.buscarMaterial(material1.getId());
		assertNull(borrado);
	}

	@Test
	public void testBajaNoExistente() {
		// Preparaci�n de datos de prueba
		int idNoExistente = 100;

		// Ejecuci�n del m�todo a probar y verificaci�n de resultados
		try {
			saMaterial.BajaMaterial(idNoExistente);
			fail("Se esperaba una excepci�n IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Excepci�n esperada, se considera un caso de �xito
		}
	}

	@Test
	public void testMostrar() {
		// Crear una actividad en la base de datos
		TransMaterial material1 = new TransMaterial(1, "Material 1", 2);

		daoMaterial.altaMaterial(material1);
		// Mostrar la actividad
		TransMaterial mostrado = saMaterial.MostrarMaterial(material1.getId());
		assertNotNull(mostrado);
		assertEquals(material1.getId(), mostrado.getId());
		assertEquals(material1.getNombre(), mostrado.getNombre());
		saMaterial.BajaMaterial(1);
	}

	@Test
	public void testListar() {
		// Preparaci�n de datos de prueba
		TransMaterial material1 = new TransMaterial(1, "Material 1", 2);
		TransMaterial material2 = new TransMaterial(2, "Material 2", 3);
		saMaterial.AltaMaterial(material1);
		saMaterial.AltaMaterial(material2);

		// Obtener la lista de clientes
		ArrayList<TransMaterial> lista = saMaterial.ListarMaterial();

		// Verificar que la lista no est� vac�a y contiene los clientes
		// esperados
		assertNotNull(lista);
		assertEquals(2, lista.size());

		saMaterial.BajaMaterial(1);
		saMaterial.BajaMaterial(2);
	}
}