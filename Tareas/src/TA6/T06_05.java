package TA6;

import javax.swing.JOptionPane;

public class T06_05 {

	public static void main(String[] args) {
		String Pregunta = JOptionPane.showInputDialog("Introduce un numero para convertirlo a binario: ");
		int PregNum = Integer.parseInt(Pregunta);
		JOptionPane.showMessageDialog(null, "El numero " + PregNum + " en binario es: " + Binario(PregNum));
	}

	public static String Binario(int num) {
		String binario = "";
		while (num > 0) {
			binario = (num % 2) + binario;
			num = num / 2;
		}
		return binario;
	}
}
