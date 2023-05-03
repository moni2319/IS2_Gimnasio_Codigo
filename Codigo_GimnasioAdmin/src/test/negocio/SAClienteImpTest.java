package test.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import integracion.cliente.DAOCliente;
import integracion.cliente.DAOClienteImp;
import integracion.factoria.FactoriaDAO;
import integracion.factoria.FactoriaDAOImp;
import negocio.cliente.SAClienteImp;
import negocio.cliente.TransCliente;
import integracion.DataBaseConnection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SAClienteImpTest {
    private SAClienteImp saCliente;
    private DAOCliente daoCliente;
    private Connection connection;

    @Before
    public void setUp() {
        // Conectar a la base de datos
        
        FactoriaDAO factoriaDAO = new FactoriaDAOImp();
        // Inicializar el DAOCliente y SACliente
        daoCliente = factoriaDAO.getDAOCliente();
        saCliente = new SAClienteImp();
    }



    @Test
    public void testAltaCliente() {
        // Crear un nuevo cliente
        TransCliente cliente = new TransCliente(1, "Cliente 1", 123456789);
        int resultado = saCliente.AltaCliente(cliente);

        // Verificar que el cliente se haya dado de alta correctamente
        assertEquals(1, resultado);
        assertNotNull(cliente.getId());

      
        saCliente.BajaCliente(1);
    }

    @Test
    public void testBajaCliente() {
        // Preparación de datos de prueba
        TransCliente cliente = new TransCliente(1, "Cliente 1", 123456789);
        saCliente.AltaCliente(cliente);

        // Dar de baja al cliente
        int resultado = saCliente.BajaCliente(cliente.getId());

        // Verificar que el cliente se haya dado de baja correctamente
        assertEquals(1, resultado);

      
        
    }

    @Test
    public void testListarCliente() {
        // Preparación de datos de prueba
        TransCliente cliente1 = new TransCliente(1, "Cliente 1", 123456789);
        TransCliente cliente2 = new TransCliente(2, "Cliente 2", 987654321);
        saCliente.AltaCliente(cliente1);
        saCliente.AltaCliente(cliente2);

        // Obtener la lista de clientes
        ArrayList<TransCliente> clientes = saCliente.ListarCliente();

        // Verificar que la lista no está vacía y contiene los clientes esperados
        assertNotNull(clientes);
        assertEquals(2, clientes.size());
       
        saCliente.BajaCliente(1);
        saCliente.BajaCliente(2);
    }
}
