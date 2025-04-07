
package BlackJack;

public class Dealer extends Player {
	public boolean shouldHit() {
		return getHandValue() < 17;
	}
}
