
package BlackJack;

public class Player {
	private Hand hand;

	public Player() {
		hand = new Hand();
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public int getHandValue() {
		return hand.getTotalValue();
	}

	public Hand getHand() {
		return hand;
	}
}
