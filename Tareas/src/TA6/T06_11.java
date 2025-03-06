package TA6;

import javax.swing.JOptionPane;

public class T06_11 {

	public static void main(String[] args) {
		String Filas = JOptionPane.showInputDialog("Inserte el numero de filas de la matriz: ");
		String Columnas = JOptionPane.showInputDialog("Inserte el numero de columnas de la matriz: ");

		int array[][] = new int[Integer.parseInt(Filas)][Integer.parseInt(Columnas)];

		int array2[][] = new int[Integer.parseInt(Filas)][Integer.parseInt(Columnas)];
		int i = 0;
		while (i < Integer.parseInt(Filas)) {
			int j = 0;
			while (j < Integer.parseInt(Columnas)) {
				array[i][j] = ValorRand();
				j++;
			}
			i++;
		}
		array2 = array;
		System.out.println("Array 1");
		Mostrar(array, array.length, array[0].length);
		System.out.println("Array 2");
		Mostrar(array2, array2.length, array2[0].length);
		int[][] array3 = new int[Integer.parseInt(Filas)][Integer.parseInt(Columnas)];
		System.out.println("Array 3");
		array3 = multipliArrays(array, array2, array3, array.length, array[0].length);

	}

	public static int ValorRand() {
		int RandomNum = (int) (Math.random() * 10);
		return RandomNum;
	}

	public static int Mostrar(int[][] num, int Longitud, int Longitud2) {
		for (int i = 0; i < Longitud; i++) {
			for (int j = 0; j < Longitud2; j++) {
				System.out.println("El valor de num[" + i + "][" + j + "] es " + num[i][j]);
//			System.out.println("El valor de num[" + i + "] es " + num[i][j]);
			}
		}
		return 0;
	}

	public static int[][] multipliArrays(int Array1[][], int Array2[][],int Array3[][], int Filas, int Columnas) {
		   
        for (int i = 0; i < Filas; i++) {
            for (int j = 0; j < Columnas; j++) {
                Array3[i][j] = Array1[i][j] * Array2[i][j];
				System.out.println("El valor de num[" + i + "][" + j + "] es " + Array3[i][j]);
            }
        }
        
        
		return Array3;
    }
}
