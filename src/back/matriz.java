/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class matriz {

    public static void main(String[] args) {
        // Tamaño de la matriz
        int filas = 1000;
        int columnas = 1000;

        // Crear una matriz de enteros de 1000x1000 con valores entre -9 y 9
        int[][] matriz = new int[filas][columnas];
        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(19) - 9;
            }
        }

        // Escribir la matriz en un archivo
        escribirMatrizEnArchivo(matriz, "matriz2.txt");
    }

    // Método para escribir una matriz en un archivo
    private static void escribirMatrizEnArchivo(int[][] matriz, String rutaArchivo) {
        try (PrintWriter writer = new PrintWriter(new File(rutaArchivo))) {
            // Escribir el tamaño de la matriz en la primera línea
            writer.println(matriz.length + " " + matriz[0].length);

            // Escribir los elementos de la matriz en el archivo
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    writer.print(matriz[i][j]);
                    if (j < matriz[i].length - 1) {
                        writer.print(" ");
                    }
                }
                writer.println(); // Nueva línea al final de cada fila
            }

            System.out.println("Matriz escrita en el archivo correctamente.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[][] leerMatrizDesdeArchivo(String rutaArchivo) {
        int[][] matriz = null;

        try {
            File archivo = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivo);

            // Determinar el tamaño de la matriz (asumiendo que el archivo contiene filas y columnas en la primera línea)
            int filas = scanner.nextInt();
            int columnas = scanner.nextInt();
            matriz = new int[filas][columnas];

            // Leer los elementos de la matriz desde el archivo
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }

            // Cerrar el scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matriz;
    }

    // Método para imprimir una matriz (solo para verificar)
    private static void imprimirMatriz(int[][] matriz) {
        if (matriz != null) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
