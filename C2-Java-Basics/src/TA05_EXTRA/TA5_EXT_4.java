package TA05_EXTRA;

import javax.swing.JOptionPane;

public class TA5_EXT_4 {
	public static void main(String[] args) {
		String Palabra = JOptionPane.showInputDialog("Introduce una palabra: ");
		Palabra = Palabra.toLowerCase();
		int Vocales = 0;
		for (int i = 0; i < Palabra.length(); i++) {
			char letra = Palabra.charAt(i);

			if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
				Vocales++;
			}

		}
		JOptionPane.showMessageDialog(null, "La palabra " + Palabra + " tiene " + Vocales + " vocales.");

	}

}
