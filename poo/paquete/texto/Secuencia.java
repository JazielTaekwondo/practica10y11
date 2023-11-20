package poo.paquete.texto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

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
        Stack<String> pila = new Stack<>();
        String linea, parrafo="";
        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader); 
            while ((linea = bufferedReader.readLine()) != null) {
                parrafo=parrafo+linea+"\n";
                if (linea.trim().isEmpty()){// Devuelve true si la longitud de una linea es 0, por lo tanto se asume que acaba un parafo
                    //System.out.println(parrafo);
                    pila.push(parrafo);
                    parrafo="";
                }
            }
            pila.push(parrafo); //Añade el ultimo parrafo
            int n= pila.size();
            for (int i = 0; i < n; i++) {
                System.out.println(pila.pop());
            }
            bufferedReader.close(); 
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}
