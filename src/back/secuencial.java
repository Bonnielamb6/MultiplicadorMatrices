/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package back;

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
        System.out.println("Cuanta cantidad de filas quieres que tenga la primer matriz?");
        filas1 = scanner.nextInt();
        System.out.println("\nCuanta cantidad de columnas quieres que tenga la primer matriz?");
        columnas1 = scanner.nextInt();
        int matriz1[][] = new int [filas1][columnas1];
        
        System.out.println("Cuanta cantidad de filas quieres que tenga la segunda matriz?");
        filas2 = scanner.nextInt();
        System.out.println("\nCuanta cantidad de columnas quieres que tenga la segunda matriz?");
        columnas2 = scanner.nextInt();
        
        int matriz2[][] = new int [filas2][columnas2];
        
        objeto.calcularFilasColumnas(filas1, columnas2);
        
        int matrizResultado [][] = new int [objeto.getFilas()][objeto.getColumnas()];
        
         matrizResultado = objeto.multiplicar( matriz1, matriz2);
                
        for(int i = 0;i<objeto.getFilas();i++){
            for(int j = 0;j<objeto.getColumnas();j++){
                System.out.println(matrizResultado[i][j]+",");
            }
        }
        
                
    }
    
}
