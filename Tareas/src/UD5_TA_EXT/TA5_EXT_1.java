package UD5_TA_EXT;

import javax.swing.JOptionPane;

public class TA5_EXT_1 {
	public static void main(String[] args) {
		String InsNum = JOptionPane.showInputDialog("Inserte un Numero: ");
		int num = Integer.parseUnsignedInt(InsNum);
		int num2 = num--;
		if (num == 2) {
			System.out.println(num + " Es un numero primo");
		} else if ((num % num) == 0 && (num % 1) == 0) {
			System.out.println(num + " Es un numero primo");
		} else if () {
			System.out.println(num + " No es un numero primo");
		}
	}
}
