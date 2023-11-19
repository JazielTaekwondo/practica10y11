package poo.paquete.texto;

import java.io.FileWriter;
import java.io.IOException;

public class Secuencia {
    void crearArchivo(){
        String texto = "insisto ya me quiero dormir";
        // Obtiene la ruta del directorio actual
        String directorioActual = System.getProperty("user.dir");
        // Construye la ruta completa del archivo
        String rutaArchivo = directorioActual + "/archivo.txt";
        try{
            FileWriter fw = new FileWriter(rutaArchivo);
            fw.write(texto);
            System.out.println(texto);
            fw.close();
            System.out.println("Archivo creado con contenido...");

        }catch(IOException e){
            System.out.println("Error al crear un nuevo archivo...");
        }
    }
}
