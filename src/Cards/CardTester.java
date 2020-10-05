package Cards;

import java.util.ArrayList;

import Cards.Card.Suits;

public class CardTester {
	public static void main(String[] args) {
		Deck d = new Deck();
		for(Card c: d) {
			System.out.println(c);
		}
		System.out.println("====================");
		d.shuffle();
		for(Card c: d) {
			System.out.println(c);
		}
		ArrayList<Card> hand = d.deal(5);
		System.out.println("====================");
		for(Card c: hand) {
			System.out.println(c);
		}
		System.out.println(d.size());
	}
	
}
