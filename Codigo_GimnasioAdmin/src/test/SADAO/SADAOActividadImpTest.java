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
		// Preparaci�n de datos de prueba
		TransActividad actividad = new TransActividad(1, 1, 100, 20, "Actividad 1");

		// Ejecuci�n del m�todo a probar
		int resultado = saActividad.AltaActividad(actividad);

		// Verificaci�n de resultados
		assertEquals(1, resultado);
		saActividad.BajaActividad(1);
	}

	@Test
	public void testAltaActividadExistente() {
		 // Preparaci�n de datos de prueba
		TransActividad actividad1 = new TransActividad(1, 1, 100, 20, "Actividad 1");
	   

	   
	    boolean exito1 = daoActividad.altaActividad(actividad1);
	   
	    assertTrue(exito1);
	    

	    // Ejecuci�n del m�todo a probar
	    try {
	        saActividad.AltaActividad(actividad1);
	        fail("Se esperaba una excepci�n IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
			// Verificaci�n de resultados
			assertEquals("Ya existe una actividad con id 1", e.getMessage());
		}
	    saActividad.BajaActividad(1);
	}
	
	@Test
    public void testAltaActividadMonitorInexistente() {
        // Preparaci�n de datos de prueba
		TransActividad actividad = new TransActividad(1, 10, 100, 20, "Actividad 1");

        // Ejecuci�n del m�todo a probar
        try {
            saActividad.AltaActividad(actividad);
            fail("Se esperaba una excepci�n IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Verificaci�n de resultados
            assertEquals("No existe un monitor con id 10", e.getMessage());
        }
        
    }

	@Test
    public void testBajaActividadExitoso() {
        // Preparaci�n de datos de prueba
		TransActividad actividad = new TransActividad(1, 1, 100, 20, "Actividad 1");
        daoActividad.altaActividad(actividad); // Insertar la actividad en la base de datos antes de realizar el test

        // Ejecuci�n del m�todo a probar
        int resultado = saActividad.BajaActividad(1);

        // Verificaci�n de resultados
        assertEquals(1, resultado);
    }
	
	@Test
	public void testBajaActividadExistente() {
	    // Preparaci�n de datos de prueba
		TransActividad actividad = new TransActividad(1, 1, 100, 20, "Actividad 1");
	    
	    // Insertar la actividad en la base de datos antes de realizar el test
	    boolean exito = daoActividad.altaActividad(actividad);
	    assertTrue(exito);

	    // Ejecuci�n del m�todo a probar
	    int resultado = saActividad.BajaActividad(actividad.getId());

	    // Verificaci�n de resultados
	    assertEquals(1, resultado);

	    // Verificar que la actividad ya no existe en la base de datos
	    TransActividad actividadBorrada = daoActividad.buscar(actividad.getId());
	    assertNull(actividadBorrada);
	}

	@Test
	public void testBajaActividadNoExistente() {
	    // Preparaci�n de datos de prueba
	    int idActividadNoExistente = 100;

	    // Ejecuci�n del m�todo a probar y verificaci�n de resultados
	    try {
	        saActividad.BajaActividad(idActividadNoExistente);
	        fail("Se esperaba una excepci�n IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	        // Excepci�n esperada, se considera un caso de �xito
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
	    // Preparaci�n de datos de prueba
		TransActividad actividad1 = new TransActividad(1, 1, 100, 20, "Actividad 1");
		TransActividad actividad2 = new TransActividad(3, 1, 200, 15, "Actividad 2");
	    
	    // Insertar las actividades en la base de datos antes de realizar el test
	    boolean exito1 = daoActividad.altaActividad(actividad1);
	    boolean exito2 = daoActividad.altaActividad(actividad2);
	    assertTrue(exito1);
	    assertTrue(exito2);

	    // Ejecuci�n del m�todo a probar
	    ArrayList<TransActividad> actividades = saActividad.ListarActividad();
	    
	    // Verificaci�n de resultados
	    assertNotNull(actividades);
	    assertEquals(2, actividades.size());
	    saActividad.BajaActividad(3);
	    saActividad.BajaActividad(1);
	    
	}

	
}
