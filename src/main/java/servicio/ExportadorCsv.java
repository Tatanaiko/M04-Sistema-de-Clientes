package servicio;

import lombok.*;
import modelo.CategoriaEnum;
import modelo.Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
public class ExportadorCsv extends Exportador{

    @Override
    public void exportar(List<Cliente> listaClientes, String fileName1) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName1 + ".csv"))) {
            for (Cliente cliente : listaClientes) {
                writer.printf("%s,%s,%s,%d,%s%n",
                        cliente.getRutCliente(),
                        cliente.getNombreCliente(),
                        cliente.getApellidoCliente(),
                        cliente.getAniosCliente(),
                        cliente.getNombreCategoria());
            }
            System.out.println("Exportación a CSV completada.");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

}
