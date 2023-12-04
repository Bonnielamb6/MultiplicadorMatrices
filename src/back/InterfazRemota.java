/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package back;

import back.InterfaceCliente;
import java.awt.TextArea;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author PC
 */
public interface InterfazRemota extends Remote {

    public void meterDatos(int filaInicio, int filaFinal, int columna, int[][] dato) throws RemoteException;

    public void inicializarMatriz() throws RemoteException;

    public void imprimirMatriz() throws RemoteException;

    public void conectarCliente(InterfaceCliente cliente) throws RemoteException;

    public void dividirChamba() throws RemoteException;

    public void generarMatrices() throws RemoteException;

    public void correrProcesos() throws RemoteException;

    public void setColumnas(int columnas) throws RemoteException;

    public void setFilas(int filas) throws RemoteException;

    public void setHilos(int hilos) throws RemoteException;

    public void setSaltos(int saltos) throws RemoteException;

    public long getTiempoEjecucion() throws RemoteException;
    
    public List<InterfaceCliente> getClientes() throws RemoteException;
    
    public void lista(JList lista) throws RemoteException;
    
    public void proceso(JTextArea procesos) throws RemoteException;
}
