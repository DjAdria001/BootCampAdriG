package TA7;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;
public class T07_04 {

	public static void main(String[] args) {
//Interfaz Empleado
//		int StockP;
//		double PrecioP;
//		Hashtable<Integer, Double> Conjunto=new Hashtable<>();
//		Conjunto.put(StockP, PrecioP);
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
		boolean Acabar = false;
		boolean Final = false;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1.Que desea hacer?" 
								+ "\n a)Consultar o b)Añadir");
			System.out.println("");
			String Respuesta = scanner.nextLine().toLowerCase();
			switch (Respuesta) {
			case "consultar","a":
				do {
					System.out.println("");
					System.out.println("a)Consultar Productos");
					System.out.println("----a1)Que producto desea consultar?"
					+ "\n(((Escriba salir para finalizar)))");
					System.out.print("       ");
					String producto1 = scanner.nextLine().toLowerCase();
					Acabar = false;
					switch (producto1) {
					case "salir":
						Acabar=true;
						break;
					default:
						if (Stock.containsKey(producto1)) {
							System.out.println("");
							System.out.println("		"+producto1.toUpperCase());
							System.out.println("		"+Stock.get(producto1) + " en stock");
							System.out.println("		"+Precio.get(producto1) + "€/u");
							System.out.println("");
						}else {
							System.out.println("");
							System.out.println("		 No está bien escrito o no existe");
							System.out.println("");
						}
						break;
					}
				} while (!Acabar);
				break;
			case "añadir","b":
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
			}

		} while (!Final);
//------------------------------------------------------------------------------------------------------------------------
//		Interfaz Usuario
		Hashtable<String, Double> Cesta = new Hashtable<>();
		String Añadir = JOptionPane.showInputDialog("Que producto desea comprar? "
				+ "\nmanzana pera pizza salchicha lasaña huevos" + "\nescribe final para acabar tu cesta.");
		String producto = Añadir.toLowerCase();
		
		
	}

}
