package test;

import modelo.Cliente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicio.ClienteServicio;
import modelo.CategoriaEnum;

import java.util.List;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static modelo.CategoriaEnum.ACTIVO;

public class ClienteServicioTest {
    private ClienteServicio clienteServicio;

    @BeforeEach
    public void inicializacionCliente(){
        clienteServicio = new ClienteServicio();
    }

    @Test
    public void agregarClienteTest() {

        String rut = "1212121212";
        String nombre = "asdasada";
        String apellido =  "Perez";
        int anios = 2;

        Scanner sc = new Scanner("1212121212\nasdasada\nPerez\n2\n");
        clienteServicio.agregarCliente(sc);

        List<Cliente> listaClientes = clienteServicio.getListaCliente();
        assertEquals(1, listaClientes.size());

        Cliente agregado = listaClientes.get(0);
        assertEquals(rut, agregado.getRutCliente());
        assertEquals(nombre, agregado.getNombreCliente());
        assertEquals(apellido, agregado.getApellidoCliente());
        assertEquals(ACTIVO, agregado.getNombreCategoria());

    }
    @Test
    public void agregarClienteNullTest() {

        String datosEntrada = "\n\n\n\n";
        Scanner sc = new Scanner(datosEntrada);

        clienteServicio.agregarCliente(sc);


        List<Cliente> listaClientes = clienteServicio.getListaCliente();
        assertEquals(0, listaClientes.size());
    }
}
