/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author PC
 */
public class MatrizConcurrente {

    private int filas;
    private int columnas;
    private int [][] matriz;
            
    public void calcularFilasColumnas(int filas1, int columnas2) {
        setFilas(filas1);
        setColumnas(columnas2);
        matriz = new int [filas1][columnas2];
    }
    
    public synchronized void meterDatos (int fila, int columna, int[][] dato){
        
        for(int i  = 0;i<dato.length;i++){
            for(int j = 0;j<dato[0].length;j++){
                matriz[fila+i][columna+j] = dato[fila+i][columna+j];
            }
        }
        
        
    }
    
    public int [] [] recibirMatriz(){
        return matriz;
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
