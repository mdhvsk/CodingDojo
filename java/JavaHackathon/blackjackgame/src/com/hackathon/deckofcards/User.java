package com.hackathon.deckofcards;

import java.util.ArrayList;

public class User {
	
	private String name;
//	static int id = 1;
//	private int userID;
	private boolean isMyTurn;
	private ArrayList<Card> cards;
	
	public User(String name) {
		this.name = name;
		this.isMyTurn = true;
		this.cards = new ArrayList<Card>();
//		this.userID = id++;
		
	}
	
	public String getName() {
		return this.name;
	}

	public boolean isMyTurn() {
		return isMyTurn;
	}

	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = false;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTotal(ArrayList<Card> hand) {
		int total = 0;
		int value;
		
		for (int i=0; i < hand.size(); i++) {
			if (hand.get(i).getRank() > 10) {
				value = 10;
			}
			else if(hand.get(i).getRank() == 1) {
				value = 11;
			}
			else {
				value = hand.get(i).getRank();
			
			}
			total += value;
		}
		return total;
	}
	
	
	public int hit(Card card) {
		this.cards.add(card);
		return getTotal(this.cards);
		
		
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	
	

	
	
	// hand Method ArrayList
	
	// total method int 
	
	// isBust method boolean (call gameOver)
	
	
	//isMyTurn boolean 
	

}
