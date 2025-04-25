
package TA09_02;

public class Videojuego extends Entregable {
	private String title;
	private int estimatedHours;
	private String genre;
	private String company;
	private boolean entregado;

	public Videojuego() {
		this.title = "Sin Especificar";
		this.estimatedHours = 10;
		this.genre = "Sin Especificar";
		this.company = "Sin Especificar";
		this.entregado = false;
	}

	public Videojuego(String title, int estimatedHours,boolean Entregado, String genre, String company) {
		this.title = title;
		this.estimatedHours = estimatedHours;
		this.genre = genre;
		this.company = company;
		this.entregado = isEntregado();
	}

	// Getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCompany() {
        return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void entregar() {
		this.entregado = true;
	}

    @Override
	public void devolver() {
		this.entregado = false;
	}

	@Override
	public boolean isEntregado() {
		return entregado;
	}

	@Override
	public void compareTo(Entregable otro) {
		if (this.entregado && otro.isEntregado()) {
		} else if (this.entregado) {
			System.out.println("Este objeto está entregado.");
		} else if (otro.isEntregado()) {
			System.out.println("El otro objeto está entregado.");
		} else {
			System.out.println("Ninguno de los objetos está entregado.");
		}
	}

	@Override
	public String toString() {
		return "Videojuego [title=" + title + ", estimatedHours=" + estimatedHours + ", genre=" + genre + ", company="
				+ company + ", entregado=" + entregado + "]";
	}
}
