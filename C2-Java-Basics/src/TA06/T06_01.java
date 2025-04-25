package TA06;

import javax.swing.JOptionPane;

public class T06_01 {

	public static void main(String[] args) {
		String Forma = JOptionPane.showInputDialog("Elija una forma: Circulo, Triangulo o Cuadrado ");
		Forma = Forma.toLowerCase();
		switch (Forma) {
		case "circulo":
			double radio = Double
					.parseDouble(JOptionPane.showInputDialog("Escribe el radio del circulo en centimetros: "));
			JOptionPane.showMessageDialog(null, "El area del circulo es: " + calcCirculo(radio) + "cm");
			break;

		case "cuadrado":
			double lado = Double
					.parseDouble(JOptionPane.showInputDialog("Escribe el lado del cuadrado en centimetros: "));
			JOptionPane.showMessageDialog(null, "El area del cuadrado es " + calcCuadrado(lado) + "cm");
			break;

		case "triangulo":
			double base = Double
					.parseDouble(JOptionPane.showInputDialog("Escribe la base del triangulo en centimetros: "));
			double altura = Double
					.parseDouble(JOptionPane.showInputDialog("Escribe la altura del triangulo en centimetros: "));
			JOptionPane.showMessageDialog(null, "El area del triangulo es " + calcTriangulo(base, altura) + "cm");
			break;
		}

	}

	public static double calcCirculo(double radio) {
		return Math.PI * Math.pow(radio, 2);
	}

	public static double calcTriangulo(double base, double altura) {
		return (base * altura) / 2;
	}

	public static double calcCuadrado(double lado) {
		return Math.pow(lado, 2);
	}
}
