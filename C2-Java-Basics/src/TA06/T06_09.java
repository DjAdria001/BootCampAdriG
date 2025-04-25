package TA06;

import javax.swing.JOptionPane;

public class T06_09 {

	public static void main(String[] args) {
		String tamaño = JOptionPane.showInputDialog("Inserta el tamaño del array: ");
		int tamañoNum = Integer.parseInt(tamaño);
		int num[] = new int[tamañoNum];

		int i = 0;

		while (i < tamañoNum) {
			num[i] = ValorRand();
			i++;
		}
		Mostrar(num, num.length);
		int suma = 0;
		for (int i2 = 0; i2 < num.length; i2++) {
			suma = suma + num[i2];
		}
		System.out.println("La suma de todos los valores es: " + suma);

	}

	public static int ValorRand() {
		int RandomNum = (int) (Math.random() * 10);
		return RandomNum;
	}

	public static int Mostrar(int[] num, int Longitud) {
		for (int i = 0; i < Longitud; i++) {
			System.out.println("El valor de num[" + i + "] es " + num[i]);
		}
		return 0;
	}

}
