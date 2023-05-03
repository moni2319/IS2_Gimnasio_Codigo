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
		// Preparación de datos de prueba
		TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 1, 100, "Entrenamiento 1");

		// Ejecución del método a probar
		int resultado = saEntrenamiento.AltaEntrenamiento(entrenamiento);

		// Verificación de resultados
		assertEquals(1, resultado);
		saEntrenamiento.BajaEntrenamiento(1);
	}

	@Test
	public void testAltaActividadExistente() {
		 // Preparación de datos de prueba
	    TransEntrenamiento entrenamiento1 = new TransEntrenamiento(1, 1, 100,  "Entrenamiento 1");
	   

	   
	    boolean exito1 = daoEntrenamiento.altaEntrenamiento(entrenamiento1);
	   
	    assertTrue(exito1);
	    

	    // Ejecución del método a probar
	    try {
	        saEntrenamiento.AltaEntrenamiento(entrenamiento1);
	        fail("Se esperaba una excepción IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
			// Verificación de resultados
			assertEquals("Ya existe un entrenamiento con id 1", e.getMessage());
		}
	    saEntrenamiento.BajaEntrenamiento(1);
	}
	
	@Test
    public void testAltaActividadMonitorInexistente() {
        // Preparación de datos de prueba
        TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 10, 100, "Entrenamiento 1");

        // Ejecución del método a probar
        try {
            saEntrenamiento.AltaEntrenamiento(entrenamiento);
            fail("Se esperaba una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Verificación de resultados
            assertEquals("No existe un monitor con id 10", e.getMessage());
        }
        
    }

	@Test
    public void testBajaActividadExitoso() {
        // Preparación de datos de prueba
        TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 1, 100, "Entrenamiento 1");
        daoEntrenamiento.altaEntrenamiento(entrenamiento); 

        // Ejecución del método a probar
        int resultado = saEntrenamiento.BajaEntrenamiento(1);

        // Verificación de resultados
        assertEquals(1, resultado);
    }
	
	@Test
	public void testBajaActividadExistente() {
	    // Preparación de datos de prueba
	    TransEntrenamiento entrenamiento = new TransEntrenamiento(1, 1, 100, "Entrenamiento 1");
	    
	    // Insertar la actividad en la base de datos antes de realizar el test
	    boolean exito = daoEntrenamiento.altaEntrenamiento(entrenamiento);
	    assertTrue(exito);

	    // Ejecución del método a probar
	    int resultado = saEntrenamiento.BajaEntrenamiento(entrenamiento.getId());

	    // Verificación de resultados
	    assertEquals(1, resultado);

	    // Verificar que la actividad ya no existe en la base de datos
	    TransEntrenamiento entrenamientoBorrada = daoEntrenamiento.buscarEntrenamiento(entrenamiento.getId());
	    assertNull(entrenamientoBorrada);
	}

	@Test
	public void testBajaActividadNoExistente() {
	    // Preparación de datos de prueba
	    int idNoExistente = 100;

	    // Ejecución del método a probar y verificación de resultados
	    try {
	        saEntrenamiento.BajaEntrenamiento(idNoExistente);
	        fail("Se esperaba una excepción IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	        // Excepción esperada, se considera un caso de éxito
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
