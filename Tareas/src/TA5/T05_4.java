package TA5;

import javax.swing.JOptionPane;

public class T05_4 {

	public static void main(String[] args) {
		final double pi = Math.PI;
		String texto_num = JOptionPane.showInputDialog("Introduce el Radio del Circulo");
		double Radio = Integer.parseInt(texto_num);

		double radio2 = Math.pow(Radio, 2);
		JOptionPane.showMessageDialog(null, "El Radio es de " + Radio + ". Y su area total es de " + (pi * (radio2)));

	}

}
