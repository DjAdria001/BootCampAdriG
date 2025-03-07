package TA6;

import javax.swing.JOptionPane;

public class T06_11 {

	public static void main(String[] args) {
		String Filas = JOptionPane.showInputDialog("Inserte el numero de filas de la matriz: ");
		String Columnas = JOptionPane.showInputDialog("Inserte el numero de columnas de la matriz: ");
		int Largo = Integer.parseInt(Filas);
		int Alto = Integer.parseInt(Columnas);

		int array[][] = new int[Largo][Alto];

		int array2[][] = new int[Largo][Alto];
		int i = 0;
		while (i < Largo) {
			int j = 0;
			while (j < Alto) {
				array[i][j] = ValorRand();
				j++;
			}
			i++;
		}
		array2 = array;
		System.out.println("Array 1");
		Mostrar(array, Largo, Alto);
		System.out.println("Array 2");
		Mostrar(array2, Largo, Alto);
		int[][] array3 = new int[Largo][Alto];
		System.out.println("Array 3");
		array3 = multipliArrays(array, array2, array3, Largo, Alto);

	}

	public static int ValorRand() {
		int RandomNum = (int) (Math.random() * 10);
		return RandomNum;
	}

	public static int Mostrar(int[][] num, int Longitud, int Altitud) {
		for (int i = 0; i < Longitud; i++) {
			for (int j = 0; j < Altitud; j++) {
				System.out.print(num[i][j] + " ");
			}
			System.out.println();
		}
		return 0;
	}

	public static int[][] multipliArrays(int Array1[][], int Array2[][], int Array3[][], int Filas, int Columnas) {

		for (int i = 0; i < Filas; i++) {
			for (int j = 0; j < Columnas; j++) {
				Array3[i][j] = Array1[i][j] * Array2[i][j];
				System.out.print(Array3[i][j] + " ");
			}
			System.out.println();
		}

		return Array3;
	}
}
