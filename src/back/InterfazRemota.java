/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package back;
import back.InterfaceCliente;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author PC
 */
public interface InterfazRemota extends Remote{
    public void meterDatos (int filaInicio,int filaFinal, int columna, int[][] dato) throws RemoteException;
    public void inicializarMatriz() throws RemoteException;
    public void imprimirMatriz() throws RemoteException;
    public void conectarCliente(InterfaceCliente cliente) throws RemoteException;
}
