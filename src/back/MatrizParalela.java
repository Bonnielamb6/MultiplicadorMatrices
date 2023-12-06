/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import front.InterfazMatrices;
import java.awt.TextArea;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC
 */
public class MatrizParalela extends UnicastRemoteObject implements
        InterfazRemota {

    private List<InterfaceCliente> clientes = new ArrayList<>();
    private int filas;
    private int columnas;
    private int[][] matriz;
    private int[][] matriz1;
    private int[][] matriz2;
    private int hilos;
    private int saltos;
    private long semilla = 12345L;
    private long tiempoEjecucion = 0;
    private int terminados = 0;
    concurrente objConcurrente;
    File archivoParalelo;
    private JList lista;
    private JTextArea procesos;

    public MatrizParalela() throws RemoteException {
        filas = 0;
    }

    public MatrizParalela(int filas, int columnas, int[][] matriz, int saltos, int hilos) throws RemoteException {
        this.filas = filas;
        this.columnas = columnas;

        objConcurrente = new concurrente(filas, columnas, filas, columnas, saltos);
        this.saltos = saltos;
        this.hilos = hilos;
        //objConcurrente.setFilaFinal(filaFinal);

    }

    public void conectarCliente(InterfaceCliente cliente) throws RemoteException {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.direccion() + " conectado");
        SwingUtilities.invokeLater(() -> {
            DefaultListModel<String> listModel = new DefaultListModel<>();

            for (InterfaceCliente usuario : clientes) {
                try {
                    listModel.addElement(usuario.direccion());
                } catch (RemoteException ex) {
                    ex.getMessage();
                }
            }

            lista.setModel(listModel);
        });
    }

    public void inicializarMatriz() throws RemoteException {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
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
        
    }

    public void imprimirMatriz() throws RemoteException {
        if (matriz != null) {
            System.out.println("imprimir matriz");
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public void dividirChamba() throws RemoteException {

        int filasCliente = filas / (clientes.size() + 1);
        int residuo = filas % clientes.size();
        int filasActual = filasCliente + residuo;
        objConcurrente.setFilas1(filas);
        objConcurrente.setFilas2(filas);
        objConcurrente.setColumnas1(columnas);
        objConcurrente.setColumnas1(columnas);
        objConcurrente.setInicio(0);
        objConcurrente.setFilaFinal(filasActual);
        objConcurrente.setSaltos(saltos);
        objConcurrente.setCantidadHilos(hilos);

        matriz = new int[filas][columnas];
        inicializarMatriz();
        System.out.println(filas);
        System.out.println(filasActual);
        System.out.println(filasCliente);
        System.out.println(clientes.size());
        for (InterfaceCliente cliente : clientes) {
            cliente.recibirDatos(filasActual, filasActual + filasCliente, saltos, hilos, filas);
            filasActual += filasCliente;
        }
    }

    public void multiplicarServidor() {
        objConcurrente.setMatriz1(matriz1);
        objConcurrente.setMatriz2(matriz2);
        objConcurrente.setCantidadHilos(hilos);
        objConcurrente.setColumnas1(columnas);
        objConcurrente.setColumnas2(columnas);
        objConcurrente.setFilas1(filas);
        objConcurrente.setFilas2(filas);
        objConcurrente.setSaltos(saltos);
        try {
            objConcurrente.correrHilos();
            System.out.println("Meter datos servidor");
            meterDatos(objConcurrente.getInicio(), objConcurrente.getFilaFinal(), 0, objConcurrente.getMatrizResultado());
        } catch (Exception e) {
            System.out.println("Problema al correr hilos del servidor " + e);
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

    public void generarMatricesClientes() throws RemoteException {
        for (InterfaceCliente cliente : clientes) {
            cliente.generarMatrices();
        }

    }

    public void generarMatrices() throws RemoteException {
        matriz1 = new int[filas][columnas];
        matriz2 = new int[filas][columnas];
        generarMatricesClientes();
        generarMatrizIndividual();
    }

    public void correrProcesos() throws RemoteException {
        long startTime = System.currentTimeMillis();
        final int[] progresoTotal = {0};
        procesos.setText("");
        try {
            System.out.println("c1");
            List<Future<Void>> futures = new ArrayList<>();
            ExecutorService executor = Executors.newFixedThreadPool(clientes.size() + 1);

            // Utiliza un array de un solo elemento para almacenar el progresoTotal mutable
            for (InterfaceCliente cliente : clientes) {
                System.out.println("c11");

                Callable<Void> task = () -> {
                    cliente.multiplicar();

                    // Incrementa el progreso parcial del cliente
                    int progresoParcial = cliente.devolverProgreso();

                    // Actualiza la interfaz gráfica durante la ejecución del hilo
                    SwingUtilities.invokeLater(() -> {
                        procesos.append("Proceso del cliente terminado: "  + "\n");
                    });

                    // Incrementa el progresoTotal usando el array de un solo elemento
                    progresoTotal[0] += progresoParcial;

                    return null;
                };

                futures.add(executor.submit(task));
                System.out.println("c12");
            }

            Callable<Void> task = () -> {
                multiplicarServidor();

                // Incrementa el progreso parcial del servidor
                int progresoParcial = objConcurrente.getProgreso();

                // Actualiza la interfaz gráfica durante la ejecución del hilo
                SwingUtilities.invokeLater(() -> {
                    procesos.append("Proceso del servidor terminado: "  + "\n");
                });

                // Incrementa el progresoTotal usando el array de un solo elemento
                progresoTotal[0] += progresoParcial;

                return null;
            };

            futures.add(executor.submit(task));

            // Espera a que todos los hilos terminen
            for (Future<Void> future : futures) {
                future.get();
            }

            // Apagar el ExecutorService
            executor.shutdown();

            long endTime = System.currentTimeMillis();
            tiempoEjecucion = endTime - startTime;

        } catch (Exception e) {
            System.out.println("Error al querer correr los procesos: " + e);
        }

        SwingUtilities.invokeLater(() -> {
            JTextArea txtArea = new JTextArea();
            txtArea.append("Todos los procesos terminados: " +"\n");
            System.out.println(progresoTotal[0]);
            txtArea.append("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos\n");
            procesos.append(txtArea.getText());

        });

        try {
            archivoParalelo = new File("archivoParalelo.txt");
            escribirArchivo(archivoParalelo, matriz1, matriz2, matriz);
            if (archivoParalelo.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Archivo creado");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear archivo");
            Logger.getLogger(InterfazMatrices.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("c2");
    }

    private void escribirArchivo(File archivoTemp, int[][] matriz1Temp, int[][] matriz2Temp, int[][] matrizResultadoTemp) {
        try {
            FileWriter escritura = new FileWriter(archivoTemp);
            escritura.write("Matriz 1\n");

            for (int i = 0; i < matriz1Temp.length; i++) {
                escritura.write("[");
                for (int j = 0; j < matriz1Temp[0].length; j++) {
                    escritura.write("" + matriz1Temp[i][j] + ",");

                }
                escritura.write("]\n");

            }
            escritura.write("\n\n\n\n");

            escritura.write("Matriz 2\n");

            for (int i = 0; i < matriz2Temp.length; i++) {
                escritura.write("[");
                for (int j = 0; j < matriz2Temp[0].length; j++) {
                    escritura.write("" + matriz2Temp[i][j] + ",");

                }
                escritura.write("]\n");

            }
            escritura.write("\n\n\n\n");

            escritura.write("Matriz resultante\n");

            for (int i = 0; i < matrizResultadoTemp.length; i++) {
                escritura.write("[");
                for (int j = 0; j < matrizResultadoTemp[0].length; j++) {
                    escritura.write("" + matrizResultadoTemp[i][j] + ",");

                }
                escritura.write("]\n");

            }
            escritura.write("\n\n\n\n");

            escritura.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al escribir el archivo" + e);
        }

    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) throws RemoteException {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) throws RemoteException {
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

    public int getHilos() {
        return hilos;
    }

    public void setHilos(int hilos) throws RemoteException {
        this.hilos = hilos;
    }

    public int getSaltos() {
        return saltos;
    }

    public void setSaltos(int saltos) throws RemoteException {
        this.saltos = saltos;
    }

    public long getTiempoEjecucion() throws RemoteException {
        return tiempoEjecucion;
    }

    public List<InterfaceCliente> getClientes() throws RemoteException {
        return clientes;
    }

    public void lista(JList lista) throws RemoteException {
        this.lista = lista;
    }

    public void proceso(JTextArea procesos) throws RemoteException {
        this.procesos = procesos;
    }
}
