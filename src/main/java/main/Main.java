package main;

import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import vistas.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteServicio clienteServicio = new ClienteServicio();
        ArchivoServicio archivoServicio = new ArchivoServicio();
        ExportadorCsv exportadorCsv = new ExportadorCsv();
        ExportadorTxt exportadorTxt = new ExportadorTxt();
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu(clienteServicio,archivoServicio,exportadorCsv,exportadorTxt,"Clientes","DBClientes.csv",sc);
        menu.iniciarMenu();
        sc.close();
    }
}

