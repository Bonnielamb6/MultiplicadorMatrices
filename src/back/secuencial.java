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
    MatrizSecuencial objeto = new MatrizSecuencial();
        int filas1;
        int columnas1;
        int filas2;
        int columnas2;
        int matriz1[][];
        int matriz2[][];
        int matrizResultado[][];
        long semilla = 12345L; 
        int min = -9;
        int max = 9;

    public secuencial() {
        filas1 = 0;
        filas2 = 0;
        columnas1 = 0;
        columnas2 = 0;
    }
        
        
        
    public secuencial(int filas1, int columnas1, int filas2, int columnas2) {
        this.filas1 = filas1;
        this.columnas1 = columnas1;
        this.filas2 = filas2;
        this.columnas2 = columnas2;
    }
        
        
    public void inicializar(){
        matriz1 = new int[filas1][columnas1];
        matriz2 = new int [filas2][columnas2];
        
        objeto.calcularFilasColumnas(filas1, columnas2);
        
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
    
    public void correr(){
        matrizResultado = objeto.multiplicar(filas1, columnas1, filas2, columnas2, matriz1, matriz2);
    }

    public void setFilas1(int filas1) {
        this.filas1 = filas1;
    }

    public void setColumnas1(int columnas1) {
        this.columnas1 = columnas1;
    }

    public void setFilas2(int filas2) {
        this.filas2 = filas2;
    }

    public void setColumnas2(int columnas2) {
        this.columnas2 = columnas2;
    }

    public void setSemilla(long semilla) {
        this.semilla = semilla;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public MatrizSecuencial getObjeto() {
        return objeto;
    }

    public int getColumnas1() {
        return columnas1;
    }

    public int getFilas2() {
        return filas2;
    }

    public int getColumnas2() {
        return columnas2;
    }

    public int[][] getMatriz1() {
        return matriz1;
    }

    public int[][] getMatriz2() {
        return matriz2;
    }

    public int[][] getMatrizResultado() {
        return matrizResultado;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
    
    
    

}
