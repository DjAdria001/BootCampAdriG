
package TA9_06;

public class Cinema {
	private Movie movie;
	private double ticketPrice;
	private String[][] seats;

	public Cinema(Movie movie, double ticketPrice) {
		this.movie = movie;
		this.ticketPrice = ticketPrice;
		this.seats = new String[8][9];
		initializeSeats();
	}

	private void initializeSeats() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = (i + 1) + "" + (char) ('A' + j);
			}
		}
		seats[5][4] = "XX";
		seats[5][5] = "XX";
	}

	public String getSeatsString() {
		StringBuilder sb = new StringBuilder();
		for (String[] row : seats) {
			for (String seat : row) {
				sb.append(seat).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public boolean isSeatAvailable(String seat) {
		for (String[] row : seats) {
			for (String s : row) {
				if (s.equals(seat)) {
					return !s.equals("XX");
				}
			}
		}
		return false;
	}

	public void occupySeat(String seat) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].equals(seat)) {
					seats[i][j] = "XX";
				}
			}
		}
	}
}
