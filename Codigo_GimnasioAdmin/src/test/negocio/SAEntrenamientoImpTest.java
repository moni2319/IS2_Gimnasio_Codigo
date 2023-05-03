package test.negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import integracion.entrenamiento.DAOEntrenamiento;
import integracion.factoria.FactoriaDAO;
import integracion.factoria.FactoriaDAOImp;
import integracion.monitor.DAOMonitor;

import negocio.entrenamiento.SAEntrenamiento;
import negocio.entrenamiento.SAEntrenamientoImp;
import negocio.entrenamiento.TransEntrenamiento;

public class SAEntrenamientoImpTest {
	private SAEntrenamiento saEntrenamiento;
	private DAOEntrenamiento daoEntrenamiento;
	private DAOMonitor daoMonitor;
	@Before
	public void setUp() {
		FactoriaDAO factoriaDAO = new FactoriaDAOImp();
        daoEntrenamiento = factoriaDAO.getDAOEntrenamiento();
        daoMonitor = factoriaDAO.getDAOMonitor();
        saEntrenamiento = new SAEntrenamientoImp();
	}

	@Test
	public void testAltaActividadExitoso() {
		// Preparaci�n de datos de prueba
		TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 1, 100, "Entrenamiento 1");

		// Ejecuci�n del m�todo a probar
		int resultado = saEntrenamiento.AltaEntrenamiento(entrenamiento);

		// Verificaci�n de resultados
		assertEquals(1, resultado);
		saEntrenamiento.BajaEntrenamiento(1);
	}

	@Test
	public void testAltaActividadExistente() {
		 // Preparaci�n de datos de prueba
	    TransEntrenamiento entrenamiento1 = new TransEntrenamiento(1, 1, 100,  "Entrenamiento 1");
	   

	   
	    boolean exito1 = daoEntrenamiento.altaEntrenamiento(entrenamiento1);
	   
	    assertTrue(exito1);
	    

	    // Ejecuci�n del m�todo a probar
	    try {
	        saEntrenamiento.AltaEntrenamiento(entrenamiento1);
	        fail("Se esperaba una excepci�n IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
			// Verificaci�n de resultados
			assertEquals("Ya existe un entrenamiento con id 1", e.getMessage());
		}
	    saEntrenamiento.BajaEntrenamiento(1);
	}
	
	@Test
    public void testAltaActividadMonitorInexistente() {
        // Preparaci�n de datos de prueba
        TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 10, 100, "Entrenamiento 1");

        // Ejecuci�n del m�todo a probar
        try {
            saEntrenamiento.AltaEntrenamiento(entrenamiento);
            fail("Se esperaba una excepci�n IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Verificaci�n de resultados
            assertEquals("No existe un monitor con id 10", e.getMessage());
        }
        
    }

	@Test
    public void testBajaActividadExitoso() {
        // Preparaci�n de datos de prueba
        TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 1, 100, "Entrenamiento 1");
        daoEntrenamiento.altaEntrenamiento(entrenamiento); 

        // Ejecuci�n del m�todo a probar
        int resultado = saEntrenamiento.BajaEntrenamiento(1);

        // Verificaci�n de resultados
        assertEquals(1, resultado);
    }
	
	@Test
	public void testBajaActividadExistente() {
	    // Preparaci�n de datos de prueba
	    TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 1, 100, "Entrenamiento 1");
	    
	    // Insertar la actividad en la base de datos antes de realizar el test
	    boolean exito = daoEntrenamiento.altaEntrenamiento(entrenamiento);
	    assertTrue(exito);

	    // Ejecuci�n del m�todo a probar
	    int resultado = saEntrenamiento.BajaEntrenamiento(entrenamiento.getId());

	    // Verificaci�n de resultados
	    assertEquals(1, resultado);

	    // Verificar que la actividad ya no existe en la base de datos
	    TransEntrenamiento entrenamientoBorrada = daoEntrenamiento.buscarEntrenamiento(entrenamiento.getId());
	    assertNull(entrenamientoBorrada);
	}

	@Test
	public void testBajaActividadNoExistente() {
	    // Preparaci�n de datos de prueba
	    int idNoExistente = 100;

	    // Ejecuci�n del m�todo a probar y verificaci�n de resultados
	    try {
	        saEntrenamiento.BajaEntrenamiento(idNoExistente);
	        fail("Se esperaba una excepci�n IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	        // Excepci�n esperada, se considera un caso de �xito
	    }
	}
	
	@Test
    public void testMostrarActividad() {
        // Crear una actividad en la base de datos
        TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 1, 100, "Entrenamiento 1");
        
        daoEntrenamiento.altaEntrenamiento(entrenamiento);
        // Mostrar la actividad
        TransEntrenamiento entrenamientoMostrado = saEntrenamiento.MostrarEntrenamiento(entrenamiento.getId());
        assertNotNull(entrenamientoMostrado);
        assertEquals(entrenamiento.getId(), entrenamientoMostrado.getId());
        assertEquals(entrenamiento.getIdM(), entrenamientoMostrado.getIdM());
        saEntrenamiento.BajaEntrenamiento(1);
    }
}
