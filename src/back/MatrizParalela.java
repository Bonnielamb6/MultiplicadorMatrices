/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author PC
 */
public class MatrizParalela extends UnicastRemoteObject implements
        InterfazRemota {

    private List<InterfaceCliente> clientes = new ArrayList<>();
    private int filas;
    private int columnas;
    private int[][] matriz = new int[1000][1000];
    private int[][] matriz1;
    private int[][] matriz2;
    private long semilla = 12345L;
    private long tiempoEjecucion = 0;
    private int terminados =0;
    concurrente objConcurrente;

    public MatrizParalela() throws RemoteException {
        filas = 0;
    }

    public MatrizParalela(int filas, int columnas, int[][] matriz, int saltos, int hilos) throws RemoteException {
        this.filas = filas;
        this.columnas = columnas;
        matriz1 = new int[filas][columnas];
        matriz2 = new int[filas][columnas];
        objConcurrente = new concurrente(filas, columnas, filas, columnas, saltos);
        objConcurrente.setInicio(0);
        //objConcurrente.setFilaFinal(filaFinal);
        objConcurrente.setSaltos(saltos);
        objConcurrente.setCantidadHilos(hilos);

    }

    public void conectarCliente(InterfaceCliente cliente) throws RemoteException {
        clientes.add(cliente);
        System.out.println("Cliente conectado");
    }

    public void inicializarMatriz() throws RemoteException {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                matriz[i][j] = 0;

            }
        }
    }

    public void meterDatos(int filaInicio, int filaFinal, int columna, int[][] dato) throws RemoteException {
        terminados++;
        int iterador = 0;
        for (int i = filaInicio; i < filaFinal; i++) {
            for (int j = 0; j < dato[0].length; j++) {
                matriz[i + iterador][columna + j] = dato[i][j];
            }
        }
        if(terminados == clientes.size()+1){
            imprimirMatriz();
        }
    }

    public void imprimirMatriz() throws RemoteException {
        if (matriz != null) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public void dividirChamba() throws RemoteException {
        int filasCliente = filas / (clientes.size()+1);
        int residuo = filas % clientes.size();
        int filasActual = filasCliente + residuo;
        objConcurrente.setFilaFinal(filasActual);
        System.out.println(filas);
        System.out.println(filasActual);
        System.out.println(filasCliente);
        System.out.println(clientes.size());
        for (InterfaceCliente cliente : clientes) {
            cliente.recibirDatos(filasActual, filasActual + filasCliente, 10, 4,filas);
            filasActual += filasCliente;
        }
    }

    public void multiplicarServidor() {
        objConcurrente.setMatriz1(matriz1);
        objConcurrente.setMatriz2(matriz2);
        try {
            objConcurrente.correrHilos();
            System.out.println("a");
            meterDatos(objConcurrente.getInicio(), objConcurrente.getFilaFinal(), 0, objConcurrente.getMatrizResultado());
        } catch (Exception e) {
            System.out.println("Problema al correr hilos del cliente " + e);
        }
    }

    public void generarMatrizIndividual() {
        Random rand = new Random(semilla);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int numeroAleatorio = rand.nextInt(9 - -9 + 1) + -9;
                matriz1[i][j] = numeroAleatorio;
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int numeroAleatorio = rand.nextInt(9 - -9 + 1) + -9;
                matriz2[i][j] = numeroAleatorio;
            }
        }
    }

    public void generarMatricesClientes() throws RemoteException{
        for (InterfaceCliente cliente : clientes) {
            cliente.generarMatrices();
        }
        
    }
    
    public void generarMatrices () throws RemoteException{
        generarMatricesClientes();
        generarMatrizIndividual();
    }
    
    public void correrProcesos() throws RemoteException {
        System.out.println("c1");
        for (InterfaceCliente cliente : clientes) {
            System.out.println("c11");
            cliente.multiplicar();
            System.out.println("c12");
        }
        System.out.println("c2");
        multiplicarServidor();
        System.out.println("c3");
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

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public long getSemilla() {
        return semilla;
    }

    public void setSemilla(long semilla) {
        this.semilla = semilla;
    }

}
