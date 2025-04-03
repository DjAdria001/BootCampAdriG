package UD09;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String[] movieTitles = {"Movie1", "Movie2", "Movie3", "Movie4", "Movie5"};
        String[] directors = {"Director1", "Director2", "Director3", "Director4", "Director5"};

        Movie movie = new Movie(
                movieTitles[random.nextInt(movieTitles.length)],
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
