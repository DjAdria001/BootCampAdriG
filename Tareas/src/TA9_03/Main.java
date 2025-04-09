
package TA9_03;

public class Main {

	public static void main(String[] args) {
		Libro Libro1 = new Libro(9788466341620L, "El Quijote", "Cervantes", 1000);
		
		Libro Libro2 = new Libro(2394710475488L, "Geronimo Stilton", "Elisabetta Dami", 230);

		// Imprimir los libros
		System.out.println(toString(Libro1));
		System.out.println(toString(Libro2));

		// Comprobar cuál tiene más páginas
		if (Libro1.getNumPaginas() > Libro2.getNumPaginas()) {
			System.out.println("El libro con más páginas es: " + Libro1.getTitulo());
		} else if (Libro1.getNumPaginas() < Libro2.getNumPaginas()) {
			System.out.println("El libro con más páginas es: " + Libro2.getTitulo());
		} else {
			System.out.println("Ambos libros tienen el mismo número de páginas.");
		}
	}

	public static String toString(Libro libro) {
		return "El Libro " + libro.getTitulo() + ", con ISBN " + libro.getISBN() + ", creado por " + libro.getAutor()
				+ ", tiene " + libro.getNumPaginas() + " páginas.";
	}
}
