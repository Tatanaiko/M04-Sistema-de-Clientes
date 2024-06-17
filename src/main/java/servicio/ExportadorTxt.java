package servicio;

import modelo.Cliente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorTxt extends Exportador {
    @Override
    public void exportar(List<Cliente> listaClientes, String fileName) throws IOException {

        if(listaClientes.isEmpty()){
        System.out.println("No existen productos Clientes para exportar. Por favor agrega Clientes o importalos.");
        }else {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Cliente cliente : listaClientes) {
                    writer.write(cliente.toString());
                    writer.newLine();
                }
                System.out.println("Se ha exportado correctamente a " + fileName + ".cvs");
            } catch (IOException e) {
                System.out.println("Error al exportar los Clientes: " + e.getMessage());
                throw e;
            }
        }
    }
}

