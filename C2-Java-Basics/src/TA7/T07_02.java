package TA7;

import javax.swing.JOptionPane;
import java.util.Enumeration;
import java.util.Hashtable;

public class T07_02 {

	public static void main(String[] args) {

		Hashtable<String, Double> Cesta = new Hashtable<>();
		boolean Final = false;
		int Cantidad = 0;
		do {
			String Añadir = JOptionPane.showInputDialog("Que producto desea comprar? "
					+ "\nmanzana pera pizza salchicha lasaña huevos" + "\nescribe final para acabar tu cesta.");
			String producto = Añadir.toLowerCase();

			switch (producto) {
			case "manzana":
				Cesta.put("manzana", 2.0);
				Cantidad++;
				break;
			case "pera":
				Cesta.put("pera", 2.5);
				Cantidad++;
				break;
			case "pizza":
				Cesta.put("pizza", 4.35);
				Cantidad++;
				break;
			case "salchicha":
				Cesta.put("salchicha", 6.25);
				Cantidad++;
				break;
			case "lasaña":
				Cesta.put("lasaña", 5.1);
				Cantidad++;
				break;
			case "huevos":
				Cesta.put("huevos", 6.2);
				Cantidad++;
				break;
			case "final":
				Final = true;
				break;
			default:
				javax.swing.JOptionPane.showMessageDialog(null,
						"Este profucto no esta disponible, no esta bien escrito o no existe");
				break;
			}
		} while (!Final);
		final double IVA = 0.21;
		double PrecioFinal = añadirIVA(sumarPrecios(Cesta), IVA);
		String Pagar = JOptionPane
				.showInputDialog("El total es de " + PrecioFinal + "€" + "\nCon cuanto piensa pagar?");
		double Pago = Double.parseDouble(Pagar);
		double Cambio = Pago - PrecioFinal;
		double Cambio2 = Math.round(Cambio * 100.0) / 100.0;

		javax.swing.JOptionPane.showMessageDialog(null,
				"El IVA es de " + IVA + "%" + "\nEl precio en bruto es de " + sumarPrecios(Cesta) + "€, y con IVA da "
						+ PrecioFinal + "€" + "\nEl Numero de productos comprados es de " + Cantidad + "\nHas pagado "
						+ Pago + "€" + "\nTu cambio es de " + Cambio2 + "€");
	}

	public static double sumarPrecios(Hashtable<String, Double> productos) {
		double suma = 0.0;

		Enumeration<Double> precios = productos.elements();
		while (precios.hasMoreElements()) {
			suma += precios.nextElement();
		}
		return suma;
	}

	public static double añadirIVA(double precio, double iva) {
		double total1 = precio + (precio * iva);
		double total2 = Math.round(total1 * 100.0) / 100.0;
		return total2;
	}

}
