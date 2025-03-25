import java.util.Random;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Testing {

	public static void main(String[] args) {
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
		
		Enumeration<String> enumeration = Precio. keys() ;
		while (enumeration. hasMoreElements () ) {
		System. out. println ("hashtable valores: " + enumeration. nextElement ()) ;
//			javax.swing.JOptionPane.showMessageDialog(null,"");
		}

	}

}
//		Random NumeroRandom = new Random();
//		String Pregunta = JOptionPane.showInputDialog(" ");
//		int PregNum = Integer.parseInt(Pregunta);
//		javax.swing.JOptionPane.showMessageDialog(null,"");
//	int a=5, b=6;
//	System.out.printf("Numero %d y %d", a , b);//%d es una variable y %n es salto de linea

