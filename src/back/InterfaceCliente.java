/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package back;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author PC
 */
public interface InterfaceCliente extends Remote{
    public String direccion() throws RemoteException;
    public void generarMatrices() throws RemoteException;
    public void recibirDatos(int filaInicio,int filaFinal, int saltos, int hilos,int filas) throws RemoteException;
    public void multiplicar()throws RemoteException;
    public int devolverProgreso() throws RemoteException;
}
