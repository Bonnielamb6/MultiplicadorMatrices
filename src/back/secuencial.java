/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package back;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class secuencial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matriz objeto = new Matriz();
        int filas1;
        int columnas1;
        int filas2;
        int columnas2;
        Scanner scanner = new Scanner(System.in);
        //PARA IMPLEMENTAR DESPUES CON DINAMISMO

        System.out.println("Cuanta cantidad de filas quieres que tenga la primer matriz?");
        filas1 = scanner.nextInt();
        System.out.println("\nCuanta cantidad de columnas quieres que tenga la primer matriz?");
        columnas1 = scanner.nextInt();
        int matriz1[][] = new int[filas1][columnas1];

        System.out.println("Cuanta cantidad de filas quieres que tenga la segunda matriz?");
        filas2 = scanner.nextInt();
        System.out.println("\nCuanta cantidad de columnas quieres que tenga la segunda matriz?");
        columnas2 = scanner.nextInt();

        int matriz2[][] = new int[filas2][columnas2];

        objeto.calcularFilasColumnas(filas1, columnas2);

        //PARA PROBAR QUE SIRVA EL ALGORITMO DE MULTIPLICAR MATRICES
//        int [][] matriz1 = {
//            {5,3,-4,-2},
//            {8,-1,0,-3}
//        };
//        
//        int [][] matriz2 = {
//            {1,4,0},
//            {-5,3,7},
//            {0,-9,5},
//            {5,1,4}
//        };
//        objeto.calcularFilasColumnas(2, 3);
        long semilla = 12345L; // Cambia esta semilla si deseas obtener diferentes números aleatorios
        int min = -9;
        int max = 9;

        Random rand = new Random(semilla);

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas1; j++) {
                int numeroAleatorio = rand.nextInt(max - min + 1) + min;
                matriz1[i][j] = numeroAleatorio;
            }
        }
        
        for (int i = 0; i < filas2; i++) {
            for (int j = 0; j < columnas2; j++) {
                int numeroAleatorio = rand.nextInt(max - min + 1) + min;
                matriz2[i][j] = numeroAleatorio;
            }
        }

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas1; j++) {
                System.out.print(matriz1[i][j] + ",");
            }
            System.out.println("");
        }
        
        System.out.println("");
        for (int i = 0; i < filas2; i++) {
            for (int j = 0; j < columnas2; j++) {
                System.out.print(matriz2[i][j] + ",");
            }
            System.out.println("");
        }
        
//        int matrizResultado[][] = new int[objeto.getFilas()][objeto.getColumnas()];
//
//        matrizResultado = objeto.multiplicar(2, 4, 4, 3, matriz1, matriz2);
//
//        for (int i = 0; i < objeto.getFilas(); i++) {
//            for (int j = 0; j < objeto.getColumnas(); j++) {
//                System.out.print(matrizResultado[i][j] + ",");
//            }
//            System.out.println("");
//        }

    }

}
