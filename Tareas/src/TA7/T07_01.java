package TA7;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class T07_01 {
	public static void main(String[] args) {
		ArrayList<Integer> Notas = new ArrayList<>();
//		ArrayList<String> Alumnos= new ArrayList<>();
		String Pregunta = JOptionPane.showInputDialog("Cuantos alumnos hay?");
		int PregNum = Integer.parseInt(Pregunta);
		Hashtable<String,Integer> Clase=new Hashtable<String,Integer>();
		int i = 0;
//		int j = 1;
		while (i < PregNum) {
			int PregNum2;
			String PregNombre = JOptionPane.showInputDialog("Como se llama el Alumno?");
//			Alumnos.add(PregNombre);
			do {
				String Pregunta2 = JOptionPane.showInputDialog("Cual es la nota de " + (PregNombre)+"?");
				PregNum2 = Integer.parseInt(Pregunta2);
			} while (PregNum2 > 10 || PregNum2 < 0);
			Notas.add(PregNum2);
			Clase.put(PregNombre, PregNum2);
			i++;

		}
		  Enumeration<String> keys = Clase.keys();
		  while (keys.hasMoreElements()) {
		   String Nombre = keys.nextElement();
		   Integer Nota = Clase.get(Nombre);
		   System.out.println("Alumno: " + Nombre + ", Nota: " + Nota);
		  }
		
//		for (Object o : Notas) {
//			System.out.println("La nota del alumno" + j + " es " + o);
//			j++;
//		}
		System.out.println("La nota media de la clase es "+(Media(Notas)));
	}
	 public static double Media(ArrayList<Integer> notas) {
		  int suma = 0;
		  for (int nota : notas) {
		   suma += nota;
		  }
		  return (double) suma / notas.size();
		 }
}