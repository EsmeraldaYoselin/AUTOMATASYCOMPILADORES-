/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Practica3 {
    public static void main(String[] args) {
        // Ruta del archivo de entrada
        String rutaArchivo = "C:\\Users\\canoe\\Downloads\\texto.txt";

        // Variables contadoras
        int totCarConEspacios = 0;
        int totCarSinEspacios = 0;
        int totLexemas = 0;
        int totPalabras = 0;
        int totNumeros = 0;
        int totCompuestas = 0;

        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append(" ");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Texto completo
        String texto = contenido.toString().trim();

        // Conteo de caracteres
        totCarConEspacios = texto.length();
        totCarSinEspacios = texto.replace(" ", "").length();

        // Separar en lexemas
        String[] lexemas = texto.split("\\s+");
        totLexemas = lexemas.length;

        for (String lexema : lexemas) {
            if (lexema.matches("\\d+")) {
                totNumeros++;
            } else if (lexema.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                totPalabras++;
            } else if (lexema.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ]+")) {
                totCompuestas++;
            }
        }

        // Mostrar resultados
        System.out.println("Total de caracteres (con espacios): " + totCarConEspacios);
        System.out.println("Total de caracteres (sin espacios): " + totCarSinEspacios);
        System.out.println("Total de lexemas: " + totLexemas);
        System.out.println("Total de palabras: " + totPalabras);
        System.out.println("Total de numeros: " + totNumeros);
        System.out.println("Total de combinadas: " + totCompuestas);
    }
}
