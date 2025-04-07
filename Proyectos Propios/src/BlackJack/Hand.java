
package BlackJack;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public int getTotalValue() {
		int totalValue = 0;
		int aceCount = 0;

		for (Card card : cards) {
			totalValue += card.getValue();
			if (card.getRank().equals("As")) {
				aceCount++;
			}
		}

		while (totalValue > 21 && aceCount > 0) {
			totalValue -= 10;
			aceCount--;
		}

		return totalValue;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return cards.toString();
	}
}
