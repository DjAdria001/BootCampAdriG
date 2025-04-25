package TA05_EXTRA;

import javax.swing.JOptionPane;

public class TA5_EXT_1 {

	public static void main(String[] args) {
		String InsNum = JOptionPane.showInputDialog("Inserte un Numero: ");
		int num = Integer.parseUnsignedInt(InsNum);
		boolean primo = true;

		for (int Div = 2; Div <= (num - 1); Div++) {
			if (num % Div == 0 || num == 1) {
//        		System.out.println(num +" No es un numero primo -->" + num+ "/" +Div);
				primo = false;
			}
		}
		if (primo == true) {
			javax.swing.JOptionPane.showMessageDialog(null, num + " es un numero primo.");
		} else if (primo == false) {
			javax.swing.JOptionPane.showMessageDialog(null, num + " no es un numero primo.");
		}
	}
}
