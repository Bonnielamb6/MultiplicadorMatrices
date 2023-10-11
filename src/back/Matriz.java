/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author PC
 */
public class Matriz {
    
    private int filas;
    private int columnas;
    
    
    public int[][] multiplicar( int [][]matrizMultiplicar1, int[][]matrizMultiplicar2){
        int matrizRetorno [][] = new int [filas][columnas];
        
        
        return matrizRetorno;
    }
    
    public void calcularFilasColumnas(int filas1, int columnas2){
        setFilas(filas1);
        setColumnas(columnas2);
    }
    
    

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    
    
}
