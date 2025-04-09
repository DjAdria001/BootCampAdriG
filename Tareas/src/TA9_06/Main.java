
package TA9_06;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String[] movieTitles = { "Torrente", "Avatar", "Titanic", "Ready Player One", "El resplandor" };

		while (true) {
			String selectedMovieTitle = (String) JOptionPane.showInputDialog(null, "Select a movie to watch:",
					"Movie Selection", JOptionPane.QUESTION_MESSAGE, null, movieTitles, movieTitles[0]);
			if (selectedMovieTitle == null) {
				return;
			}

			Movie movie = null;
			switch (selectedMovieTitle) {
			case "Torrente":
				movie = new Movie("Torrente", 120, 18, "Santiago Segura", 7.5);
				break;
			case "Avatar":
				movie = new Movie("Avatar", 150, 12, "James Cameron", 10.0);
				break;
			case "Titanic":
				movie = new Movie("Titanic", 195, 12, "James Cameron", 9.0);
				break;
			case "Ready Player One":
				movie = new Movie("Ready Player One", 140, 12, "Steven Spielberg", 8.0);
				break;
			case "El resplandor":
				movie = new Movie("El resplandor", 144, 18, "Stanley Kubrick", 6.5);
				break;
			}

			double precioTicket = movie.getPrice();

			int opcion = JOptionPane.showConfirmDialog(null,
					"nombre de película: " + movie.getTitle() + "\n" + "duración: " + movie.getDuration() + "\n"
							+ "edad mínima: " + movie.getMinAge() + "\n" + "director: " + movie.getDirector() + "\n"
							+ "precio del ticket: " + precioTicket + "€\n\n" + "¿Desea ver esta película?",
					"Confirmación", JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {
				String ageStr = JOptionPane.showInputDialog("Ingrese su edad:");
				if (ageStr == null) {
					return;
				}
				int age = Integer.parseInt(ageStr);
				if (age < movie.getMinAge()) {
					JOptionPane.showMessageDialog(null, "No tiene edad suficiente para ver esta película.");
					continue;
				} else {
					Cinema cinema = new Cinema(movie, precioTicket);
					String selectedSeat = null;
					while (true) {
						String seatsString = cinema.getSeatsString();
						selectedSeat = JOptionPane.showInputDialog(null,
								"Seleccione un asiento (por ejemplo, 1A):\n\n" + seatsString);
						if (selectedSeat != null) {
							selectedSeat = selectedSeat.toUpperCase();
							if (cinema.isSeatAvailable(selectedSeat)) {
								cinema.occupySeat(selectedSeat);
								break;
							} else {
								JOptionPane.showMessageDialog(null,
										"Asiento no disponible o inválido. Intente nuevamente.");
							}
						}
					}
					JOptionPane.showMessageDialog(null, "El precio del boleto es: " + precioTicket + "€");
					String Pagar = JOptionPane.showInputDialog("Ingrese la cantidad de dinero con la que va a pagar:");
					if (Pagar == null) {
						return;
					}
					double pago = Double.parseDouble(Pagar);
					double cambio = pago - precioTicket;
					if (pago < precioTicket) {
						JOptionPane.showMessageDialog(null, "No tiene suficiente dinero para comprar el boleto.");
						continue;
					} else if (pago > precioTicket) {
						JOptionPane.showMessageDialog(null, "Su cambio es: " + cambio + "€");
					}

					JOptionPane.showMessageDialog(null,
							"Recibo:\n\n" + "Película: " + movie.getTitle() + "\n" + "Duración: " + movie.getDuration()
									+ " minutos\n" + "Director: " + movie.getDirector() + "\n" + "Precio del boleto: "
									+ precioTicket + "€\nCambio: " + cambio + "€\nAsiento: " + selectedSeat
									+ "\n\nGracias por su compra!");
					return;
				}
			}
		}
	}
}
