package TA6;

import javax.swing.JOptionPane;

public class T06_08 {

	public static void main(String[] args) {

		int num[] = new int[10];
			num[0] = Valor(num[0]);
			num[1] = Valor(num[1]);
			num[2] = Valor(num[2]);
			num[3] = Valor(num[3]);
			num[4] = Valor(num[4]);
			num[5] = Valor(num[5]);
			num[6] = Valor(num[6]);
			num[7] = Valor(num[7]);
			num[8] = Valor(num[8]);
			num[9] = Valor(num[9]);

		Mostrar(num, num.length);

	}

	public static int Valor(int Numero) {

		String Pregunta = JOptionPane.showInputDialog("Inserta un numero: ");
		int PregNum = Integer.parseInt(Pregunta);
		return PregNum;
	}

	public static int Mostrar(int[] num, int Longitud) {
		for (int i = 0; i < Longitud; i++) {
			System.out.println("El valor de num[" + i + "] es " + num[i]);
		}
		return 0;
	}
}
