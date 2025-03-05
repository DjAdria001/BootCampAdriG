package TA6;

import javax.swing.JOptionPane;

public class T06_10 {

	public static void main(String[] args) {
		String tamaño = JOptionPane.showInputDialog("Inserta el tamaño del array: ");
		int tamañoNum = Integer.parseInt(tamaño);
		int num[] = new int[tamañoNum];
		int i = 0;
		while (i < tamañoNum) {
			num[i] = ValorRandPrimo();
			i++;
		}
		Mostrar(num, num.length);
		System.out.println("El valor maximo del array es: " + Maximo(num));
	}

	public static int ValorRandPrimo() {
		int RandomNum = (int) (Math.random() * 100);
		boolean primo = false;
		while (primo == false) {
			RandomNum = (int) (Math.random() * 100);
			primo = true;
			for (int Div = 2; Div <= (RandomNum - 1); Div++) {
				if (RandomNum % Div == 0 || RandomNum == 1 || RandomNum == 0) {
					primo = false;
				}
			}
		}
		return RandomNum;
	}

	public static int Mostrar(int[] num, int Longitud) {
		for (int i = 0; i < Longitud; i++) {
			System.out.println("El valor de num[" + i + "] es " + num[i]);
		}
		return 0;
	}
	public static int Maximo(int[] num) {
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }
}
