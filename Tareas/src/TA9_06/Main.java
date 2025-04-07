

package TA9_06;

import javax.swing.JOptionPane;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] movieTitles = {"Torrente", "Avatar", "Titanic", "Ready Player One", "El resplandor"};
        String[] directors = {"Director1", "Director2", "Director3", "Director4", "Director5"};

        String selectedMovieTitle = (String) JOptionPane.showInputDialog(
                null,
                "Select a movie to watch:",
                "Movie Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                movieTitles,
                movieTitles[0]
        );
        boolean validSelection = false;
        do {
        if (selectedMovieTitle == null) {
            System.out.println("No movie selected. Exiting.");
            return;
		} else if (selectedMovieTitle == "Torrente") {
			Movie movie = new Movie("Torrente", 120, 18, "Santiago Segura");
			int opcion = JOptionPane.showConfirmDialog(null, 
				    "nombre de película: " + movie.getTitle() + "\n" 
				    + "duración: " + movie.getDuration() + "\n"
				    + "edad mínima: " + movie.getMinAge() + "\n"
				    + "director: " + movie.getDirector() + "\n\n" 
				    + "¿Desea ver esta película?", 
				    "Confirmación", 
				    JOptionPane.YES_NO_OPTION);

				if (opcion == JOptionPane.YES_OPTION) {
				    System.out.println("¡Genial! Disfruta de la película.");
				    validSelection = true;
				} else {
				    System.out.println("Tal vez la próxima vez.");
				}
			return;
		}else if (selectedMovieTitle == "Avatar") {
			Movie movie = new Movie("Avatar", 150, 12, "James Cameron");
			int opcion = JOptionPane.showConfirmDialog(null,
					"nombre de película: " + movie.getTitle() + "\n" + "duración: " + movie.getDuration() + "\n"
							+ "edad mínima: " + movie.getMinAge() + "\n" + "director: " + movie.getDirector() + "\n\n"
							+ "¿Desea ver esta película?",
					"Confirmación", JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {
				System.out.println("¡Genial! Disfruta de la película.");
				validSelection = true;
			} else {
				System.out.println("Tal vez la próxima vez.");
			}
			return;
		}else if (selectedMovieTitle == "Titanic") {
			Movie movie = new Movie("Titanic", 195, 12, "James Cameron");
			int opcion = JOptionPane.showConfirmDialog(null,
					"nombre de película: " + movie.getTitle() + "\n" + "duración: " + movie.getDuration() + "\n"
							+ "edad mínima: " + movie.getMinAge() + "\n" + "director: " + movie.getDirector() + "\n\n"
							+ "¿Desea ver esta película?",
					"Confirmación", JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {
				System.out.println("¡Genial! Disfruta de la película.");
				validSelection = true;
			} else {
				System.out.println("Tal vez la próxima vez.");
			}
			return;
		}else if (selectedMovieTitle == "Ready Player One") {
			Movie movie = new Movie("Ready Player One", 140, 12, "Steven Spielberg");
			int opcion = JOptionPane.showConfirmDialog(null,
					"nombre de película: " + movie.getTitle() + "\n" + "duración: " + movie.getDuration() + "\n"
							+ "edad mínima: " + movie.getMinAge() + "\n" + "director: " + movie.getDirector() + "\n\n"
							+ "¿Desea ver esta película?",
					"Confirmación", JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {
				System.out.println("¡Genial! Disfruta de la película.");
				validSelection = true;
			} else {
				System.out.println("Tal vez la próxima vez.");
			}
			return;
		}else if (selectedMovieTitle == "El resplandor") {
			Movie movie = new Movie("El resplandor", 144, 18, "Stanley Kubrick");
			int opcion = JOptionPane.showConfirmDialog(null,
					"nombre de película: " + movie.getTitle() + "\n" + "duración: " + movie.getDuration() + "\n"
							+ "edad mínima: " + movie.getMinAge() + "\n" + "director: " + movie.getDirector() + "\n\n"
							+ "¿Desea ver esta película?",
					"Confirmación", JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {
				System.out.println("¡Genial! Disfruta de la película.");
				validSelection = true;
			} else {
				System.out.println("Tal vez la próxima vez.");
			}
			return;
		}} while (validSelection == false);

        Random random = new Random();
        Movie movie = new Movie(
                selectedMovieTitle,
                60 + random.nextInt(121),
                12 + random.nextInt(7),
                directors[random.nextInt(directors.length)]
        );

        double ticketPrice = 5 + random.nextInt(6);
        Cinema cinema = new Cinema(movie, ticketPrice);

        for (int i = 0; i < 100; i++) {
            Spectator spectator = new Spectator(
                    "Spectator" + (i + 1),
                    10 + random.nextInt(50),
                    5 + random.nextInt(16)
            );
            cinema.seatSpectator(spectator);
        }

        cinema.printSeats();
    }
}