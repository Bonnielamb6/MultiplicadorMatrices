/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.rmi.Naming;
/**
 *
 * @author PC
 */
public class Cliente {
    

    
    int filaInicio;
    int filaFinal;
    int cantidadFilas;
    
    
    public void conectarConServidor(){
        concurrente objConcurrente = new concurrente(1000, 1000, 1000, 1000, 10);
        filaInicio = 500;
        filaFinal = 1000;
        int matriz1[][] = leerMatrizDesdeArchivo("matriz1.txt");
        int matriz2[][] = leerMatrizDesdeArchivo("matriz2.txt");
        
        objConcurrente.setMatriz1(matriz1);
        objConcurrente.setMatriz2(matriz2);
        
        objConcurrente.setCantidadHilos(2);
        objConcurrente.setSaltos(10);
        objConcurrente.setInicio(filaInicio);
        objConcurrente.setFilaFinal(filaFinal);
        
        
        
        try {
            
            objConcurrente.correrHilos();
            //imprimirMatriz(matriz1);
            //System.out.println("matriz2");
            //imprimirMatriz(matriz2);
            //System.out.println("resultado");
            //imprimirMatriz(objConcurrente.getMatrizResultado());
            //imprimirMatriz(objConcurrente.getMatrizResultado());
            Registry registry = LocateRegistry.createRegistry(
                    Integer.parseInt("9999"));

            

            InterfazRemota mir
                    = (InterfazRemota) Naming.lookup("//"
                            +"192.168.100.5:9999/Matrices");
            mir.inicializarMatriz();
            mir.meterDatos(filaInicio,filaFinal, 0, objConcurrente.getMatrizResultado());
            mir.imprimirMatriz();
        } catch (Exception e) {
            System.out.println("Error al correr hilos"+e);
        }
    }

    private static int[][] leerMatrizDesdeArchivo(String rutaArchivo) {
        int[][] matriz = null;

        try {
            File archivo = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivo);

            // Determinar el tamaño de la matriz (asumiendo que el archivo contiene filas y columnas en la primera línea)
            int filas = scanner.nextInt();
            int columnas = scanner.nextInt();
            matriz = new int[filas][columnas];

            // Leer los elementos de la matriz desde el archivo
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }

            // Cerrar el scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matriz;
    }

    // Método para imprimir una matriz (solo para verificar)
    private static void imprimirMatriz(int[][] matriz) {
        if (matriz != null) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.conectarConServidor();
    }
    
}
