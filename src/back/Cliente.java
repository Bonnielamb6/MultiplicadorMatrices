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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Cliente extends java.rmi.server.UnicastRemoteObject implements InterfaceCliente {

    long semilla = 12345L;
    int filaInicio;
    int filaFinal;
    int cantidadFilas;
    private InterfazRemota mir;
    concurrente objConcurrente;
    int matriz1[][];
    int matriz2[][];
    int saltos = 0;
    int hilos = 0;

    public Cliente() throws RemoteException {
    }

    public Cliente(InterfazRemota mir) throws RemoteException {
        this.mir = mir;
        this.mir.conectarCliente(this);

    }

    public String direccion() throws RemoteException {
        try {
            return "" + java.net.InetAddress.getLocalHost().getHostAddress().toString();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void generarMatrices() throws RemoteException {
        matriz1 = new int[cantidadFilas][cantidadFilas];
        matriz2 = new int[cantidadFilas][cantidadFilas];
        System.out.println("generando matrices");
        Random rand = new Random(semilla);

        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadFilas; j++) {
                int numeroAleatorio = rand.nextInt(9 - (-9) + 1) + (-9);
                matriz1[i][j] = numeroAleatorio;
            }
        }

        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadFilas; j++) {
                int numeroAleatorio = rand.nextInt(9 - (-9) + 1) + (-9);
                matriz2[i][j] = numeroAleatorio;
            }
        }
    }

    public void multiplicar() throws RemoteException {
        System.out.println("matriz 1");
        objConcurrente.setMatriz1(matriz1);
        System.out.println("matriz 2");
        objConcurrente.setMatriz2(matriz2);
        try {
            System.out.println("correr");
            objConcurrente.correrHilos();
            System.out.println("meterDatos");

            mir.meterDatos(objConcurrente.getInicio(), objConcurrente.getFilaFinal(), 0, objConcurrente.getMatrizResultado());
        } catch (Exception e) {
            System.out.println("Problema al correr hilos del cliente " + e);
        }
    }

    public void recibirDatos(int filaInicio, int filaFinal, int saltos, int hilos, int filas) throws RemoteException {
        this.filaInicio = filaInicio;
        this.filaFinal = filaFinal;
        this.saltos = saltos;
        this.hilos = hilos;
        cantidadFilas = filas;

        objConcurrente = new concurrente(cantidadFilas, cantidadFilas, cantidadFilas, cantidadFilas, saltos);
        objConcurrente.setInicio(filaInicio);
        objConcurrente.setFilaFinal(filaFinal);
        objConcurrente.setSaltos(saltos);
        objConcurrente.setCantidadHilos(hilos);
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

        try {
            Registry registry = LocateRegistry.createRegistry(
                    Integer.parseInt("1000"));
            InterfazRemota mir
                    = (InterfazRemota) Naming.lookup("//"
                            + "192.168.178.130:9999/Matrices");
            Cliente cliente = new Cliente(mir);
        } catch (Exception e) {
            System.out.println("Error al correr hilos del cliente" + e);
        }

    }

    public int devolverProgreso() throws RemoteException {
        return objConcurrente.getProgreso();
    }

    public long getSemilla() {
        return semilla;
    }

    public void setSemilla(long semilla) {
        this.semilla = semilla;
    }

    public int getFilaInicio() {
        return filaInicio;
    }

    public void setFilaInicio(int filaInicio) {
        this.filaInicio = filaInicio;
    }

    public int getFilaFinal() {
        return filaFinal;
    }

    public void setFilaFinal(int filaFinal) {
        this.filaFinal = filaFinal;
    }

    public int getCantidadFilas() {
        return cantidadFilas;
    }

    public void setCantidadFilas(int cantidadFilas) {
        this.cantidadFilas = cantidadFilas;
    }

    public InterfazRemota getMir() {
        return mir;
    }

    public void setMir(InterfazRemota mir) {
        this.mir = mir;
    }

    public concurrente getObjConcurrente() {
        return objConcurrente;
    }

    public void setObjConcurrente(concurrente objConcurrente) {
        this.objConcurrente = objConcurrente;
    }

}
