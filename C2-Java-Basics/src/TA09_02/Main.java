package TA09_02;

public class Main {

	public static void main(String[] args) {
		Serie DefectoS = new Serie();
		Serie Arcane = new Serie("Arcane", 3, true, "Accion, Drama", "Riot Games");
		Serie Invencible = new Serie("Invencible", 3, true, "Accion", "Robert Kirkman y Ryan Ottley");

		System.out.println("Series:");
		// Defecto
		System.out.println(" Serie por defecto");
		System.out.println(" Titulo: " + DefectoS.getTitulo());
		System.out.println(" Temporadas: " + DefectoS.getSeasons());
		System.out.println(" Entregada: " + DefectoS.isEntregado());
		System.out.println(" Genero: " + DefectoS.getGenero());
		System.out.println(" Creador: " + DefectoS.getCreador());
		System.out.println();
		// Arcane
		System.out.println(" Serie 1");
		System.out.println(" Titulo: " + Arcane.getTitulo());
		System.out.println(" Temporadas: " + DefectoS.getSeasons());
		System.out.println(" Entregada: " + DefectoS.isEntregado());
		System.out.println(" Genero: " + DefectoS.getGenero());
		System.out.println(" Creador: " + Arcane.getCreador());
		System.out.println();
		// Invencible
		System.out.println(" Serie 2");
		System.out.println(" Titulo: " + Invencible.getTitulo());
		System.out.println(" Temporadas: " + Invencible.getSeasons());
		System.out.println(" Entregada: " + Invencible.isEntregado());
		System.out.println(" Genero: " + Invencible.getGenero());
		System.out.println(" Creador: " + Invencible.getCreador());
		System.out.println();
		Videojuego DefectoV = new Videojuego();
		Videojuego Ghostrunner = new Videojuego("GhostRunner", 7, true, "Accion", "One More Level");
		Videojuego Subnautica2 = new Videojuego("Subnautica 2", 30, true, "Supervivencia",
				"Unknown Worlds Entertainment");
		System.out.println("Videojuegos:");
		// Defecto
		System.out.println(" Videojuego por defecto");
		System.out.println(" Titulo: " + DefectoV.getTitle());
		System.out.println(" Temporadas: " + DefectoV.getEstimatedHours() + " horas");
		System.out.println(" Entregada: " + DefectoV.isEntregado());
		System.out.println(" Genero: " + DefectoV.getGenre());
		System.out.println(" Creador: " + DefectoV.getCompany());
		System.out.println();
		// Ghostrunner
		System.out.println(" Videojuego 1");
		System.out.println(" Titulo: " + Ghostrunner.getTitle());
		System.out.println(" Temporadas: " + Ghostrunner.getEstimatedHours() + " horas");
		System.out.println(" Entregada: " + DefectoV.isEntregado());
		System.out.println(" Genero: " + DefectoV.getGenre());
		System.out.println(" Creador: " + DefectoV.getCompany());
		System.out.println();
		// Subnautica2
		System.out.println("Videojuego 2");
		System.out.println(" Titulo: " + Subnautica2.getTitle());
		System.out.println(" Temporadas: " + Subnautica2.getEstimatedHours() + " horas");
		System.out.println(" Entregada: " + DefectoV.isEntregado());
		System.out.println(" Genero: " + Subnautica2.getGenre());
		System.out.println(" Creador: " + Subnautica2.getCompany());
		System.out.println();

	}

}
