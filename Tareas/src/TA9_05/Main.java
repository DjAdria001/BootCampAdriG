
package TA9_05;

import java.util.Arrays;
//scanner
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Generate students
		Estudiantes[] estudiantes = {
				new Estudiantes("Pedro", "Pérez", 20, "Hombre", 2.5, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Luis", "Gómez", 21, "Hombre", 9.0, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Carlos", "López", 22, "Hombre", 7.5, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Jorge", "Martínez", 23, "Hombre", 8.0, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Miguel", "Sánchez", 24, "Hombre", 9.5, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Juan", "Ramírez", 25, "Hombre", 7.0, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Ana", "García", 20, "Mujer", 4.0, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("María", "Fernández", 21, "Mujer", 9.0, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Lucía", "Torres", 22, "Mujer", 7.5, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Sofía", "Vásquez", 23, "Mujer", 6.5, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Carmen", "Morales", 24, "Mujer", 9.5, Estudiantes.ConfirmarAsistencia()),
				new Estudiantes("Laura", "Reyes", 25, "Mujer", 7.0, Estudiantes.ConfirmarAsistencia()) };

		// Generate professors
		Profesor profesor1 = new Profesor("Juan", "Apellido", 30, "Hombre", "Matemáticas",
				Profesor.ConfirmarAsistencia());
		Profesor profesor2 = new Profesor("Ana", "Apellido", 30, "Mujer", "Filosofía", Profesor.ConfirmarAsistencia());
		Profesor profesor3 = new Profesor("Luis", "Apellido", 30, "Hombre", "Historia", Profesor.ConfirmarAsistencia());

		// Generate classrooms
		Aula aula1 = new Aula("Matemáticas", profesor1, Arrays.asList(estudiantes));
		Aula aula2 = new Aula("Filosofía", profesor2, Arrays.asList(estudiantes));
		Aula aula3 = new Aula("Historia", profesor3, Arrays.asList(estudiantes));
		boolean continuar = true;
		do {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el aula que desea consultar: ");
		String aulaConsultada = scanner.nextLine();

		switch (aulaConsultada.toLowerCase()) {
		case "matematicas", "aula1":
			if (aula1.puedeDarseClase())

			{
				System.out.println("La clase de " + aula1.getMateria() + " puede darse.");
				System.out.println("	El profesor " + aula1.getProfesor().getNombre() + " está presente.");
				System.out.println("	El aula tiene " + aula1.getAlumnos().size() + " alumnos.");
				aula1.mostrarAprobados();
				System.out.println();

			} else {
				System.out.println("La clase de " + aula1.getMateria() + " no puede darse.");
				System.out.println("La clase de " + aula1.getMateria() + " no puede darse.");
				if (!aula1.getProfesor().getAsistencia()) {
					System.out.println("	El profesor " + aula1.getProfesor().getNombre() + " no está presente.");
				}
				if (aula1.getAlumnos().size() < 6) {
					System.out.println("	El aula tiene " + aula1.getAlumnos().size() + " alumnos.");
				}
				
				System.out.println();
			}

			break;
			
		case "filosofia", "aula2":
			if (aula2.puedeDarseClase()) {
				System.out.println("La clase de " + aula2.getMateria() + " puede darse.");
				System.out.println("	El profesor " + aula2.getProfesor().getNombre() + " está presente.");
				System.out.println("	El aula tiene " + aula2.getAlumnos().size() + " alumnos.");
				aula2.mostrarAprobados();
				System.out.println();
			} else {
				System.out.println("La clase de " + aula2.getMateria() + " no puede darse.");
				if (!aula2.getProfesor().getAsistencia()) {
					System.out.println("	El profesor " + aula2.getProfesor().getNombre() + " no está presente.");
				}
				if (aula2.getAlumnos().size() < 6) {
					System.out.println("	El aula tiene " + aula2.getAlumnos().size() + " alumnos.");
				}
				System.out.println();
			}
			break;
		case "historia", "aula3":

			if (aula3.puedeDarseClase()) {
				System.out.println("La clase de " + aula3.getMateria() + " puede darse.");
				System.out.println("	El profesor " + aula3.getProfesor().getNombre() + " está presente.");
				System.out.println("	El aula tiene " + aula3.getAlumnos().size() + " alumnos.");
				aula3.mostrarAprobados();
				System.out.println();
			} else {
				System.out.println("La clase de " + aula3.getMateria() + " no puede darse.");
				System.out.println("La clase de " + aula3.getMateria() + " no puede darse.");
				if (!aula3.getProfesor().getAsistencia()) {
					System.out.println("	El profesor " + aula3.getProfesor().getNombre() + " no está presente.");
				}
				if (aula3.getAlumnos().size() < 6) {
					System.out.println("	El aula tiene " + aula3.getAlumnos().size() + " alumnos.");
				}
				System.out.println();
			}
			break;
		default:
			System.out.println("Aula no encontrada");
			break;
		}
		}while(continuar);
		
		
		




	}

}
