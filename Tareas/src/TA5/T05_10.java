package TA5;
import javax.swing.JOptionPane;
public class T05_10 {

	public static void main(String[] args) {
		String NumVen = JOptionPane.showInputDialog("Introduce el Numero de ventas:");

		int NumVentas = Integer.parseInt(NumVen);
		int i = 0;
		int TotalVentas = 0;
		while (i < NumVentas) {
			String Venta = JOptionPane.showInputDialog("Introduce el valor de la venta:");
			int VentaInt = Integer.parseInt(Venta);
			TotalVentas = TotalVentas + VentaInt;
			i++;
		}
		JOptionPane.showMessageDialog(null, "El total de ventas es: " + TotalVentas);
		
	}

}
