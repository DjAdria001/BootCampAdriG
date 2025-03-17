
import java.util.Hashtable;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

public class Hola {
	public static void main(String[] args) {
		Hashtable<Integer, Double>  Valores = new Hashtable<>();
		Valores.put(7, 2.6);
		Hashtable<String, Object> Producto = new Hashtable<>();
		Producto.put("manzana", Valores);
		System.out.println(Producto.get(7));
		
		

}
}
