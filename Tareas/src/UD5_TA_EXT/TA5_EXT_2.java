package UD5_TA_EXT;

import javax.swing.JOptionPane;

public class TA5_EXT_2 {
	public static void main(String[] args) {
		String Numero = JOptionPane.showInputDialog("Intoduce un número para calcular el factorial: ");
		int Num = Integer.parseUnsignedInt(Numero);
		int factorial = 1;
		for (int i = 1; i <= Num; i++) {
			factorial = factorial * i;
		}
		javax.swing.JOptionPane.showMessageDialog(null, "El factorial es: " + factorial);
	}
}