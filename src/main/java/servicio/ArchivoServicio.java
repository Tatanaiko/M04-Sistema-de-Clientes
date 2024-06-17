package servicio;

import modelo.Cliente;

import java.io.*;
import java.util.List;

public class ArchivoServicio extends Exportador{

    @Override
    public void exportar(List<Cliente> listaClientes, String fileName) throws IOException {

    }

    public void cargarDatos (String fileName){
       File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("El archivo" + fileName +" ingresado no existe");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
}
