
package BlackJack;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		boolean playAgain;
		do {
			BlackJack game = new BlackJack();
			game.startGame();
			game.playGame();
			game.endGame();

			// Ask if the player wants to play again
			String[] options = { "Sí", "No" };
			int response = javax.swing.JOptionPane.showOptionDialog(null, "¿Quieres jugar de nuevo?", "Juego terminado",
					javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options,
					options[0]);
			playAgain = (response == 0); // 0 is the index for "Sí"
		} while (playAgain);
		JOptionPane.showMessageDialog(null, "Gracias por jugar BlackJack!");
		System.exit(0);
	}
}
