/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author PC
 */
public class HilosMultiplicar implements Runnable {

    int[][] fila;
    int[][] columna;
    int posFila;
    int posColumna;
    MatrizConcurrente planificador;

    public HilosMultiplicar(int[][] fila, int[][] columna, int posFila, int posColumna, MatrizConcurrente planificador) {
        this.fila = fila;
        this.columna = columna;
        this.posFila = posFila;
        this.posColumna = posColumna;
        this.planificador = planificador;
    }

    public void recibirDatos(int[][] filaTemp, int[][] columnaTemp, int posFilaTemp, int posColumnaTemp) {
        fila = filaTemp;
        columna = columnaTemp;
        posFila = posFilaTemp;
        posColumna = posColumnaTemp;
    }

    @Override
    public void run() {

        try {
            int matrizRetorno[][] = new int[fila.length][columna.length];
            int temp = 0;
            for (int i = 0; i < fila.length; i++) {
                for (int j = 0; j < columna.length; j++) {
                    for (int recorrer = 0; recorrer < fila.length; recorrer++) {
                        temp += fila[i][recorrer] * columna[recorrer][j];
                    }

                    matrizRetorno[i][j] = temp;
                    temp = 0;
                }

            }
            planificador.meterDatos(posFila, posColumna, matrizRetorno);
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

}
