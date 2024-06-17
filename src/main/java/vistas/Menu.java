package vistas;

import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidades;

import java.util.Scanner;

import static utilidades.Utilidades.limpiarPantalla;

public class Menu {

    private ClienteServicio clienteServicio;
    private ArchivoServicio archivoServicio;

    private ExportadorCsv exportadorCsv;
    private ExportadorTxt exportadorTxt;
    private String fileName = "Clientes";
    private String filename1 = "DBClientes.csv";
    private Scanner sc;
    public Menu() {
    }


    public Menu(ClienteServicio clienteServicio, ArchivoServicio archivoServicio, ExportadorCsv exportadorCsv, ExportadorTxt exportadorTxt, String fileName, String filename1, Scanner sc) {
        this.clienteServicio = clienteServicio;
        this.archivoServicio = archivoServicio;
        this.exportadorCsv = exportadorCsv;
        this.exportadorTxt = exportadorTxt;
        this.fileName = fileName;
        this.fileName = filename1;
        this.sc = sc;
    }

    public void iniciarMenu() {
        int opcion;
        do {
            mostrarMenu();
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();
            opciones(opcion);

        } while (opcion != 6);

    }

    public void mostrarMenu() {
        System.out.println("Menu");
        System.out.println("1. Listar Clientes");
        System.out.println("2. Agregar Clientes");
        System.out.println("3. Editar Clientes");
        System.out.println("4. Cargar Datos");
        System.out.println("5. Exportar Datos");
        System.out.println("6. Salir");
        System.out.println("Ingrese una opción");

    }

    public void terminarPrograma() {
        System.out.println("Saliendo...");
        System.exit(0);
    }

    public void opciones(int opcion) {
        switch (opcion) {
            case 1:
                clienteServicio.listarClientes();
                break;
            case 2:
                clienteServicio.agregarCliente(sc);
                break;
            case 3:
                clienteServicio.editarCliente();
                break;
            case 4:
                archivoServicio.cargarDatos(fileName);
                break;
            case 5:
                try {
                    exportadorCsv.exportar(clienteServicio.getListaCliente(), filename1);
                    System.out.println("Se ha exportado correctamente a " + filename1);
                } catch (Exception e) {
                    System.out.println("Error durante la exportación: " + e.getMessage());
                    e.printStackTrace();
                }
                break;
            case 6:
                terminarPrograma();
            default:
                System.out.println("Opción inválida. Inténtelo de nuevo.");
                break;
        }limpiarPantalla();
    }
}



