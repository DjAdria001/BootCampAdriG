package UD09;

import java.util.Random;

public class Cinema {
    private Seat[][] seats;
    private Movie currentMovie;
    private double ticketPrice;

    public Cinema(Movie movie, double ticketPrice) {
        this.currentMovie = movie;
        this.ticketPrice = ticketPrice;
        this.seats = new Seat[8][9];
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(i + 1, (char) ('A' + j));
            }
        }
    }

    public boolean seatSpectator(Spectator spectator) {
        if (spectator.getMoney() < ticketPrice || spectator.getAge() < currentMovie.getMinAge()) {
            return false;
        }

        Random random = new Random();
        while (true) {
            int row = random.nextInt(8);
            int col = random.nextInt(9);
            if (!seats[row][col].isOccupied()) {
                seats[row][col].occupy(spectator);
                return true;
            }
        }
    }

    public void printSeats() {
        for (int i = seats.length - 1; i >= 0; i--) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}