/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class Cliente extends java.rmi.server.UnicastRemoteObject implements InterfaceCliente{
    long semilla= 12345L;
    int filaInicio;
    int filaFinal;
    int cantidadFilas;
    InterfazRemota mir;
    concurrente objConcurrente = new concurrente();
    
    public Cliente ()throws RemoteException{}
    
    public Cliente(int filaInicio, int columnas, int filaFinal, int columnas2, int saltos, int hilos,InterfazRemota mir) throws RemoteException{
        super();
        objConcurrente.setInicio(filaInicio);
        objConcurrente.setFilaFinal(filaFinal);
        objConcurrente.setColumnas1(columnas);
        objConcurrente.setColumnas2(columnas);
        objConcurrente.setSaltos(saltos);
        objConcurrente.setCantidadHilos(hilos);
        this.mir = mir;
        mir.conectarCliente(this);
    }
    
    public String direccion() throws RemoteException{
        try {
            return ""+java.net.InetAddress.getLocalHost().getHostAddress().toString();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   

    public void generarMatrices() throws RemoteException{
        
    }
    
    public void multiplicar(){
        int matriz1[][] = leerMatrizDesdeArchivo("matriz1.txt");
        int matriz2[][] = leerMatrizDesdeArchivo("matriz2.txt");
        
        objConcurrente.setMatriz1(matriz1);
        objConcurrente.setMatriz2(matriz2);
        try {
            objConcurrente.correrHilos();
            System.out.println("a");
            mir.meterDatos(filaInicio,filaFinal, 0, objConcurrente.getMatrizResultado());
        } catch (Exception e) {
            System.out.println("Problema al correr hilos del cliente "+e);
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

    public static void main(String[] args) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        int filaInicio, filaFinal,cantidadColumnas,cantidadSaltos,cantidadHilos;
        System.out.println("Fila inicio");
        filaInicio = sc.nextInt();
        System.out.println("Fila final");
        filaFinal = sc.nextInt();
        System.out.println("Cantidad de columnas");
        cantidadColumnas = sc.nextInt();
        System.out.println("Cantidad de saltos");
        cantidadSaltos = sc.nextInt();
        System.out.println("Cantidad de hilos");
        cantidadHilos = sc.nextInt();
        try {
            Registry registry = LocateRegistry.createRegistry(
                    Integer.parseInt("9999"));
            InterfazRemota mir
                    = (InterfazRemota) Naming.lookup("//"
                            +"192.168.100.5:9999/Matrices");
            Cliente cliente = new Cliente(filaInicio,cantidadColumnas, filaFinal, cantidadColumnas, cantidadSaltos, cantidadHilos,mir);
            cliente.multiplicar();
            
            //mir.imprimirMatriz();
        } catch (Exception e) {
            System.out.println("Error al correr hilos del cliente"+e);
        }
        
        
    }
    
}
