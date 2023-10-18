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
    
    public concurrente (){
        filas1 = 0;
        filas2 = 0;
        columnas1 = 0;
        columnas2 = 0;
        saltos = 0;
    }
    
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

    public int getFilas1() {
        return filas1;
    }

    public void setFilas1(int filas1) {
        this.filas1 = filas1;
    }

    public int getColumnas1() {
        return columnas1;
    }

    public void setColumnas1(int columnas1) {
        this.columnas1 = columnas1;
    }

    public int getFilas2() {
        return filas2;
    }

    public void setFilas2(int filas2) {
        this.filas2 = filas2;
    }

    public int getColumnas2() {
        return columnas2;
    }

    public void setColumnas2(int columnas2) {
        this.columnas2 = columnas2;
    }

    public int getSaltos() {
        return saltos;
    }

    public void setSaltos(int saltos) {
        this.saltos = saltos;
    }

    public long getSemilla() {
        return semilla;
    }

    public void setSemilla(long semilla) {
        this.semilla = semilla;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    
    
}
