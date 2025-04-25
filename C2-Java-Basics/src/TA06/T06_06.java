package TA06;

import javax.swing.JOptionPane;

public class T06_06 {

	public static void main(String[] args) {
		String Pregunta = JOptionPane.showInputDialog("Introduce un numero entero positivo: ");
		int PregNum = Integer.parseInt(Pregunta);
		if (PregNum < 0) {
			JOptionPane.showMessageDialog(null, "El numero debe ser positivo");
		} else {
			JOptionPane.showMessageDialog(null, "El numero " + PregNum + " tiene " + ContarCifras(PregNum) + " cifras");
		}

	}

	public static int ContarCifras(int num) {
		int cifras = 0;
		while (num > 0) {
			num = num / 10;
			cifras++;
		}
		return cifras;
	}

}
