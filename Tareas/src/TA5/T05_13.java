package TA5;

import javax.swing.JOptionPane;

public class T05_13 {

	public static void main(String[] args) {
		String Num1 = JOptionPane.showInputDialog("Introduce el primer numero de la operacion: ");
		int Num1Int = Integer.parseInt(Num1);
		String Operacion = JOptionPane
				.showInputDialog("Introduce el simbolo(+ - * / %) la operacion que deseas realizar: ");
		String Num2 = JOptionPane.showInputDialog("Introduce el segundo numero de la operacion: ");
		int Num2Int = Integer.parseInt(Num2);
		int Resultado = 0;
		if (Operacion.equals("+")) {
			Resultado = Num1Int + Num2Int;
			javax.swing.JOptionPane.showMessageDialog(null, "El resultado de la operacion es: " + Resultado);
		} else if (Operacion.equals("-")) {
			Resultado = Num1Int - Num2Int;
			javax.swing.JOptionPane.showMessageDialog(null, "El resultado de la operacion es: " + Resultado);
		} else if (Operacion.equals("*")) {
			Resultado = Num1Int * Num2Int;
			javax.swing.JOptionPane.showMessageDialog(null, "El resultado de la operacion es: " + Resultado);
		} else if (Operacion.equals("/")) {
			Resultado = Num1Int / Num2Int;
			javax.swing.JOptionPane.showMessageDialog(null, "El resultado de la operacion es: " + Resultado);
		} else if (Operacion.equals("%")) {
			Resultado = Num1Int % Num2Int;
			javax.swing.JOptionPane.showMessageDialog(null, "El resultado de la operacion es: " + Resultado);
		}
	}

}
