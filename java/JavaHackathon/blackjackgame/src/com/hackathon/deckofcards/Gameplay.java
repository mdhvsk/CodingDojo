package com.hackathon.deckofcards;

import java.util.ArrayList;

public class Gameplay {
	private ArrayList<String> turns;
	
	private boolean gameOn;
	
	public Gameplay() {
		this.gameOn = true;
		
	}
	


	public ArrayList<String> getTurns() {
		return turns;
	}

	public void setTurns(ArrayList<String> turns) {
		this.turns = turns;
	}

	public boolean isGameOn() {
		return gameOn;
	}

	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}
	
	public String compareScores(User player1, User player2){
		String result;
		if (player1.getTotal(player1.getCards()) == player2.getTotal(player2.getCards())){
			result = "Tie game, both players scored the same";
		}
		
		else if (player1.getTotal(player1.getCards()) > player2.getTotal(player2.getCards())) {
			result = String.format("%s WINS!", player1.getName());
		}
		
		else {
			result = String.format("%s WINS!", player2.getName());
		}
		return result;
	}
	
	
	
	
}
