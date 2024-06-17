package servicio;
import lombok.*;
import modelo.CategoriaEnum;
import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@AllArgsConstructor
@Setter
@Getter
@ToString

public class ClienteServicio {
    private List<Cliente> listaCliente;
    private Scanner sc;
    public ClienteServicio() {
        this.listaCliente = new ArrayList<>();
    }

    public void listarClientes() {
        if (listaCliente.isEmpty()){
            System.out.println("No existen datos de Clientes. Agrega o Carga datos");
        }else {
            for (Cliente cliente : listaCliente) {
                System.out.println("------------Datos del Cliente--------------------");
                System.out.println("RUN del Cliente: " + cliente.getRutCliente());
                System.out.println("Nombre del Cliente: " + cliente.getNombreCliente());
                System.out.println("Apellido del Cliente: " + cliente.getApellidoCliente());
                System.out.println("Categoría del Cliente: " + cliente.getNombreCategoria());
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void agregarCliente(Scanner sc) {
        System.out.println("-------------Crear Cliente----------------------");
        System.out.println("Ingresa RUN del Cliente");
        String rut = sc.nextLine().trim();
        System.out.println("Ingresa Nombre del Cliente");
        String nombre = sc.nextLine().trim();
        System.out.println("Ingresa Apellido del Cliente");
        String apellido = sc.nextLine().trim();
        System.out.println("Ingresa años como Cliente");
        int anios;
        try {
            anios = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: Los años como cliente deben ser un número válido.");
            return;
        }
        System.out.println("-------------------------------------------------");

        if (rut.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            System.out.println("Error: No se pudo crear el cliente. Datos incompletos.");
            return;
        }
        try {
            Cliente cliente = new Cliente(rut, nombre, apellido, anios, CategoriaEnum.ACTIVO);
            listaCliente.add(cliente);
            System.out.println("Cliente agregado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el cliente: " + e.getMessage());
        }
    }

    public void editarCliente() {
        System.out.println("Ingrese RUN del Cliente a editar");
        String rut = sc.nextLine();
        Cliente cliente = buscarRutCliente(rut);
        if (cliente == null){
            String respuesta;
            do {
                System.out.println("No existen datos sobre el RUN proporcionado.");
                System.out.println("¿Seguir editando? S/N");
                respuesta = sc.nextLine();

                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.println("Ingrese nuevamente el RUN del Cliente a editar:");
                    rut = sc.nextLine();
                    cliente = buscarRutCliente(rut);
                } else if (respuesta.equalsIgnoreCase("n")) {
                    return;
                } else {
                    System.out.println("Respuesta no válida. Intente de nuevo.");
                }
            } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));

        }
        int opcion;

        do {
            System.out.println("-------------------Editar Cliente-----------------");
            System.out.println("Seleccione qué desea hacer: ");
            System.out.println("1.- Cambiar el estado del Cliente");
            System.out.println("2.- Editar los datos ingresados del Cliente");
            System.out.println("3.- Salir");
            System.out.println("Ingrese opción: ");
            opcion = sc.nextInt();
            System.out.println("---------------------------------------------------");

            switch (opcion){
                case 1:
                    editarEstadoCliente(cliente);
                    break;
                case 2:
                    editarDatosCliente(cliente);

                case 3:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (opcion != 3);
    }
    public Cliente buscarRutCliente(String rut) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getRutCliente().equals(rut)) {
                return cliente;
            }
        }
        return null;
    }

    public void editarEstadoCliente(Cliente cliente) {
        int opcion;
        do {
            System.out.println("------Actualizando estado del Cliente------");
            System.out.println("El estado actual es: " + cliente.getNombreCategoria());
            System.out.println("1.- Si desea cambiar el estado del Cliente a Inactivo");
            System.out.println("2.- Si desea cambiar el estado del Cliente a Activo");
            System.out.println("3.- Salir");
            System.out.println("Ingrese opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
                    break;
                case 2:
                    cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
                    break;
                case 3:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Ingresa una opción válida");
                    break;
            }
        } while (opcion != 3);
    }

    public void editarDatosCliente(Cliente cliente) {
        int opcion;
        do {
            System.out.println("------Actualizando datos del Cliente------");
            System.out.println("1.-El RUN del Cliente es: " + cliente.getRutCliente());
            System.out.println("2.-El Nombre del Cliente es: " + cliente.getNombreCliente());
            System.out.println("3.-El Apellido del Cliente es: " + cliente.getApellidoCliente());
            System.out.println("4.-Los años como Cliente son: " + cliente.getAniosCliente());
            System.out.println("5.-Salir");
            System.out.println("Ingrese opcion a editar de los datos del Cliente: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1.- Ingrese nuevo RUN Cliente: ");
                    cliente.setRutCliente(sc.nextLine());

                    System.out.println("--------------------------------");
                    System.out.println("Actualizado con éxito");
                    break;
                case 2:
                    System.out.println("Ingrese nuevo nombre Cliente: ");
                    cliente.setNombreCliente(sc.nextLine());
                    System.out.println("--------------------------------");
                    System.out.println("Actualizado con éxito");
                    break;
                case 3:
                    System.out.println("Ingrese nuevo apellido Cliente: ");
                    cliente.setApellidoCliente(sc.nextLine());
                    System.out.println("--------------------------------");
                    System.out.println("Actualizado con éxito");
                    break;
                case 4:
                    System.out.println("Ingrese nueva cantidad de años: ");
                    cliente.setAniosCliente(sc.nextInt());
                    System.out.println("--------------------------------");
                    System.out.println("Actualizado con éxito");
                    break;
                case 5:
                    System.out.println("Saliendo....");;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    System.out.println("--------------------------------");
                    break;
            }
        } while (opcion != 5);
    }

}

