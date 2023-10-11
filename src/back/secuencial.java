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
        
        matriz1 = objeto.multiplicar(filas1, columnas1, matriz1, filas2, columnas2, matriz2);
                
        for(int i = 0;i<filas;i++){
            for(int j = 0;j<columnas;j++){
                System.out.println(matriz[i][j]+",");
            }
        }
        
                
    }
    
}
