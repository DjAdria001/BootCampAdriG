
package TA09_03;

public class Libro {
	private long ISBN;
	private String titulo;
	private String autor;
	private int numPaginas;

	public Libro(long ISBN, String titulo, String autor, int numPaginas) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	public long getISBN() {
		return ISBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getNumPaginas() {
		return numPaginas;
	}
}
