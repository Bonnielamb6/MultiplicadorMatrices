/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author PC
 */
public class MatrizSecuencial {
    
    private int filas;
    private int columnas;
    
    
    public int[][] multiplicar(int filas1, int columnas1, int filas2,int columnas2, int [][]matrizMultiplicar1, int[][]matrizMultiplicar2){
        int matrizRetorno [][] = new int [filas][columnas];
        int temp =0;
        for(int i = 0;i<filas1;i++){
            for(int j = 0;j<columnas2;j++ ){
                for(int recorrer = 0;recorrer<columnas1;recorrer++){
                    temp+=matrizMultiplicar1[i][recorrer] * matrizMultiplicar2[recorrer][j];
                }
                
                matrizRetorno[i][j]=temp;
                temp =0;
            }
            
        }
        
        return matrizRetorno;
    }
    
    public void calcularFilasColumnas(int filas1, int columnas2) {
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
