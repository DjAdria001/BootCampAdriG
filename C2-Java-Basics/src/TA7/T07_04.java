package TA7;

import java.util.Hashtable;
import javax.swing.JOptionPane;
import java.util.Enumeration;

public class T07_04 {

	public static void main(String[] args) {
		Hashtable<String, Double> Precio = inicializarPrecios();
		Hashtable<String, Integer> Stock = inicializarStock();
		Hashtable<String, Double> Cesta = new Hashtable<>();

		ejecutarAplicacion(Precio, Stock, Cesta);
	}

	private static void ejecutarAplicacion(Hashtable<String, Double> Precio, Hashtable<String, Integer> Stock,
			Hashtable<String, Double> Cesta) {
		boolean Volver = false;
		do {
			String Inicio = JOptionPane
					.showInputDialog("Bienvenido:\n¿Quién es usted?\n1.Cliente\n2.Empleado\n3.Salir");
			String respuesta = Inicio != null ? Inicio.toLowerCase() : "";

			switch (respuesta) {
			case "1", "cliente":
				interfazCliente(Precio, Stock, Cesta);
				break;
			case "2", "empleado":
				interfazEmpleado(Stock, Precio);
				break;
			case "3", "salir":
				Volver = true;
				JOptionPane.showMessageDialog(null, "Gracias por su visita.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
			}
		} while (!Volver);
	}

	private static Hashtable<String, Double> inicializarPrecios() {
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
		return Precio;
	}

	private static Hashtable<String, Integer> inicializarStock() {
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
		return Stock;
	}

	private static void interfazCliente(Hashtable<String, Double> Precio, Hashtable<String, Integer> Stock,
			Hashtable<String, Double> Cesta) {
		boolean FinCesta = false;
		do {
			String Añadir = JOptionPane.showInputDialog(
					"Bienvenido a la tienda:\n¿Qué producto desea comprar?\nEscriba 'final' para acabar su cesta.");
			String producto = Añadir != null ? Añadir.toLowerCase() : "";

			if ("final".equals(producto)) {
				FinCesta = true;
			} else if (Stock.containsKey(producto)) {
				procesarProductoCliente(producto, Precio, Stock, Cesta);
			} else {
				JOptionPane.showMessageDialog(null, "No está bien escrito o no existe.");
			}
		} while (!FinCesta);

		finalizarCompra(Cesta);
	}

	private static void procesarProductoCliente(String producto, Hashtable<String, Double> Precio,
			Hashtable<String, Integer> Stock, Hashtable<String, Double> Cesta) {
		String PregProd = JOptionPane.showInputDialog("Introduzca la cantidad de " + producto + " deseada:");
		int PregProd2 = Integer.parseInt(PregProd);
		if (PregProd2 > Stock.get(producto)) {
			JOptionPane.showMessageDialog(null, "No hay suficiente stock.");
		} else if (PregProd2 <= 0) {
			JOptionPane.showMessageDialog(null, "No puede comprar 0 o menos productos.");
		} else {
			double PrecioProducto = Precio.get(producto);
			double PrecioProducto2 = PrecioProducto * PregProd2;
			Cesta.put(producto, PrecioProducto2);
			Stock.put(producto, Stock.get(producto) - PregProd2);
			JOptionPane.showMessageDialog(null,
					"Ha añadido " + producto + " a su cesta.\nEl precio total es de " + PrecioProducto2 + "€.");
		}
	}

	private static void finalizarCompra(Hashtable<String, Double> Cesta) {
		final double IVA = 0.21;
		double PrecioFinal = añadirIVA(sumarPrecios(Cesta), IVA);
		double Pago;
		do {
			String Pagar = JOptionPane
					.showInputDialog("El total es de " + PrecioFinal + "€.\n¿Con cuánto piensa pagar?");
			Pago = Double.parseDouble(Pagar);
		} while (Pago < PrecioFinal);

		double Cambio = Math.round((Pago - PrecioFinal) * 100.0) / 100.0;
		JOptionPane.showMessageDialog(null, "Gracias por su compra.\nEl total es de " + PrecioFinal
				+ "€.\nHa pagado con " + Pago + "€.\nSu cambio es de " + Cambio + "€.\n¡Vuelva pronto!");
		Cesta.clear();

	}

	private static void interfazEmpleado(Hashtable<String, Integer> Stock, Hashtable<String, Double> Precio) {
		boolean Final = false;
		do {
			String Respuesta = JOptionPane.showInputDialog(
					"Interfaz Empleado:\n¿Qué desea hacer?\n1. Consultar Productos\n2. Añadir Producto"
					+ "\nEscriba 'salir' para finalizar.");
			Respuesta = Respuesta != null ? Respuesta.toLowerCase() : "";

			switch (Respuesta) {
			case "1", "consultar":
				consultarProductos(Stock, Precio);
				break;
			case "2", "añadir":
				añadirProducto(Stock, Precio);
				break;
			case "salir":
				Final = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción no válida.");
			}
		} while (!Final);
	}

	private static void consultarProductos(Hashtable<String, Integer> Stock, Hashtable<String, Double> Precio) {
		StringBuilder productos = new StringBuilder();
		for (String producto : Stock.keySet()) {
			productos.append(producto.toUpperCase()).append(": ").append(Stock.get(producto)).append(" unidades, ")
					.append(Precio.get(producto)).append("€/u\n");
		}
		JOptionPane.showMessageDialog(null, productos.toString());
	}

	private static void añadirProducto(Hashtable<String, Integer> Stock, Hashtable<String, Double> Precio) {
		String ProductoNuevo = JOptionPane.showInputDialog("Introduce el nombre del producto nuevo:");
		String PrecioNuevo = JOptionPane.showInputDialog("Introduce el precio por unidad:");
		double PrecioNuevo2 = Double.parseDouble(PrecioNuevo);

		String StockNuevo = JOptionPane.showInputDialog("Introduce la cantidad de stock para añadir al almacén:");
		int StockNuevo2 = Integer.parseInt(StockNuevo);

		Precio.put(ProductoNuevo.toLowerCase(), PrecioNuevo2);
		Stock.put(ProductoNuevo.toLowerCase(), StockNuevo2);
		JOptionPane.showMessageDialog(null, "Producto añadido correctamente.");
	}

	private static double sumarPrecios(Hashtable<String, Double> productos) {
		double suma = 0.0;
		Enumeration<Double> precios = productos.elements();
		while (precios.hasMoreElements()) {
			suma += precios.nextElement();
		}
		return suma;
	}

	private static double añadirIVA(double precio, double iva) {
		double total = precio + (precio * iva);
		return Math.round(total * 100.0) / 100.0;
	}
}