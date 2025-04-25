
package TA09_02;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Ejecutable {
	Serie[] series = new Serie[5];
	{
		series[0] = new Serie("Brooklyn Nine-Nine", 8, true, "Comedia", "Dan Goor y Michael Schur");
		series[1] = new Serie("Arcane", 3, true, "Drama", "Riot Games");
		series[2] = new Serie("Invencible", 3, true, "Accion", "Robert Kirkman y Ryan Ottley");
		series[3] = new Serie("Jujutsu Kaisen", 2, true, "Accion", "Gege Akutami");
		series[4] = new Serie("Chainsaw-Man", 1, true, "Accion", "Tatsuki Fujimoto");
	}

	Videojuego[] videojuegos = new Videojuego[5];
	{
		videojuegos[0] = new Videojuego("R.E.P.O", 10, true, "Accion", "Semiwork");
		videojuegos[1] = new Videojuego("GhostRunner", 7, false, "Accion", "One More Level");
		videojuegos[2] = new Videojuego("Subnautica 2", 30, true, "Supervivencia", "Unknown Worlds Entertainment");
		videojuegos[3] = new Videojuego("Astro-Bot", 10, true, "Plataformas", "Team Asobi");
		videojuegos[4] = new Videojuego("Pokemon Purpura", 20, true, "RPG", "Game Freak");
	}

	public static void main(String[] args) {
		Ejecutable ejecutable = new Ejecutable();

		// Deliver some series and video games
		ejecutable.series[1].entregar();
		ejecutable.series[3].entregar();
		ejecutable.videojuegos[1].entregar();
		ejecutable.videojuegos[4].entregar();

		// Print the delivery status
		System.out.println("Entregas");
		System.out.println("Series");
		for (Serie serie : ejecutable.series) {
			System.out.println("Serie: " + serie.getTitulo() + " - Entregado: " + serie.isEntregado());
		}
		System.out.println();
		System.out.println("Videojuegos");
		for (Videojuego videojuego : ejecutable.videojuegos) {
			System.out.println("Videojuego: " + videojuego.getTitle() + " - Entregado: " + videojuego.isEntregado());
		}
		System.out.println("El videojuego con más horas estimadas es: " + ejecutable.videojuegos[2].getTitle());
	}
}
