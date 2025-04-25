package TA06;
import javax.swing.JOptionPane;
public class T06_07 {

	public static void main(String[] args) {
		String Pregunta = JOptionPane.showInputDialog("Introduce la divisa a la que quieres convertir: \nDolar Libra Yen");
		String divisa = Pregunta.toLowerCase();
		String Pregunta2 = JOptionPane.showInputDialog("Introduce la cantidad de euros: ");
		double cantidad = Double.parseDouble(Pregunta2);
		
		switch(divisa) {
		case "dolar":
			JOptionPane.showMessageDialog(null, "La cantidad en dolares es:\n" + convertirDivisa(divisa, cantidad)+"$");
			break;
		case "libra":
			JOptionPane.showMessageDialog(null, "La cantidad en libras es:\n" + convertirDivisa(divisa, cantidad)+"£");
			break;
		case "yen":
			JOptionPane.showMessageDialog(null, "La cantidad en yenes es:\n" + convertirDivisa(divisa,cantidad)+"¥");
			break;
		default: 
			JOptionPane.showMessageDialog(null, "La divisa introducida no es valida");
			break;
		}
	}

	public static double convertirDivisa(String divisa, double cantidad) {
		double resultado = 0;
		switch (divisa) {
		case "dolar":
			resultado = cantidad * 1.28611;
			break;
		case "libra":
			resultado = cantidad * 0.86;
			break;
		case "yen":
			resultado = cantidad * 129.852;
			break;
		}
		return resultado;
	}
}
