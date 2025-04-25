package UD5_TA_EXT;

import javax.swing.JOptionPane;

public class TA5_EXT_5 {

	public static void main(String[] args) {
		double NumRandom1 = Math.random();
		long NumRandom2 = Math.round(NumRandom1 * 100);
//		System.out.println(NumRandom2);
		String Pregunta = JOptionPane.showInputDialog("Adivina el numero: ");
		int PregNum = Integer.parseInt(Pregunta);
		while (PregNum != NumRandom2) {
			if (PregNum < NumRandom2) {
				JOptionPane.showMessageDialog(null, "El numero es mayor");
			} else if (PregNum > NumRandom2) {
				JOptionPane.showMessageDialog(null, "El numero es menor");
			}
			Pregunta = JOptionPane.showInputDialog("Vuelve a Intentarlo: ");
			PregNum = Integer.parseInt(Pregunta);
		}
		JOptionPane.showMessageDialog(null, "Has acertado");
	}
}