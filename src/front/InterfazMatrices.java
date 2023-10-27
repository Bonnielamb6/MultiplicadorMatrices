/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package front;

import java.awt.Color;
import back.concurrente;
import back.secuencial;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class InterfazMatrices extends javax.swing.JFrame {

    secuencial objetoSecuencial = new secuencial();
    concurrente objetoConcurrente = new concurrente();

    long semilla = 12345L;

    int matriz1[][];
    int matriz2[][];
    int min = -9;
    int max = 9;
    double tiempoMilisegundosSecuencial = 0;
    double tiempoSegundosSecuencial = 0;
    double tiempoMinutosSecuencial = 0;

    double tiempoMilisegundosConcurrente = 0;
    double tiempoSegundosConcurrente = 0;
    double tiempoMinutosConcurrente = 0;
    int estadoTiempos = 0;

    File archivoSecuencial;
    File archivoConcurrente;

    int matrizResultadoSecuencial[][];
    int matrizResultadoConcurrente[][];

    /**
     *
     * Creates new form InterfazMatrices
     */
    public InterfazMatrices() {

        initComponents();
        spnMax.setValue(9);
        spnMin.setValue(-9);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtFilas1 = new javax.swing.JTextField();
        txtColumnas1 = new javax.swing.JTextField();
        lblFilas1 = new javax.swing.JLabel();
        lblColumnas1 = new javax.swing.JLabel();
        lblFilas2 = new javax.swing.JLabel();
        txtFilas2 = new javax.swing.JTextField();
        lblColumnas2 = new javax.swing.JLabel();
        txtColumnas2 = new javax.swing.JTextField();
        btnSecuencial = new javax.swing.JButton();
        btnConcurrente = new javax.swing.JButton();
        txtSaltos = new javax.swing.JTextField();
        lblSaltos = new javax.swing.JLabel();
        lblHilos = new javax.swing.JLabel();
        txtHilos = new javax.swing.JTextField();
        lblTiempoSecuencial = new javax.swing.JLabel();
        lblTiempoConcurrente = new javax.swing.JLabel();
        btnGenerarMatrices = new javax.swing.JButton();
        spnMax = new javax.swing.JSpinner();
        spnMin = new javax.swing.JSpinner();
        lblMax = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblTextoConcurrente = new javax.swing.JLabel();
        lblTextoSecuencial = new javax.swing.JLabel();
        btnCambiarTiempo = new javax.swing.JButton();
        lblProgresoConcurrente = new javax.swing.JLabel();
        lblProgresoSecuencial = new javax.swing.JLabel();
        lblSecuencialEstado = new javax.swing.JLabel();
        lblConcurrenteEstado = new javax.swing.JLabel();
        ImagenFondo = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setBackground(new java.awt.Color(153, 153, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("MULTIPLICADOR DE MATRICES");
        lblTitulo.setFocusable(false);
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTitulo.setOpaque(true);
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 41));

        txtFilas1.setBackground(new java.awt.Color(51, 102, 255));
        txtFilas1.setForeground(new java.awt.Color(255, 255, 255));
        txtFilas1.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(txtFilas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        txtColumnas1.setBackground(new java.awt.Color(51, 102, 255));
        txtColumnas1.setForeground(new java.awt.Color(255, 255, 255));
        txtColumnas1.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(txtColumnas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        lblFilas1.setBackground(new java.awt.Color(0, 204, 153));
        lblFilas1.setForeground(new java.awt.Color(0, 0, 0));
        lblFilas1.setText("Cantidad de filas de matriz 1");
        lblFilas1.setOpaque(true);
        jPanel1.add(lblFilas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        lblColumnas1.setBackground(new java.awt.Color(0, 204, 153));
        lblColumnas1.setForeground(new java.awt.Color(0, 0, 0));
        lblColumnas1.setText("Cantidad de columnas de matriz 1");
        lblColumnas1.setOpaque(true);
        jPanel1.add(lblColumnas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        lblFilas2.setBackground(new java.awt.Color(0, 204, 153));
        lblFilas2.setForeground(new java.awt.Color(0, 0, 0));
        lblFilas2.setText("Cantidad de filas matriz 2");
        lblFilas2.setOpaque(true);
        jPanel1.add(lblFilas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        txtFilas2.setBackground(new java.awt.Color(51, 102, 255));
        txtFilas2.setForeground(new java.awt.Color(255, 255, 255));
        txtFilas2.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(txtFilas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        lblColumnas2.setBackground(new java.awt.Color(0, 204, 153));
        lblColumnas2.setForeground(new java.awt.Color(0, 0, 0));
        lblColumnas2.setText("Cantidad de columnas matriz 2");
        lblColumnas2.setOpaque(true);
        jPanel1.add(lblColumnas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        txtColumnas2.setBackground(new java.awt.Color(51, 102, 255));
        txtColumnas2.setForeground(new java.awt.Color(255, 255, 255));
        txtColumnas2.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(txtColumnas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        btnSecuencial.setBackground(new java.awt.Color(0, 255, 51));
        btnSecuencial.setForeground(new java.awt.Color(0, 0, 0));
        btnSecuencial.setText("Secuencial");
        btnSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecuencialActionPerformed(evt);
            }
        });
        jPanel1.add(btnSecuencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 130, 40));

        btnConcurrente.setBackground(new java.awt.Color(0, 255, 0));
        btnConcurrente.setForeground(new java.awt.Color(0, 0, 0));
        btnConcurrente.setText("Concurrente");
        btnConcurrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcurrenteActionPerformed(evt);
            }
        });
        jPanel1.add(btnConcurrente, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 320, 130, 40));

        txtSaltos.setBackground(new java.awt.Color(51, 102, 255));
        txtSaltos.setForeground(new java.awt.Color(255, 255, 255));
        txtSaltos.setMinimumSize(new java.awt.Dimension(100, 22));
        txtSaltos.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(txtSaltos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 150, -1, -1));

        lblSaltos.setBackground(new java.awt.Color(0, 204, 153));
        lblSaltos.setForeground(new java.awt.Color(0, 0, 0));
        lblSaltos.setText("De a cuanto quieres que sean los saltos de cada hilo?");
        lblSaltos.setOpaque(true);
        jPanel1.add(lblSaltos, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, -1, -1));

        lblHilos.setBackground(new java.awt.Color(0, 204, 153));
        lblHilos.setForeground(new java.awt.Color(0, 0, 0));
        lblHilos.setText("Cuantos hilos quieres  que esten corriendo?");
        lblHilos.setOpaque(true);
        jPanel1.add(lblHilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 210, -1, -1));

        txtHilos.setBackground(new java.awt.Color(51, 102, 255));
        txtHilos.setForeground(new java.awt.Color(255, 255, 255));
        txtHilos.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(txtHilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 260, -1, -1));

        lblTiempoSecuencial.setBackground(new java.awt.Color(255, 153, 153));
        lblTiempoSecuencial.setForeground(new java.awt.Color(0, 0, 0));
        lblTiempoSecuencial.setText("0");
        lblTiempoSecuencial.setOpaque(true);
        jPanel1.add(lblTiempoSecuencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        lblTiempoConcurrente.setBackground(new java.awt.Color(255, 153, 153));
        lblTiempoConcurrente.setForeground(new java.awt.Color(0, 0, 0));
        lblTiempoConcurrente.setText("0");
        lblTiempoConcurrente.setOpaque(true);
        jPanel1.add(lblTiempoConcurrente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 430, -1, -1));

        btnGenerarMatrices.setBackground(new java.awt.Color(255, 153, 153));
        btnGenerarMatrices.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarMatrices.setText("Generar Matrices");
        btnGenerarMatrices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarMatricesActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarMatrices, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 150, 40));

        spnMax.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(spnMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        spnMin.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(spnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblMax.setBackground(new java.awt.Color(0, 204, 153));
        lblMax.setForeground(new java.awt.Color(0, 0, 0));
        lblMax.setText("Numero maximo en matriz");
        lblMax.setOpaque(true);
        jPanel1.add(lblMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lblMin.setBackground(new java.awt.Color(0, 204, 153));
        lblMin.setForeground(new java.awt.Color(0, 0, 0));
        lblMin.setText("Numero minimo en matriz");
        lblMin.setOpaque(true);
        jPanel1.add(lblMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lblTextoConcurrente.setBackground(new java.awt.Color(0, 255, 0));
        lblTextoConcurrente.setForeground(new java.awt.Color(0, 0, 0));
        lblTextoConcurrente.setText("Tiempo en milisegundos");
        lblTextoConcurrente.setOpaque(true);
        jPanel1.add(lblTextoConcurrente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 410, -1, -1));

        lblTextoSecuencial.setBackground(new java.awt.Color(51, 255, 51));
        lblTextoSecuencial.setForeground(new java.awt.Color(0, 0, 0));
        lblTextoSecuencial.setText("Tiempo en milisegundos");
        lblTextoSecuencial.setOpaque(true);
        jPanel1.add(lblTextoSecuencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        btnCambiarTiempo.setBackground(new java.awt.Color(0, 0, 255));
        btnCambiarTiempo.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarTiempo.setText("Cambiar unidades de tiempo");
        btnCambiarTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTiempoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 190, 40));

        lblProgresoConcurrente.setBackground(new java.awt.Color(51, 255, 51));
        lblProgresoConcurrente.setForeground(new java.awt.Color(0, 0, 0));
        lblProgresoConcurrente.setText("Listo");
        lblProgresoConcurrente.setOpaque(true);
        jPanel1.add(lblProgresoConcurrente, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, -1, -1));

        lblProgresoSecuencial.setBackground(new java.awt.Color(0, 255, 51));
        lblProgresoSecuencial.setForeground(new java.awt.Color(0, 0, 0));
        lblProgresoSecuencial.setText("Listo");
        lblProgresoSecuencial.setOpaque(true);
        jPanel1.add(lblProgresoSecuencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        lblSecuencialEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mikuEsperando.gif"))); // NOI18N
        jPanel1.add(lblSecuencialEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 130, 110));

        lblConcurrenteEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mikuEsperando.gif"))); // NOI18N
        jPanel1.add(lblConcurrenteEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, -1, -1));

        ImagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mikuFondo.jpeg"))); // NOI18N
        jPanel1.add(ImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecuencialActionPerformed
        if (!isMatrizVacia()) {

            lblProgresoSecuencial.setText("En ejecucion...");
            lblProgresoSecuencial.setBackground(Color.red);
            ImageIcon icono = new ImageIcon(getClass().getResource("/img/mikuPensando.gif"));
            lblSecuencialEstado.setIcon(icono);
            objetoSecuencial.setFilas1(Integer.parseInt(txtFilas1.getText()));
            objetoSecuencial.setFilas2(Integer.parseInt(txtFilas2.getText()));
            objetoSecuencial.setColumnas1(Integer.parseInt(txtColumnas1.getText()));
            objetoSecuencial.setColumnas2(Integer.parseInt(txtColumnas2.getText()));
            objetoSecuencial.setMatriz1(matriz1);
            objetoSecuencial.setMatriz2(matriz2);

            correrSecuencial();

        } else {
            JOptionPane.showMessageDialog(null, "Primero tienes que llenar las matrices");
        }

    }//GEN-LAST:event_btnSecuencialActionPerformed


    private void btnConcurrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcurrenteActionPerformed
        if (Integer.parseInt(txtHilos.getText()) > 8) {
            JOptionPane.showMessageDialog(null, "No puedes poner mas de 8 hilos porfa");
        } else {
            if (!isMatrizVacia()) {
                if ((!txtSaltos.getText().isBlank() && isNumber(txtSaltos.getText())) && (!txtHilos.getText().isBlank() && isNumber(txtHilos.getText()))) {
                    lblProgresoConcurrente.setText("En ejecucion...");
                    lblProgresoConcurrente.setBackground(Color.red);
                    ImageIcon icono = new ImageIcon(getClass().getResource("/img/mikuPensando.gif"));
                    lblConcurrenteEstado.setIcon(icono);
                    objetoConcurrente.setFilas1(Integer.parseInt(txtFilas1.getText()));
                    objetoConcurrente.setFilas2(Integer.parseInt(txtFilas2.getText()));
                    objetoConcurrente.setColumnas1(Integer.parseInt(txtColumnas1.getText()));
                    objetoConcurrente.setColumnas2(Integer.parseInt(txtColumnas2.getText()));
                    objetoConcurrente.setMatriz1(matriz1);
                    objetoConcurrente.setMatriz2(matriz2);
                    objetoConcurrente.setSaltos(Integer.parseInt(txtSaltos.getText()));
                    objetoConcurrente.setHilos(Integer.parseInt(txtHilos.getText()));

                    correrConcurrente();

                } else {
                    JOptionPane.showMessageDialog(null, "Debes completar todos los  campos con numeros");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Primero tienes que llenar las matrices");
            }

        }


    }//GEN-LAST:event_btnConcurrenteActionPerformed

    private void btnGenerarMatricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarMatricesActionPerformed
        if (matriz1 != null) {
            matriz1 = null;
            matriz2 = null;
        }

        if (verificarDatos()) {
            max = (int) spnMax.getValue();
            min = (int) spnMin.getValue();

            matriz1 = new int[Integer.parseInt(txtFilas1.getText())][Integer.parseInt(txtColumnas1.getText())];
            matriz2 = new int[Integer.parseInt(txtFilas2.getText())][Integer.parseInt(txtColumnas2.getText())];
            Random rand = new Random(semilla);

            for (int i = 0; i < Integer.parseInt(txtFilas1.getText()); i++) {
                for (int j = 0; j < Integer.parseInt(txtColumnas1.getText()); j++) {
                    int numeroAleatorio = rand.nextInt(max - min + 1) + min;
                    matriz1[i][j] = numeroAleatorio;
                }
            }

            for (int i = 0; i < Integer.parseInt(txtFilas2.getText()); i++) {
                for (int j = 0; j < Integer.parseInt(txtColumnas2.getText()); j++) {
                    int numeroAleatorio = rand.nextInt(max - min + 1) + min;
                    matriz2[i][j] = numeroAleatorio;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos y con numeritos porfa");
        }


    }//GEN-LAST:event_btnGenerarMatricesActionPerformed

    private void btnCambiarTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarTiempoActionPerformed
        // TODO add your handling code here:
        if (estadoTiempos == 0) {
            lblTiempoSecuencial.setText("" + tiempoSegundosSecuencial);
            lblTiempoConcurrente.setText("" + tiempoSegundosConcurrente);
            lblTextoSecuencial.setText("Tiempo en segundos");
            lblTextoConcurrente.setText("Tiempo en segundos");
            estadoTiempos = 1;

        } else if (estadoTiempos == 1) {
            lblTiempoSecuencial.setText("" + tiempoMinutosSecuencial);
            lblTiempoConcurrente.setText("" + tiempoMinutosConcurrente);
            lblTextoSecuencial.setText("Tiempo en Minutos");
            lblTextoConcurrente.setText("Tiempo en Minutos");
            estadoTiempos = 2;
        } else if (estadoTiempos == 2) {
            lblTiempoSecuencial.setText("" + tiempoMilisegundosSecuencial);
            lblTiempoConcurrente.setText("" + tiempoMilisegundosConcurrente);
            lblTextoSecuencial.setText("Tiempo en Milisegundos");
            lblTextoConcurrente.setText("Tiempo en Milisegundos");
            estadoTiempos = 0;
        }


    }//GEN-LAST:event_btnCambiarTiempoActionPerformed

    private boolean verificarDatos() {
        if (Integer.parseInt(txtColumnas1.getText()) != Integer.parseInt(txtFilas2.getText())) {
            return false;
        }

        if (txtColumnas1.getText().isBlank() || !isNumber(txtColumnas1.getText())) {
            return false;
        }
        if (txtColumnas2.getText().isBlank() || !isNumber(txtColumnas2.getText())) {
            return false;
        }
        if (txtFilas1.getText().isBlank() || !isNumber(txtFilas1.getText())) {
            return false;
        }
        if (txtFilas2.getText().isBlank() || !isNumber(txtFilas2.getText())) {
            return false;
        }
        return true;
    }

    private boolean isMatrizVacia() {
        if (matriz1 == null) {
            return true;
        }
        return false;
    }

    private boolean isNumber(String numero) {
        try {
            Integer.valueOf(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void correrConcurrente() {

        Thread hilo = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

                try {
                    objetoConcurrente.correrHilos();

                    lblTiempoConcurrente.setText("" + objetoConcurrente.getTiempo());
                    tiempoMilisegundosConcurrente = objetoConcurrente.getTiempo();
                    tiempoSegundosConcurrente = tiempoMilisegundosConcurrente / 1000;
                    tiempoMinutosConcurrente = tiempoSegundosConcurrente / 60;
                    System.out.println("" + tiempoMilisegundosConcurrente / 1000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(InterfazMatrices.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Hubo un problema al intentar correr los hilos");
                }
                matrizResultadoConcurrente = objetoConcurrente.getMatrizResultado();

                try {
                    archivoConcurrente = new File("archivoConcurrente.txt");
                    escribirArchivo(archivoConcurrente, matriz1, matriz2, matrizResultadoConcurrente);
                    if (archivoConcurrente.createNewFile()) {
                        JOptionPane.showMessageDialog(null, "Archivo creado");
                    }

                } catch (IOException ex) {
                    Logger.getLogger(InterfazMatrices.class.getName()).log(Level.SEVERE, null, ex);
                }
                lblProgresoConcurrente.setText("Finalizado");
                lblProgresoConcurrente.setBackground(Color.GREEN);
                ImageIcon icono = new ImageIcon(getClass().getResource("/img/mikuEsperando.gif"));
                lblConcurrenteEstado.setIcon(icono);
                break;
            }
        });
        hilo.start();

    }

    public void correrSecuencial() {
        Thread hilo = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

                objetoSecuencial.correr();
                lblTiempoSecuencial.setText("" + objetoSecuencial.getTiempo());
                tiempoMilisegundosSecuencial = objetoSecuencial.getTiempo();
                tiempoSegundosSecuencial = tiempoMilisegundosSecuencial / 1000;
                tiempoMinutosSecuencial = tiempoSegundosSecuencial / 60;
                System.out.println("" + tiempoMilisegundosSecuencial / 1000);

                matrizResultadoSecuencial = objetoSecuencial.getMatrizResultado();
                try {
                    archivoSecuencial = new File("archivoSecuencial.txt");
                    escribirArchivo(archivoSecuencial, matriz1, matriz2, matrizResultadoSecuencial);
                    if (archivoSecuencial.createNewFile()) {
                        JOptionPane.showMessageDialog(null, "Archivo creado");
                    }

                } catch (IOException ex) {
                    Logger.getLogger(InterfazMatrices.class.getName()).log(Level.SEVERE, null, ex);
                }
                lblProgresoSecuencial.setText("Finalizado");
                lblProgresoSecuencial.setBackground(Color.GREEN);
                ImageIcon icono = new ImageIcon(getClass().getResource("/img/mikuEsperando.gif"));
                lblSecuencialEstado.setIcon(icono);
                break;
            }
        });
        hilo.start();

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
            JOptionPane.showMessageDialog(null, "Hubo un error" + e);
        }

    }

    private void borrarArchivo(File archivoTemp) {
        try {
            archivoTemp.delete();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar borrar el archivo");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazMatrices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenFondo;
    private javax.swing.JButton btnCambiarTiempo;
    private javax.swing.JButton btnConcurrente;
    private javax.swing.JButton btnGenerarMatrices;
    private javax.swing.JButton btnSecuencial;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblColumnas1;
    private javax.swing.JLabel lblColumnas2;
    private javax.swing.JLabel lblConcurrenteEstado;
    private javax.swing.JLabel lblFilas1;
    private javax.swing.JLabel lblFilas2;
    private javax.swing.JLabel lblHilos;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblProgresoConcurrente;
    private javax.swing.JLabel lblProgresoSecuencial;
    private javax.swing.JLabel lblSaltos;
    private javax.swing.JLabel lblSecuencialEstado;
    private javax.swing.JLabel lblTextoConcurrente;
    private javax.swing.JLabel lblTextoSecuencial;
    private javax.swing.JLabel lblTiempoConcurrente;
    private javax.swing.JLabel lblTiempoSecuencial;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSpinner spnMax;
    private javax.swing.JSpinner spnMin;
    private javax.swing.JTextField txtColumnas1;
    private javax.swing.JTextField txtColumnas2;
    private javax.swing.JTextField txtFilas1;
    private javax.swing.JTextField txtFilas2;
    private javax.swing.JTextField txtHilos;
    private javax.swing.JTextField txtSaltos;
    // End of variables declaration//GEN-END:variables
}
