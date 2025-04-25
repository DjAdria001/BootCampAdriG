package TA05;

import javax.swing.JOptionPane;

public class T05_06 {

	public static void main(String[] args) {
		final double IVA = 0.21;
		String InsNum = JOptionPane.showInputDialog("Inserte el precio del producto: ");
		double Precio = Double.parseDouble(InsNum);
		
		JOptionPane.showMessageDialog(null,
				"El precio inicial del producto es: " + Precio + "€, y el final es de " + (Precio + (Precio * IVA))+ "€");
	}

}
