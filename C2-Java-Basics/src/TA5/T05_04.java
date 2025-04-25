package TA5;

import javax.swing.JOptionPane;

public class T05_04 {

	public static void main(String[] args) {
		final double pi = Math.PI;
		String texto_num = JOptionPane.showInputDialog
				("Introduce el Radio del Circulo");
		double Radio = Double.parseDouble(texto_num);
		
		JOptionPane.showMessageDialog(null, "El Radio es de " + Radio 
				+ ". Y su area total es de " + (pi * (Math.pow(Radio, 2))));

	}

}
