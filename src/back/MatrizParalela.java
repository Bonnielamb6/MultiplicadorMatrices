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
/**
 *
 * @author PC
 */
public class MatrizParalela extends UnicastRemoteObject implements 
        InterfazRemota{
    private int filas;
    private int columnas;
    private int [][] matriz;

    public MatrizParalela() throws RemoteException{
        filas =0;
    }

    public MatrizParalela(int filas, int columnas, int[][] matriz) throws RemoteException{
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = matriz;
    }
    
    
    
    public void meterDatos (int fila, int columna, int[][] dato) throws RemoteException{
        for(int i  = 0;i<dato.length;i++){
            for(int j = 0;j<dato[0].length;j++){
                matriz[fila+i][columna+j] = dato[i][j];
                
            }   
        }    
    }
    
}
