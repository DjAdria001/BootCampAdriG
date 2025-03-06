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
		Mostrar(array, array.length, array[0].length);
		
	}
	public static int ValorRand() {
		int RandomNum = (int) (Math.random() * 10);
		return RandomNum;
	}
	public static int Mostrar(int[][] num, int Longitud, int Longitud2) {
		for ( int i = 0; i < Longitud; i++) {
			for (int j = 0; j < Longitud2; j++) {
			System.out.println("El valor de num[" + i + "]["+ j+"] es " + num[i][j]);
			}
		}
		return 0;
	}
}

