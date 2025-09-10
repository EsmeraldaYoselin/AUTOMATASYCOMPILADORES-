/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicas;

import java.util.Scanner;
/**
 *
 * @author canoe
 */
public class Programa_2 {
  
    // Método que determina si la cadena es un número entero
    public static boolean Entero(String cadena) {
        return cadena.matches("\\d+");
    }
    // Método que determina si la cadena es una palabra 
    public static boolean Palabra(String cadena) {
        return cadena.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+"); // solo letras
    }
    // Método que determina si la cadena es compuesta (letras Y números)
    public static boolean Compuesta(String cadena) {
        return cadena.matches("(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena de caracteres:");
        String entrada = sc.nextLine();

        // Dividimos por espacios
        String[] cadenas = entrada.split("\\s+");

        int contadorEnteros = 0;
        int contadorPalabras = 0;
        int contadorCompuestas = 0;

        for (String cad : cadenas) {
            if (Entero(cad)) {
                contadorEnteros++;
            } else if (Palabra(cad)) {
                contadorPalabras++;
            } else if (Compuesta(cad)) {
                contadorCompuestas++;
            }
        }

        // resultado
        if (contadorEnteros > 0)
            System.out.println(contadorEnteros + " - entero");
        if (contadorPalabras > 0)
            System.out.println(contadorPalabras + " - palabra");
        if (contadorCompuestas > 0)
            System.out.println(contadorCompuestas + " - compuesta");

        sc.close();
    }
}

    

