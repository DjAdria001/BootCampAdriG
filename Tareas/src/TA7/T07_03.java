package TA7;

import java.util.Hashtable;
import javax.swing.JOptionPane;
import java.util.Enumeration;

public class T07_03 {
	public static void main(String[] args) {
	Hashtable<String, Double> Stock = new Hashtable<>();
	Stock.put("manzana", 2.5);
	Stock.put("pera", 2.5);
	Stock.put("pizza", 4.35);
	Stock.put("salchicha", 6.25);
	Stock.put("lasaña", 5.1);
	Stock.put("piña", 3.0);
	Stock.put("lomo", 4.2);
	Stock.put("berenjena", 2.35);
	Stock.put("platano", 1.25);
	Stock.put("patatas", 5.0);
	String Añadir = JOptionPane.showInputDialog("Que producto desea controlar? "
												+ "\nmanzana pera pizza salchicha lasaña"
												+ "\npiña lomo berenjena platano patatas"
												+ "\nescribe añadir para añadir nuevos productos");
	String producto = Añadir.toLowerCase();
	Stock.put("Manzana", 2.5);
}
}