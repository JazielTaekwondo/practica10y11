import poo.paquete.texto.Secuencia;
public class Main {
    public static void main(String[] args) {
        Secuencia alfa = new Secuencia();
        System.out.println("\nARCHIVO LEIDO EN PANTALLA:\n");
        alfa.leerArchivo();
        alfa.crearArchivo();
        alfa.crearArchivoRegalos();
        System.out.println("Puede revisar la secuencia solicitada en secuencia.txt");
        System.out.println("Puede revisar el archivo con los 12 regalos en regalos.txt");
    }
}