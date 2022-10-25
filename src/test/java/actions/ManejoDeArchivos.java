package actions;


import java.io.*;

public class ManejoDeArchivos {

        public static void crearArchivo(String nombreArchivo) {
            File archivo = new File(nombreArchivo);
            try {
                PrintWriter salida = new PrintWriter(archivo);
                salida.close();
                System.out.println("file created");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
        }

        public static void escribirArchivo(String nombreArchivo, String contenido) {
            File archivo = new File(nombreArchivo);
            try {
                PrintWriter salida = new PrintWriter(archivo);
                salida.println(contenido);
                salida.close();
                System.out.println("wrote to the file");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
        }

        public static void anexarArchivo(String nombreArchivo, String contenido) {
            File archivo = new File(nombreArchivo);
            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
                salida.println(contenido);
                salida.close();
                System.out.println("Se ha anexado informacion al archivo");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

        public static void leerArchivo(String nombreArchivo) {
            var archivo = new File(nombreArchivo);
            try {
                var entrada = new BufferedReader(new FileReader(archivo));
                var lectura = entrada.readLine();
                int dd =0;
                while(lectura != null){
                    lectura = entrada.readLine();
                    System.out.println(lectura);
                }
                entrada.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

}

