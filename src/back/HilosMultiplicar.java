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
    int[][] matriz2;
    int posFila;
    int posColumna =0;
    MatrizConcurrente planificador;

    public HilosMultiplicar(int[][] fila, int[][] matriz2, int posFila,MatrizConcurrente planificador) {
        this.fila = fila;
        this.matriz2 = matriz2;
        this.posFila = posFila;
        
        this.planificador = planificador;
    }

    public void recibirDatos(int[][] filaTemp, int[][] columnaTemp, int posFilaTemp, int posColumnaTemp) {
        fila = filaTemp;
        matriz2 = columnaTemp;
        posFila = posFilaTemp;
        posColumna = posColumnaTemp;
    }

    @Override
    public void run() {

        try {
            int matrizRetorno[][] = new int[fila.length][matriz2[0].length];
            int temp = 0;
            for (int i = 0; i < fila.length; i++) {
                
                for (int j = 0; j < matriz2[0].length; j++) {
                    
                    for (int recorrer = 0; recorrer < matriz2.length; recorrer++) {
                        
                        temp += fila[i][recorrer] * matriz2[recorrer][j];
                        //System.out.println(temp);
                        
                    }
                    
                    matrizRetorno[i][j] = temp;
                    temp = 0;
                    
                }
                
            }
            //System.out.println("" + matrizRetorno.length +"," + matrizRetorno[0].length);
            //System.out.println("" + matriz2.length + "," + matriz2[0].length);
            //System.out.println("Funciona11111?");
            //System.out.println("");
            
//            for(int i = 0;i<matriz2.length;i++){
//                for(int j = 0;j<matriz2[0].length;j++){
//                    System.out.print(""+matriz2[i][j]+",");
//                }
//                System.out.println("");
//            }
            
//            System.out.println(""+matriz2.length);
//            System.out.println(""+matriz2[0].length+"a");

            //System.out.println("");
            planificador.meterDatos(posFila, posColumna, matrizRetorno);
            //System.out.println("Funciona222222?");
        } catch (Exception e) {
            System.out.println("Error al meter datos" + e);
        }
    }

}
