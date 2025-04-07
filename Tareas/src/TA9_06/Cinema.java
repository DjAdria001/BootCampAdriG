
package TA9_06;

import java.util.Random;

public class Cinema {
	private Seat[][] seats; // Matriz de asientos del cine
	private Movie currentMovie; // Película actual que se está proyectando
	private double ticketPrice; // Precio del boleto

	// Constructor que inicializa la película actual, el precio del boleto y los
	// asientos
	public Cinema(Movie movie, double ticketPrice) {
		this.currentMovie = movie;
		this.ticketPrice = ticketPrice;
		this.seats = new Seat[8][9]; // Inicializa una matriz de 8 filas y 9 columnas de asientos
		initializeSeats(); // Llama al método para inicializar los asientos
	}

	// Método para inicializar los asientos
	private void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(i + 1, (char) ('A' + j)); // Crea un nuevo asiento con la fila y columna correspondientes
            }
        }
    }

	// Método para sentar a un espectador
	public boolean seatSpectator(Spectator spectator) {
		// Verifica si el espectador tiene suficiente dinero y cumple con la edad mínima
		if (spectator.getMoney() < ticketPrice || spectator.getAge() < currentMovie.getMinAge()) {
			return false; // Si no cumple, retorna false
		}

		Random random = new Random();
		while (true) {
			int row = random.nextInt(8); // Genera un número aleatorio para la fila
			int col = random.nextInt(9); // Genera un número aleatorio para la columna
			if (!seats[row][col].isOccupied()) { // Verifica si el asiento no está ocupado
				seats[row][col].occupy(spectator); // Ocupa el asiento con el espectador
				return true; // Retorna true indicando que el espectador fue sentado
			}
		}
	}

	// Método para imprimir el estado de los asientos
	public void printSeats() {
		for (int i = seats.length - 1; i >= 0; i--) { // Recorre las filas de abajo hacia arriba
			for (int j = 0; j < seats[i].length; j++) { // Recorre las columnas
				System.out.print(seats[i][j] + " "); // Imprime el estado del asiento
			}
			System.out.println(); // Salto de línea después de cada fila
		}
	}
}
