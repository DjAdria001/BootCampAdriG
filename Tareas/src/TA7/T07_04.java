package TA7;

import java.util.Hashtable;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

public class T07_04 {

	public static void main(String[] args) {
//Interfaz Empleado
		Hashtable<String, Double> Precio = new Hashtable<>();
		Precio.put("manzana", 2.5);
		Precio.put("pera", 2.5);
		Precio.put("pizza", 4.35);
		Precio.put("salchicha", 6.25);
		Precio.put("lasaña", 5.1);
		Precio.put("piña", 3.0);
		Precio.put("lomo", 4.2);
		Precio.put("berenjena", 2.35);
		Precio.put("platano", 1.25);
		Precio.put("patatas", 5.0);
		Hashtable<String, Integer> Stock = new Hashtable<>();
		Stock.put("manzana", 27);
		Stock.put("pera", 19);
		Stock.put("pizza", 12);
		Stock.put("salchicha", 13);
		Stock.put("lasaña", 20);
		Stock.put("piña", 15);
		Stock.put("lomo", 11);
		Stock.put("berenjena", 15);
		Stock.put("platano", 12);
		Stock.put("patatas", 26);
		Hashtable<String, Double> Cesta = new Hashtable<>();
		boolean Volver = false;
		do {
			String Inicio = JOptionPane
					.showInputDialog("Bienvenido:" + "\nQuien es usted?" + "\n1.Cliente" + "\n2.Empleado");
			String respuesta = Inicio.toLowerCase();

			switch (respuesta) {
//------------------------------------------------------------------------------------------------------------------------
//		Interfaz Usuario
			case "1", "cliente":
				boolean FinCesta = false;
				do {
					String Añadir = JOptionPane.showInputDialog("Bienvenido a la tienda"
							+ "\nQue producto desea comprar?" + "\nescribe final para acabar tu cesta.");
					String producto = Añadir.toLowerCase();
					switch (producto) {
					case "final":
						FinCesta = true;
						break;
					default:
						if (Stock.containsKey(producto)) {
							String PregProd = JOptionPane
									.showInputDialog("Introduzca la cantidad de " + producto + " deseada");
							int PregProd2 = Integer.parseInt(PregProd);
							if (PregProd2 > Stock.get(producto)) {
								javax.swing.JOptionPane.showMessageDialog(null, "No hay suficiente stock");
								break;
							} else if (PregProd2 <= 0) {
								javax.swing.JOptionPane.showMessageDialog(null, "No puede comprar 0 o menos productos");
								break;
							} else {
								double PrecioProducto = Precio.get(producto);
								double PrecioProducto2 = PrecioProducto * PregProd2;
								Cesta.put(producto, PrecioProducto2);
								Stock.put(producto, Stock.get(producto) - PregProd2);
								javax.swing.JOptionPane.showMessageDialog(null, "Ha añadido " + producto + " a su cesta"
										+ "\nEl precio total es de " + PrecioProducto2 + "€");
								break;
							}

						} else {
							javax.swing.JOptionPane.showMessageDialog(null, "No esta bien escrito o no existe.");
						}
						break;
					}
				} while (!FinCesta);
				FinCesta = false;
				final double IVA = 0.21;
				double PrecioFinal = añadirIVA(sumarPrecios(Cesta), IVA);
				String Pagar = JOptionPane
						.showInputDialog("El total es de " + PrecioFinal + "€" + "\nCon cuanto piensa pagar?");
				double Pago = Double.parseDouble(Pagar);
				double Cambio = Pago - PrecioFinal;
				double Cambio2 = Math.round(Cambio * 100.0) / 100.0;
				javax.swing.JOptionPane.showMessageDialog(null, "Gracias por su compra" + "\nEl total es de "
						+ PrecioFinal + "€" + "\nHa pagado con " + Pago + "€" + "\nSu cambio es de " + Cambio2 + "€"+ "\nVuelva pronto");
				Cesta.clear();

				break;
//------------------------------------------------------------------------------------------------------------------------
//		Interfaz Empleado

			case "2", "empleado":
				boolean Acabar = false;
				boolean Final = false;
				Scanner scanner = new Scanner(System.in);
				do {
					System.out.println(
							"2.Que desea hacer?" + "\n a)Consultar o b)Añadir" + "\nEscriba Salir para finalizar");
					System.out.println("");
					String Respuesta = scanner.nextLine().toLowerCase();
					switch (Respuesta) {
					case "consultar", "a":
						do {
							System.out.println("");
							System.out.println("a)Consultar Productos");
							System.out.println(
									"----a1)Que producto desea consultar?" + "\n(((Escriba salir para finalizar)))");
							System.out.print("       ");
							String producto1 = scanner.nextLine().toLowerCase();
							Acabar = false;
							switch (producto1) {
							case "salir":
								Acabar = true;
								break;
							default:
								if (Stock.containsKey(producto1)) {
									System.out.println("");
									System.out.println("		" + producto1.toUpperCase());
									System.out.println("		" + Stock.get(producto1) + " en stock");
									System.out.println("		" + Precio.get(producto1) + "€/u");
									System.out.println("");
								} else {
									System.out.println("");
									System.out.println("		 No está bien escrito o no existe");
									System.out.println("");
								}
								break;
							}
						} while (!Acabar);
						break;
					case "añadir", "b":
						System.out.println("");
						System.out.println("b)Añadir Producto");
						System.out.println("----b1) Introduce el Nombre del Producto nuevo");
						System.out.print("       ");
						String ProductoNuevo = scanner.nextLine().toLowerCase();

						System.out.println("----b2) Introduce el precio por unidad");
						System.out.print("       ");
						String PrecioNuevo = scanner.nextLine();
						double PrecioNuevo2 = Double.parseDouble(PrecioNuevo);

						System.out.println("----b3) Introduce la cantidad de Stock para añadir a almacen");
						System.out.print("       ");
						String StockNuevo = scanner.nextLine();
						int StockNuevo2 = Integer.parseInt(StockNuevo);

						Stock.put(ProductoNuevo.toLowerCase(), StockNuevo2);
						Precio.put(ProductoNuevo.toLowerCase(), PrecioNuevo2);
						System.out.println("");
						break;
					case "salir":
						Final = true;
						break;
					}

				} while (!Final);
				break;
			}
		} while (!Volver);

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
