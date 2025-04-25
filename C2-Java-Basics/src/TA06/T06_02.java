package TA06;

import javax.swing.JOptionPane;

public class T06_02 {

	public static void main(String[] args) {
		String pregNumero1 = JOptionPane.showInputDialog("Escribe un número:");
		double Numero1 = Double.parseDouble(pregNumero1);
		String pregNumero2 = JOptionPane.showInputDialog("Escribe otro número:");
		double Numero2 = Double.parseDouble(pregNumero2);
		String Pregunta = JOptionPane.showInputDialog("Cuantos numeros quieres generar?");
		int PregNum = Integer.parseInt(Pregunta);
		while (PregNum > 0) {
			double Resultado = Parametros(Numero1, Numero2);
			JOptionPane.showMessageDialog(null,
					"El número aleatorio entre " + Numero1 + " y " + Numero2 + " es: " + Resultado);
			PregNum--;

		}

	}

	public static double Parametros(double Num1, double Num2) {
		double Resultado = Math.random() * (Num2 - Num1) + Num1;
		long Redondeo = Math.round(Resultado);
		return Redondeo;
	}
}
