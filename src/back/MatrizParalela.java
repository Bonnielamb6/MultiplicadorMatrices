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
import java.util.List;

/**
 *
 * @author PC
 */
public class MatrizParalela extends UnicastRemoteObject implements
        InterfazRemota {
    private List<InterfaceCliente> clientes;
    private int filas;
    private int columnas;
    private int[][] matriz = new int[1000][1000];

    public MatrizParalela() throws RemoteException {
        filas = 0;
    }

    public MatrizParalela(int filas, int columnas, int[][] matriz) throws RemoteException {
        this.filas = filas;
        this.columnas = columnas;

    }

    public void conectarCliente(InterfaceCliente cliente) throws RemoteException{
        clientes.add(cliente);
    }
    
    public void inicializarMatriz() throws RemoteException {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                matriz[i][j] = 0;

            }
        }
    }

    public void meterDatos(int filaInicio, int filaFinal, int columna, int[][] dato) throws RemoteException {
        int iterador =0;
        for (int i = filaInicio; i < filaFinal; i++ ) {
            
            for (int j = 0; j < dato[0].length; j++) {
                matriz[i+iterador][columna + j] = dato[i][j];
                
            }
            
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

    public void correrProcesos(){
        
    }
    
}
