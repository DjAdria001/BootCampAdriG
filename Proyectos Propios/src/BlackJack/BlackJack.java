
package BlackJack;

import javax.swing.JOptionPane;

public class BlackJack {
	private Deck deck;
	private Player player;
	private Dealer dealer;

	public BlackJack() {
		deck = new Deck();
		player = new Player();
		dealer = new Dealer();
	}

	public void startGame() {
		player.addCard(deck.drawCard());
		player.addCard(deck.drawCard());
		dealer.addCard(deck.drawCard());
		dealer.addCard(deck.drawCard());

		JOptionPane.showMessageDialog(null,
				"Mano del jugador: " + player.getHand() + "\nMano del crupier: [" + dealer.getHand().getCards().get(0)
						+ ", Oculta]");
	}

	public void playGame() {
		while (true) {
			if (player.getHandValue() > 21) {
				JOptionPane.showMessageDialog(null, "Valor de la mano del jugador: " + player.getHandValue()
						+ "\n¡El jugador se pasa! El crupier gana.");
				return;
			}

			int action = JOptionPane.showOptionDialog(null,
					"Valor de la mano del jugador: " + player.getHandValue()
							+ "\nValor de la mano del crupier: "
							+ dealer.getHand().getCards().get(0).getValue()+", Oculta" + "\n¿Quieres pedir o plantarte?",
					"Elige una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Pedir", "Plantarse" }, "Pedir");

			if (action == 0) { // Pedir
				player.addCard(deck.drawCard());
			} else if (action == 1) { // Plantarse
				break;
			}
		}

		while (dealer.shouldHit()) {
			dealer.addCard(deck.drawCard());
		}

		String resultMessage = "Mano del crupier: " + dealer.getHand() + "\nValor de la mano del crupier: "
				+ dealer.getHandValue() +"\nValor de la mano del jugador: " + player.getHandValue() + "\n";

		if (dealer.getHandValue() > 21) {
			resultMessage += "¡El crupier se pasa! El jugador gana.";
		} else if (player.getHandValue() > dealer.getHandValue()) {
			resultMessage += "¡El jugador gana!";
		} else if (player.getHandValue() < dealer.getHandValue()) {
			resultMessage += "El crupier gana.";
		} else {
			resultMessage += "¡Es un empate!";
		}

		JOptionPane.showMessageDialog(null, resultMessage);
	}

	public void endGame() {
		JOptionPane.showMessageDialog(null, "Juego terminado.");
	}
}
