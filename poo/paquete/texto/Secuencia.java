package poo.paquete.texto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Secuencia {
    public String crearArchivo(){
        String directorioActual = System.getProperty("user.dir");// Obtiene la ruta del directorio actual
        String rutaArchivo = directorioActual + "/secuencia.txt"; // Construye la ruta completa del archivo con el nombre
        try{
            FileWriter fw = new FileWriter(rutaArchivo);
            fw.close();
            System.out.println("Archivo creado con exito");

        }catch(IOException e){
            System.out.println("Error al crear un nuevo archivo: "+ e.getMessage());
        }
        return rutaArchivo;
    }
    public void leerArchivo(){
        String directorioActual = System.getProperty("user.dir");// Obtiene la ruta del directorio actual
        String rutaArchivo = directorioActual + "/12_dias.txt";
        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea; 
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
            bufferedReader.close(); 
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}
