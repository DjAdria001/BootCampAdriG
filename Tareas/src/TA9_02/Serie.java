
package TA9_02;

public class Serie extends Entregable {
	private String title;
	private int seasons;
	private boolean isCompleted;
	private String genre;
	private String creator;
	private boolean entregado;

	public Serie() {
		this.title = "Sin Especificar";
		this.seasons = 1;
		this.isCompleted = false;
		this.genre = "Sin Especificar";
		this.creator = "Sin Especificar";
		this.entregado = false;
	}

	public Serie(String title, int seasons, boolean isCompleted, String genre, String creator) {
		this.title = title;
		this.seasons = seasons;
		this.isCompleted = isCompleted;
		this.genre = genre;
		this.creator = creator;
		this.entregado = isEntregado();
	}

	// Getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean completed) {
		isCompleted = completed;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
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

	
	public void compareTo(Entregable otro) {
		if (this.entregado && otro.isEntregado()) {
			System.out.println("Ambos objetos están entregados.");
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
		return "Serie [title=" + title + ", seasons=" + seasons + ", isCompleted=" + isCompleted + ", genre=" + genre
				+ ", creator=" + creator + ", entregado=" + entregado + "]";
	}

}
