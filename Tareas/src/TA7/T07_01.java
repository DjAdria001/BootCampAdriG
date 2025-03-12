package TA7;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class T07_01 {
	public static void main(String[] args) {
		ArrayList<Integer> Notas = new ArrayList<>();
		String Pregunta = JOptionPane.showInputDialog("Cuantos alumnos hay?");
		int PregNum = Integer.parseInt(Pregunta);
		int i = 0;
		int j = 1;

		while (i < PregNum) {
			int PregNum2;
			do {
				String Pregunta2 = JOptionPane.showInputDialog("Cual es la nota del alumno " + (i + 1));
				PregNum2 = Integer.parseInt(Pregunta2);
			} while (PregNum2 > 10 || PregNum2 < 0);
			Notas.add(PregNum2);

			i++;

		}
		
		for (Object o : Notas) {
			System.out.println("La nota del alumno " + j + " es " + o);
			j++;
		}
	}

}