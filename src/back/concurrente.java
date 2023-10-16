/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author PC
 */
public class concurrente {

    MatrizConcurrente objeto = new MatrizConcurrente();
    int filas1;
    int columnas1;
    int filas2;
    int columnas2;
    int saltos;
    long semilla = 12345L;
    int min = -9;
    int max = 9;
    int matriz1[][];
    int matriz2[][];
    int matrizResultado[][];
    public concurrente(int filas1, int columnas1, int filas2, int columnas2, int saltos) {
        this.filas1 = filas1;
        this.columnas1 = columnas1;
        this.filas2 = filas2;
        this.columnas2 = columnas2;
        this.saltos = saltos;
    }

    public void inicializar() {
        matriz1 = new int[filas2][columnas2];
        matriz2 = new int[filas2][columnas2];
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
    }
    
    public void correrHilos() throws InterruptedException{
    ExecutorService executor = Executors.newFixedThreadPool(8);

        objeto.calcularFilasColumnas(filas1, columnas2);

        
        //columnasTemp = conseguirColumnas(matriz2, matriz2.);
        for (int i = 0; i < filas1;) {
            for (int j = 0; j < columnas2;) {
                int[][] filasTemp;

                int sizeFilas = saltos;
                int sizeColumnas = saltos;
                if (j + saltos > columnas2) {
                    sizeColumnas = columnas2 - j;
                }
                if (i + saltos > filas1) {
                    sizeFilas = filas1 - i;
                }

                filasTemp = conseguirFilas(matriz1, i, sizeFilas, columnas1);


                HilosMultiplicar hilo = new HilosMultiplicar(filasTemp, matriz2, i, objeto);
                
                executor.execute(hilo);
                j += saltos;
                i += saltos;
            }

        }
        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.MINUTES);
        matrizResultado = objeto.recibirMatriz();
    }

    //public static void main(String[] args) throws InterruptedException {

        //Scanner scanner = new Scanner(System.in);

        //PARA IMPLEMENTAR DESPUES CON DINAMISMO
        //--------------NO PONER MATRICES MAS GRANDES QUE 1500 X 1500, EN SERIO... (ahora si ya se puede :b)--------------
        //esto es para el main
//        System.out.println("Cuanta cantidad de filas quieres que tenga la primer matriz?");
//        filas1 = scanner.nextInt();
//        System.out.println("\nCuanta cantidad de columnas quieres que tenga la primer matriz?");
//        columnas1 = scanner.nextInt();
//        int matriz1[][] = new int[filas1][columnas1];
//
//        System.out.println("Cuanta cantidad de filas quieres que tenga la segunda matriz?");
//        filas2 = scanner.nextInt();
//        System.out.println("\nCuanta cantidad de columnas quieres que tenga la segunda matriz?");
//        columnas2 = scanner.nextInt();
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
        //MOSTRAR LAS MATRICES CREADAS ------ NO RECOMENDABLE DESPUES DE UNA MATRIZ DE 100 X 100, EN SERIO... -------------------
//        for (int i = 0; i < filas1; i++) {
//            for (int j = 0; j < columnas1; j++) {
//                System.out.print(matriz1[i][j] + ",");
//            }
//            System.out.println("");
//        }
//        
//        System.out.println("");
//        for (int i = 0; i < filas2; i++) {
//            for (int j = 0; j < columnas2; j++) {
//                System.out.print(matriz2[i][j] + ",");
//            }
//            System.out.println("");
//        }
        //System.out.println("Calculando");

        
        //System.out.println("");
        //int matrizResultado[][] = new int[objeto.getFilas()][objeto.getColumnas()];

        

        //System.out.println(""+matrizResultado[0][0]);
        //SLEEP SUMAMENTE IMPORTANTE PARA QUE NO SE COMA NUMEROS PONIENDOLOS COMO 0s
        //Thread.sleep(10000);
//        for (int i = 0; i < objeto.getFilas(); i++) {
//            for (int j = 0; j < objeto.getColumnas(); j++) {
//                System.out.print(matrizResultado[i][j] + ",");
//            }
//            System.out.println("");
//        }

//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        for (int i = 0; i < objeto.getFilas(); i++) {
//            for (int j = 0; j < objeto.getColumnas(); j++) {
//                System.out.print(matrizResultado[i][j] + ",");
//            }
//            System.out.println("");
//        }
    //}

    //HACERLOS 10 X N MEJOR, PARA QUE NO SE SEPAREN LAS MATRICES
    public static int[][] conseguirFilas(int[][] matrizTemp, int posicionFila, int sizeFilas, int sizeColumnas) {
        int[][] arreglo = new int[sizeFilas][sizeColumnas];

        for (int i = 0; i < sizeFilas; i++) {
            for (int j = 0; j < sizeColumnas; j++) {
                arreglo[i][j] = matrizTemp[posicionFila + i][j];
            }
        }

        return arreglo;
    }

    public static int[][] conseguirColumnas(int[][] matrizTemp, int posicionColumna, int sizeColumnas, int sizeFilas) {
        int[][] arreglo = new int[sizeColumnas][sizeFilas];

        for (int i = 0; i < sizeColumnas; i++) {
            for (int j = 0; j < sizeFilas; j++) {
                arreglo[j][i] = matrizTemp[j][posicionColumna + i];
            }
        }

        return arreglo;
    }

}
