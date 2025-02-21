package TA5;

import javax.swing.JOptionPane;

public class T05_4 {

	public static void main(String[] args) {
		final double pi = 3.14;
		String texto_num = JOptionPane.showInputDialog
				("Introduce el Radio del Circulo");

		int Radio = Integer.parseInt(texto_num);
		JOptionPane.showMessageDialog
		(null,"El Radio es de " + Radio + 
		". Y su area total es de "
		+ (pi * (Radio * Radio)));

	}

}
