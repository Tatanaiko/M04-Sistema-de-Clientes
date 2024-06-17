package utilidades;

public class Utilidades {
    public static void esperar() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void limpiarPantalla() {
        System.out.println("\n \n \n \n \n \n \n \n \n \n");
    }

}
