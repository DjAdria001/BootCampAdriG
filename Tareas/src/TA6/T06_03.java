package TA6;

import javax.swing.JOptionPane;

public class T06_03 {

	public static void main(String[] args) {
		String InsNum = JOptionPane.showInputDialog("Inserte un numero: ");
		int num = Integer.parseUnsignedInt(InsNum);
		boolean Resultado = esPrimo(num);
		if (Resultado == true) {
			JOptionPane.showMessageDialog(null, "Es primo");
		} else if (Resultado == false) {
			JOptionPane.showMessageDialog(null, "No es primo");
		}
		

	}

	public static boolean esPrimo(int numero) {
		for (int Div = 2; Div <= (numero - 1); Div++) {
			if (numero % Div == 0 || numero == 1) {
				return false;
			}
		}
		return true;
	}
}
