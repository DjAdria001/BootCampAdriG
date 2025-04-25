
package TA09_02;

public class Serie extends Entregable {
	private String Titulo;
	private int Temporadas;
	private String Genero;
	private String Creador;
	private boolean entregado;

	public Serie() {
		this.Titulo = "Sin Especificar";
		this.Temporadas = 1;

		this.Genero = "Sin Especificar";
		this.Creador = "Sin Especificar";
		this.entregado = false;
	}

	public Serie(String title, int seasons, boolean isEntregado, String genre, String creator) {
		this.Titulo = title;
		this.Temporadas = seasons;

		this.Genero = genre;
		this.Creador = creator;
		this.entregado = isEntregado();
	}

	// Getters and setters
	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}

	public int getSeasons() {
		return Temporadas;
	}

	public void setSeasons(int temporadas) {
		this.Temporadas = temporadas;
	}



	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		this.Genero = genero;
	}

	public String getCreador() {
		return Creador;
	}
	
	public void setCreador(String creador) {
		this.Creador = creador;
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
		return "Serie [title=" + Titulo + ", seasons=" + Temporadas + ", genre=" + Genero
				+ ", creator=" + Creador + ", entregado=" + entregado + "]";
	}

}
