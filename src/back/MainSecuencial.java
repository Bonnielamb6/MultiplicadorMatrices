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
public class MainSecuencial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        secuencial objetoSecuencial = new secuencial();
        //int temp;
        Scanner scanner = new Scanner(System.in);
        //PARA IMPLEMENTAR DESPUES CON DINAMISMO

        
        //--------------NO PONER MATRICES MAS GRANDES QUE 1500 X 1500, EN SERIO...--------------
        System.out.println("Cuanta cantidad de filas quieres que tenga la primer matriz?");
        objetoSecuencial.setFilas1(scanner.nextInt());
        
        System.out.println("\nCuanta cantidad de columnas quieres que tenga la primer matriz?");
        objetoSecuencial.setColumnas1(scanner.nextInt());
        

        System.out.println("Cuanta cantidad de filas quieres que tenga la segunda matriz?");
        objetoSecuencial.setFilas2(scanner.nextInt()); 
        System.out.println("\nCuanta cantidad de columnas quieres que tenga la segunda matriz?");
        objetoSecuencial.setColumnas2(scanner.nextInt());

        
        objetoSecuencial.inicializar();
        objetoSecuencial.correr();
        

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
//                
//        for (int i = 0; i < filas2; i++) {
//            for (int j = 0; j < columnas2; j++) {
//                System.out.print(matriz2[i][j] + ",");
//            }
//            System.out.println("");
//        }

        

        

        for (int i = 0; i < objetoSecuencial.filas1; i++) {
            for (int j = 0; j < objetoSecuencial.columnas2; j++) {
                System.out.print(objetoSecuencial.matrizResultado[i][j] + ",");
            }
            System.out.println("");
        }

    }
    
}
