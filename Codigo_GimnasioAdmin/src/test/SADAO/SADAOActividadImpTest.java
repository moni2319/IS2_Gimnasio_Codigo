package test.SADAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import integracion.actividad.DAOActividad;
import integracion.factoria.FactoriaDAO;
import integracion.factoria.FactoriaDAOImp;
import integracion.monitor.DAOMonitor;
import integracion.monitor.DAOMonitorImp;
import negocio.actividad.SAActividad;
import negocio.actividad.SAActividadImp;
import negocio.actividad.TransActividad;
import negocio.sesion.SASesion;

public class SADAOActividadImpTest {
	//HACEN AMBAS COMPROBACIONES de DAO y SAA
	private SAActividad saActividad;
	private DAOActividad daoActividad;
	private DAOMonitor daoMonitor;

	@Before
	public void setUp() {
		FactoriaDAO factoriaDAO = new FactoriaDAOImp();
        daoActividad = factoriaDAO.getDAOActividad();
        daoMonitor = factoriaDAO.getDAOMonitor();
        saActividad = new SAActividadImp();
	}

	@Test
	public void testAltaActividadExitoso() {
		// Preparación de datos de prueba
		TransActividad actividad = new TransActividad(1, 1, 100, 20, "Actividad 1");

		// Ejecución del método a probar
		int resultado = saActividad.AltaActividad(actividad);

		// Verificación de resultados
		assertEquals(1, resultado);
		saActividad.BajaActividad(1);
	}

	@Test
	public void testAltaActividadExistente() {
		 // Preparación de datos de prueba
		TransActividad actividad1 = new TransActividad(1, 1, 100, 20, "Actividad 1");
	   

	   
	    boolean exito1 = daoActividad.altaActividad(actividad1);
	   
	    assertTrue(exito1);
	    

	    // Ejecución del método a probar
	    try {
	        saActividad.AltaActividad(actividad1);
	        fail("Se esperaba una excepción IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
			// Verificación de resultados
			assertEquals("Ya existe una actividad con id 1", e.getMessage());
		}
	    saActividad.BajaActividad(1);
	}
	
	@Test
    public void testAltaActividadMonitorInexistente() {
        // Preparación de datos de prueba
		TransActividad actividad = new TransActividad(1, 10, 100, 20, "Actividad 1");

        // Ejecución del método a probar
        try {
            saActividad.AltaActividad(actividad);
            fail("Se esperaba una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Verificación de resultados
            assertEquals("No existe un monitor con id 10", e.getMessage());
        }
        
    }

	@Test
    public void testBajaActividadExitoso() {
        // Preparación de datos de prueba
		TransActividad actividad = new TransActividad(1, 1, 100, 20, "Actividad 1");
        daoActividad.altaActividad(actividad); // Insertar la actividad en la base de datos antes de realizar el test

        // Ejecución del método a probar
        int resultado = saActividad.BajaActividad(1);

        // Verificación de resultados
        assertEquals(1, resultado);
    }
	
	@Test
	public void testBajaActividadExistente() {
	    // Preparación de datos de prueba
		TransActividad actividad = new TransActividad(1, 1, 100, 20, "Actividad 1");
	    
	    // Insertar la actividad en la base de datos antes de realizar el test
	    boolean exito = daoActividad.altaActividad(actividad);
	    assertTrue(exito);

	    // Ejecución del método a probar
	    int resultado = saActividad.BajaActividad(actividad.getId());

	    // Verificación de resultados
	    assertEquals(1, resultado);

	    // Verificar que la actividad ya no existe en la base de datos
	    TransActividad actividadBorrada = daoActividad.buscar(actividad.getId());
	    assertNull(actividadBorrada);
	}

	@Test
	public void testBajaActividadNoExistente() {
	    // Preparación de datos de prueba
	    int idActividadNoExistente = 100;

	    // Ejecución del método a probar y verificación de resultados
	    try {
	        saActividad.BajaActividad(idActividadNoExistente);
	        fail("Se esperaba una excepción IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	        // Excepción esperada, se considera un caso de éxito
	    }
	}
	
	@Test
    public void testMostrarActividad() {
        // Crear una actividad en la base de datos
		TransActividad actividad = new TransActividad(1, 1, 100, 20, "Actividad 1");
        
        daoActividad.altaActividad(actividad);
        // Mostrar la actividad
        TransActividad actividadMostrada = saActividad.MostrarActividad(actividad.getId());
        assertNotNull(actividadMostrada);
        assertEquals(actividad.getId(), actividadMostrada.getId());
        assertEquals(actividad.getIdM(), actividadMostrada.getIdM());
        saActividad.BajaActividad(1);
    }
	
	@Test
	public void testListarActividad() {
	    // Preparación de datos de prueba
		TransActividad actividad1 = new TransActividad(1, 1, 100, 20, "Actividad 1");
		TransActividad actividad2 = new TransActividad(3, 1, 200, 15, "Actividad 2");
	    
	    // Insertar las actividades en la base de datos antes de realizar el test
	    boolean exito1 = daoActividad.altaActividad(actividad1);
	    boolean exito2 = daoActividad.altaActividad(actividad2);
	    assertTrue(exito1);
	    assertTrue(exito2);

	    // Ejecución del método a probar
	    ArrayList<TransActividad> actividades = saActividad.ListarActividad();
	    
	    // Verificación de resultados
	    assertNotNull(actividades);
	    assertEquals(2, actividades.size());
	    saActividad.BajaActividad(3);
	    saActividad.BajaActividad(1);
	    
	}

	
}
