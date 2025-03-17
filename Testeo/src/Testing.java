import java.util.Random;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Testing {

	public static void main(String[] args) {
		ArrayList<String> Producto = new ArrayList<>();
		Producto.add("Hola");
		Producto.add("Hola2");
		Hashtable<Object, String> Stock = new Hashtable<>();
		Stock.put(Producto.get(0), "Manzana");
		Stock.put(Producto.get(1), "Pera");
		Hashtable<Object, String> Stock2 = new Hashtable<>();
		Stock.put(Stock.get(0), "Manzana2");
		Stock.put(Stock.get(1), "Pera2");
		
		System.out.println(Stock2);
	}

}
//		Random NumeroRandom = new Random();
//		String Pregunta = JOptionPane.showInputDialog(" ");
//		int PregNum = Integer.parseInt(Pregunta);
//		javax.swing.JOptionPane.showMessageDialog(null,"");
//	int a=5, b=6;
//	System.out.printf("Numero %d y %d", a , b);//%d es una variable y %n es salto de linea




//switch (producto1) {
//	case "manzana", "manzanas":
//		System.out.println("");
//		System.out.println("Manzanas");
//		System.out.println(Stock.get("manzana") + " en stock");
//		System.out.println(Precio.get("manzana") + "€/u");
//		System.out.println("");
//		break;
//	case "pera", "peras":
//		System.out.println("");
//		System.out.println("Peras");
//		System.out.println(Stock.get("pera") + " en stock");
//		System.out.println(Precio.get("pera") + "€/u");
//		System.out.println("");
//		break;
//	case "pizza", "pizzas":
//		System.out.println("");
//		System.out.println("Pizzas");
//		System.out.println(Stock.get("pizza") + " en stock");
//		System.out.println(Precio.get("pizza") + "€/u");
//		System.out.println("");
//		break;
//	case "salchicha", "salchichas":
//		System.out.println("");
//		System.out.println("Salchichas");
//		System.out.println(Stock.get("salchicha") + " en stock");
//		System.out.println(Precio.get("salchicha") + "€/u");
//		System.out.println("");
//		break;
//	case "lasaña", "lasañas":
//		System.out.println("");
//		System.out.println("Lasañas");
//		System.out.println(Stock.get("lasaña") + " en stock");
//		System.out.println(Precio.get("lasaña") + "€/u");
//		System.out.println("");
//		break;
//	case "piña", "piñas":
//		System.out.println("");
//		System.out.println("Piñas");
//		System.out.println(Stock.get("piña") + " en stock");
//		System.out.println(Precio.get("piña") + "€/u");
//		System.out.println("");
//		break;
//	case "lomo", "lomos":
//		System.out.println("");
//		System.out.println("Lomos");
//		System.out.println(Stock.get("lomo") + " en stock");
//		System.out.println(Precio.get("lomo") + "€/u");
//		System.out.println("");
//		break;
//	case "berenjena", "berenjenas":
//		System.out.println("");
//		System.out.println("Berenjenas");
//		System.out.println(Stock.get("berenjena") + " en stock");
//		System.out.println(Precio.get("berenjena") + "€/u");
//		System.out.println("");
//		break;
//	case "platano", "platanos":
//		System.out.println("");
//		System.out.println("Plátanos");
//		System.out.println(Stock.get("platano") + " en stock");
//		System.out.println(Precio.get("platano") + "€/u");
//		System.out.println("");
//		break;
//	case "patata", "patatas":
//		System.out.println("");
//		System.out.println("Patatas");
//		System.out.println(Stock.get("patatas") + " en stock");
//		System.out.println(Precio.get("patatas") + "€/u");
//		System.out.println("");
//		break;					
//	case "añadir":
//		añadir = true;
//		break;
//	default:
//		System.out.println("");
//		System.out.println("No está bien escrito o no existe");
//		System.out.println("");
//		break;
//	}

