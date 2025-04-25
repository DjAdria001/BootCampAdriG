package TA10_01;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		boolean NumCorr = false;
		Double NumRan1 = Math.random() * 500;
		Integer NumRan2 = NumRan1.intValue() + 1;
		int intentos = 0;

		do {
			try {
				String NumStr = JOptionPane.showInputDialog("Adivina el número entre 1 y 500");
				Integer Num = Integer.parseInt(NumStr);
				if (Num > NumRan2) {
					intentos++;
					JOptionPane.showMessageDialog(null, "El número es menor");
				} else if (Num < NumRan2) {
					intentos++;
					JOptionPane.showMessageDialog(null, "El número es mayor");
				} else {
					intentos++;
					JOptionPane.showMessageDialog(null, "Has acertado el número en " + intentos + " intentos");
					NumCorr = true;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
				intentos++;
			}

		} while (!NumCorr);

	}

}
