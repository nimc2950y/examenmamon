/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasenlazadas.examenarreglos;

public class Metodos {

    String A = "4,5,2,3,4;3,6,1,8,4;3,3,1,1,0;2,2,2,7,9";
    String B = "1,1,1,2,1;3,3,9,0,0;2,2,7,7,7;1,0,0,0,9";
    int[][] arregloA = new int[4][5];
    int[][] arregloB = new int[4][5];
    int[][] arregloC;

    public void ingresarEnArreglo() {

        String[] arregloCadenaA = A.split(";");
        String[] arregloCadenaB = B.split(";");
        // Procesar cada fila de A convertir de String a int y guardarlos en un 
        // arreglo
        for (int i = 0; i < arregloA.length; i++) {
            String[] elementos = arregloCadenaA[i].split(",");
            arregloA[i] = new int[elementos.length];
            for (int j = 0; j < elementos.length; j++) {
                arregloA[i][j] = Integer.parseInt(elementos[j]);
            }
        }

        // Procesar cada fila de A convertir de String a int y guardarlos en un 
        // arreglo
        for (int i = 0; i < arregloCadenaB.length; i++) {
            String[] elementos = arregloCadenaB[i].split(",");
            arregloB[i] = new int[elementos.length];
            for (int j = 0; j < elementos.length; j++) {
                arregloB[i][j] = Integer.parseInt(elementos[j]);
            }
        }

    }

    // Llenamos arregloC
    public void llenarArregloC() {
        arregloC = new int[arregloA.length][arregloA[0].length];
        for (int i = 0; i < arregloC.length; i++) {
            for (int j = 0; j < arregloC[i].length; j++) {
                arregloC[i][j] = arregloA[i][j] + arregloB[i][j];
            }
        }
    }

    // Presentamos
    public void imprimir() {
        for (int i = 0; i < arregloC.length; i++) {
            for (int j = 0; j < arregloC[i].length; j++) {
                System.out.printf("%d\t", arregloC[i][j]);
            }
            System.out.println("");
        }
    }
}
