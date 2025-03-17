package TA7;

import java.util.Hashtable;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

public class T07_03 {
	public static void main(String[] args) {
		ArrayList<String> Producto = new ArrayList<>();
		Producto.add("manzana");
		Hashtable<Object, Double> Precio = new Hashtable<>();
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
		boolean Acabar = false;
		boolean Final = false;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Que desea hacer?" + "\n Controlar o Añadir");
			System.out.println("");
			String Respuesta = scanner.nextLine().toLowerCase();
			switch (Respuesta) {
			case "controlar":
				do {
					System.out.println("");
					System.out.println("Que producto desea controlar?"
					+ "\nEscriba salir para finalizar");
					String producto1 = scanner.nextLine().toLowerCase();
					Acabar = false;
					switch (producto1) {
					case "manzana", "manzanas":
						System.out.println("");
						System.out.println("Manzanas");
						System.out.println(Stock.get("manzana") + " en stock");
						System.out.println(Precio.get("manzana") + "€/u");
						System.out.println("");
						break;
					case "pera", "peras":
						System.out.println("");
						System.out.println("Peras");
						System.out.println(Stock.get("pera") + " en stock");
						System.out.println(Precio.get("pera") + "€/u");
						System.out.println("");
						break;
					case "pizza", "pizzas":
						System.out.println("");
						System.out.println("Pizzas");
						System.out.println(Stock.get("pizza") + " en stock");
						System.out.println(Precio.get("pizza") + "€/u");
						System.out.println("");
						break;
					case "salchicha", "salchichas":
						System.out.println("");
						System.out.println("Salchichas");
						System.out.println(Stock.get("salchicha") + " en stock");
						System.out.println(Precio.get("salchicha") + "€/u");
						System.out.println("");
						break;
					case "lasaña", "lasañas":
						System.out.println("");
						System.out.println("Lasañas");
						System.out.println(Stock.get("lasaña") + " en stock");
						System.out.println(Precio.get("lasaña") + "€/u");
						System.out.println("");
						break;
					case "piña", "piñas":
						System.out.println("");
						System.out.println("Piñas");
						System.out.println(Stock.get("piña") + " en stock");
						System.out.println(Precio.get("piña") + "€/u");
						System.out.println("");
						break;
					case "lomo", "lomos":
						System.out.println("");
						System.out.println("Lomos");
						System.out.println(Stock.get("lomo") + " en stock");
						System.out.println(Precio.get("lomo") + "€/u");
						System.out.println("");
						break;
					case "berenjena", "berenjenas":
						System.out.println("");
						System.out.println("Berenjenas");
						System.out.println(Stock.get("berenjena") + " en stock");
						System.out.println(Precio.get("berenjena") + "€/u");
						System.out.println("");
						break;
					case "platano", "platanos":
						System.out.println("");
						System.out.println("Plátanos");
						System.out.println(Stock.get("platano") + " en stock");
						System.out.println(Precio.get("platano") + "€/u");
						System.out.println("");
						break;
					case "patata", "patatas":
						System.out.println("");
						System.out.println("Patatas");
						System.out.println(Stock.get("patatas") + " en stock");
						System.out.println(Precio.get("patatas") + "€/u");
						System.out.println("");
						break;
					case "salir":
						Acabar = true;
						break;
					default:
						if (Stock.containsKey(producto1)) {
							System.out.println("");
							System.out.println(producto1.toUpperCase());
							System.out.println(Stock.get(producto1) + " en stock");
							System.out.println(Precio.get(producto1) + "€/u");
							System.out.println("");
						} else {
							System.out.println("");
							System.out.println("No está bien escrito o no existe");
							System.out.println("");
						}
						break;
					}
				} while (!Acabar);
				break;
			case "añadir":
				String ProductoNuevo = JOptionPane.showInputDialog("Introduce el Nombre del Producto nuevo");
				String PrecioNuevo = JOptionPane.showInputDialog("Introduce el precio por unidad");
				double PrecioNuevo2 = Double.parseDouble(PrecioNuevo);
				String StockNuevo = JOptionPane
						.showInputDialog("Introduce la cantidad de Stock" + "\npara añadir a almacen");
				int StockNuevo2 = Integer.parseInt(StockNuevo);
				Stock.put(ProductoNuevo.toLowerCase(), StockNuevo2);
				Precio.put(ProductoNuevo.toLowerCase(), PrecioNuevo2);
				break;
			}

		} while (!Final);
	}
}