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
import integracion.factura.DAOFactura;
import negocio.factura.SAFacturaImp;
import negocio.factura.TransFactura;

public class SADAOFacturaImpTest {
	private SAFacturaImp saFactura;
    private DAOFactura daoFactura;

    @Before
    public void setUp() {
        // Conectar a la base de datos
        FactoriaDAO factoriaDAO = new FactoriaDAOImp();
        daoFactura = factoriaDAO.getDAOFactura();
        saFactura = new SAFacturaImp();
        //ACORDARSE de Crear Cliente 2 y 3
    }

    @Test
    public void testAltaExitoso() {
        // Preparaci�n de datos de prueba
        TransFactura factura = new TransFactura(1, 2, 3);

        // Ejecuci�n del m�todo a probar
        int resultado = saFactura.AbrirFactura(factura);

        // Verificaci�n de resultados
        assertEquals(1, resultado);
        saFactura.CerrarFactura(1);
    }

    @Test
    public void testAltaExistente() {
        // Preparaci�n de datos de prueba
        TransFactura factura1 = new TransFactura(1, 2, 3);

        boolean exito1 = daoFactura.abrirFactura(factura1);

        assertTrue(exito1);

        // Ejecuci�n del m�todo a probar
        try {
            saFactura.AbrirFactura(factura1);
            fail("Se esperaba una excepci�n IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Verificaci�n de resultados
            assertEquals("Ya existe una factura con codigo 1", e.getMessage());
        }
        saFactura.CerrarFactura(1);
    }

    @Test
    public void testBajaExitoso() {
        // Preparaci�n de datos de prueba
        TransFactura factura1 = new TransFactura(1, 2, 3);;
        daoFactura.abrirFactura(factura1);

        // Ejecuci�n del m�todo a probar
        int resultado = saFactura.CerrarFactura(1);

        // Verificaci�n de resultados
        assertEquals(1, resultado);
    }

    @Test
    public void testBajaExistente() {
        // Preparaci�n de datos de prueba
        TransFactura factura1 = new TransFactura(1, 2, 3);

        boolean exito = daoFactura.abrirFactura(factura1);
        assertTrue(exito);

        // Ejecuci�n del m�todo a probar
        int resultado = saFactura.CerrarFactura(factura1.getCod());

        // Verificaci�n de resultados
        assertEquals(1, resultado);

        // Verificar que ya no existe en la base de datos
        TransFactura borrado = daoFactura.buscarFactura(factura1.getCod());
        assertNull(borrado);
    }
    
    @Test
    public void testBajaNoExistente() {
        // Preparaci�n de datos de prueba
        int idNoExistente = 100;

        // Ejecuci�n del m�todo a probar y verificaci�n de resultados
        try {
            saFactura.CerrarFactura(idNoExistente);
            fail("Se esperaba una excepci�n IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Excepci�n esperada, se considera un caso de �xito
            assertEquals("No existe una factura con el codigo 100", e.getMessage());
        }
    }
    
    @Test
    public void testMostrar() {
        // Crear una factura en la base de datos
        TransFactura factura1 = new TransFactura(1, 2, 3);

        daoFactura.abrirFactura(factura1);
        // Mostrar la factura
        TransFactura mostrada = saFactura.MostrarFactura(factura1.getCod());
        assertNotNull(mostrada);
        assertEquals(factura1.getCod(), mostrada.getCod());
        assertEquals(factura1.getIdCliente(), mostrada.getIdCliente());
        saFactura.CerrarFactura(1);
    }
    
    @Test
    public void testListar() {
        // Preparaci�n de datos de prueba
        TransFactura factura1 = new TransFactura(1, 2, 3);
        TransFactura factura2 = new TransFactura(2, 3, 4);
        saFactura.AbrirFactura(factura1);
        saFactura.AbrirFactura(factura2);

        // Obtener la lista de facturas
        ArrayList<TransFactura> lista = saFactura.ListarFactura();

        // Verificar que la lista no est� vac�a y contiene las facturas esperadas
        assertNotNull(lista);
        assertEquals(2, lista.size());

        saFactura.CerrarFactura(1);
        saFactura.CerrarFactura(2);
    }

}
