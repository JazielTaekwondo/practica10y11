package poo.paquete.texto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Secuencia {
    private Stack<String> pila = new Stack<>();
    private String rutaVillancico;
    private String rutaSecuencia;

    public Secuencia(){
        String directorioActual = System.getProperty("user.dir");// Obtiene la ruta del directorio actual
        this.rutaVillancico = directorioActual + "/12_dias.txt";
        this.rutaSecuencia = directorioActual + "/secuencia.txt";
    }

    public void crearArchivo(){
       try{
            FileWriter fw = new FileWriter(this.rutaSecuencia);
            int n = this.pila.size();
            for (int i = 0; i < n; i++) {
                fw.write(this.pila.pop());
            }
            fw.close();
            System.out.println("\nArchivo creado con exito");

        }catch(IOException e){
            System.out.println("Error al crear un nuevo archivo: "+ e.getMessage());
        }
    }
    public void leerArchivo(){
        String linea, parrafo="";

        try {
            FileReader fileReader = new FileReader(this.rutaVillancico);
            BufferedReader bufferedReader = new BufferedReader(fileReader); 
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
                parrafo=parrafo+linea+"\n";
                if (linea.trim().isEmpty()){// Devuelve true si la longitud de una linea es 0, por lo tanto se asume que acaba un parafo
                    this.pila.push(parrafo);
                    parrafo="";
                }
            }
            this.pila.push(parrafo+"\n"); //Añade el ultimo parrafo
            bufferedReader.close(); 
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}