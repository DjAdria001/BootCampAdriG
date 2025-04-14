
package TA9_05;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// Generate 18 students (9 male, 9 female)
		ArrayList<Estudiantes> alumnos = new ArrayList<>();
		String[] nombresHombres = { "Pedro", "Luis", "Carlos", "Jorge", "Miguel", "Juan", "Andrés", "Diego", "Manuel" };
		String[] nombresMujeres = { "Ana", "María", "Lucía", "Sofía", "Carmen", "Laura", "Elena", "Isabel", "Paula" };
		Random random = new Random();

		for (int i = 0; i < 9; i++) {
			alumnos.add(new Alumno(nombresHombres[i], 'M'));
			alumnos.add(new Alumno(nombresMujeres[i], 'F'));
		}

		// Generate 3 professors (one per subject)
		Profesor profesor1 = new Profesor("Juan","Apellido",30,"Hombre", "Matemáticas");
		Profesor profesor2 = new Profesor("Ana","Apellido",30,"Mujer", "Filosofía");
		Profesor profesor3 = new Profesor("Luis","Apellido",30,"Hombre", "Historia");

		// Generate 3 classrooms (one per subject)
		Aula aula1 = new Aula("Matemáticas", profesor1, alumnos.subList(0, 6)); // First 6 students
		Aula aula2 = new Aula("Filosofía", profesor2, alumnos.subList(6, 12)); // Next 6 students
		Aula aula3 = new Aula("Historia", profesor3, alumnos.subList(12, 18)); // Last 6 students

		// Output the generated data
		System.out.println("Aula 1: " + aula1.getMateria() + " - Profesor: " + profesor1.getMateria());
		System.out.println("Aula 2: " + aula2.getMateria() + " - Profesor: " + profesor2.getMateria());
		System.out.println("Aula 3: " + aula3.getMateria() + " - Profesor: " + profesor3.getMateria());
	}
}
