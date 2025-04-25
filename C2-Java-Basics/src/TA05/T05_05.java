package TA05;

import javax.swing.JOptionPane;

public class T05_05 {

	public static void main(String[] args) {

		String InsNum = JOptionPane.showInputDialog("Inserte un Numero: ");
		int num = Integer.parseUnsignedInt(InsNum);
		if ((num % 2) == 0) {
			JOptionPane.showMessageDialog(null, num + " es divisible entre 2");
		} else {
			JOptionPane.showMessageDialog(null, num + " no es divisible entre 2");
		}

	}

}
