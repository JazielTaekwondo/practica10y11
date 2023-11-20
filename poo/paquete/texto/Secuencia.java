package poo.paquete.texto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Secuencia {
    private Stack<String> pila = new Stack<>();
    private String rutaVillancico;
    private String rutaSecuencia;
    private String rutaRegalos;

    public Secuencia(){
        String directorioActual = System.getProperty("user.dir");// Obtiene la ruta del directorio actual
        this.rutaVillancico = directorioActual + "/12_dias.txt";
        this.rutaSecuencia = directorioActual + "/secuencia.txt";
        this.rutaRegalos = directorioActual + "/regalos.txt";
    }
    
    public void crearArchivo(){
       try{
            FileWriter fw = new FileWriter(this.rutaSecuencia);
            int n = this.pila.size();
            for (int i = 0; i < n; i++) {
                fw.write(this.pila.pop());
            }
            fw.close();
            System.out.println("\nArchivo de secuencia creado con exito");

        }catch(IOException e){
            System.out.println("Error al crear un nuevo archivo: "+ e.getMessage());
        }
    }

    public void crearArchivoRegalos() {
        List<String> lineas = leerArchivoSecuencia();
        List<String> REGALOS = new ArrayList<>(Arrays.asList("drummers", "pipers", "lords", "ladies", "maids", "swans",
                "geese", "rings", "birds", "hens", "doves", "partridge"));
    
        try (FileWriter fw = new FileWriter(rutaRegalos)) {
            fw.write("The gifts are:\n");
    
            for (String linea : lineas) {
                if (contieneRegalos(linea, REGALOS)) {
                    fw.write(linea + "\n");
                }
            }
            fw.close();
            System.out.println("Archivo de regalos creado con éxito");
        } catch (IOException e) {
            System.out.println("Error al crear un nuevo archivo de regalos: " + e.getMessage());
        }
    }
    
    private boolean contieneRegalos(String linea, List<String> regalos) {
        List<String> regalosEncontrados = new ArrayList<>();
    
        for (String regalo : regalos) {
            if (linea.toLowerCase().contains(regalo)) {
                regalosEncontrados.add(regalo);
            }
        }
        // Crear una nueva lista antes de realizar removeAll
        List<String> regalosactualizados = new ArrayList<>(regalos);
        regalosactualizados.removeAll(regalosEncontrados);
        // Actualizar la lista original con la nueva lista (se quita el regalo que ya se ha encontrado)
        regalos.clear();
        regalos.addAll(regalosactualizados);
        return !regalosEncontrados.isEmpty();
    }

    public List<String> leerArchivoSecuencia(){
        List<String> lineas = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(rutaSecuencia);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                //System.out.println(linea);
                lineas.add(linea);
            }
            bufferedReader.close(); 
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
        return lineas;
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