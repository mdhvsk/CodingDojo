package com.hackathon.deckofcards;

import java.util.Scanner;
import java.util.Random;

public class TestDeck {

	public static void main(String[] args) {

		Deck myDeck = new Deck();
		for (Card card : myDeck.getCards()) {
			card.showCard();
		}

		Gameplay game = new Gameplay();

		Random rand = new Random();
		int index;
		
		boolean didWin = false;

		// while player1.ismyTurn or player2. ismyTurn or player1.total <

		// is21 boolean(int total)

		Scanner sc = new Scanner(System.in);
		System.out.println("Insert Player 1 Name: ");
		String player1Name = sc.nextLine();
		System.out.println("Insert Player 2 Name: ");
		String player2Name = sc.nextLine();

		User player1 = new User(player1Name);
		User player2 = new User(player2Name);

		System.out.printf("%s goes first!", player1.getName());

		while (game.isGameOn()) {
			index = rand.nextInt(myDeck.getCards().size());


			System.out.println("Dealing Player 1: ");
			player1.hit(myDeck.removeCard(index));
			System.out.println(player1.hit(myDeck.removeCard(index)));

			System.out.println("Dealing Player 2: ");

			player2.hit(myDeck.removeCard(index));
			System.out.println(player2.hit(myDeck.removeCard(index)));

			game.setGameOn(false);

			while (player1.isMyTurn()) {
				index = rand.nextInt(myDeck.getCards().size());

				System.out.printf("%s's turn \n", player1.getName());

				if (player1.getTotal(player1.getCards()) > 21) {
					game.setGameOn(false);
					player2.setMyTurn(false);
					System.out.printf("%s Wins, %s loses \n", player2.getName(), player1.getName());
					didWin= true;
					break;
				}

				if (player1.getTotal(player1.getCards()) == 21) {
					game.setGameOn(false);
					player2.setMyTurn(false);
					System.out.printf("%s Wins, %s loses \n", player1.getName(), player2.getName());
					didWin= true;

					break;
				}

				System.out.println(" Hit or Stay (** Press H and S respectively **)");
				String p1Choice = sc.nextLine();

				if (p1Choice.equals("H") || p1Choice.equals("h")) {
					System.out.println(player1.hit(myDeck.removeCard(index)));
				}

				else if (p1Choice.equals("S") || p1Choice.equals("s")) {
					player1.setMyTurn(false);
				}

				else {
					System.out.println("Invalid Input, please type H or S for hit or stay");
				}

			}

			while (player2.isMyTurn()) {
				index = rand.nextInt(myDeck.getCards().size());

				System.out.printf("%s's turn \n", player2.getName());

				if (player2.getTotal(player2.getCards()) > 21) {
					game.setGameOn(false);
					player2.setMyTurn(false);
					System.out.printf("%s Wins, %s loses \n", player1.getName(), player2.getName());
					didWin= true;

					break;
				}

				if (player2.getTotal(player2.getCards()) == 21) {
					game.setGameOn(false);
					player2.setMyTurn(false);
					System.out.printf("%s Wins, %s loses \n", player2.getName(), player1.getName());
					didWin= true;

					break;
				}

				System.out.println(" Hit or Stay (** Press H and S respectively **)");
				String p2Choice = sc.nextLine();

				if (p2Choice.equals("H") || p2Choice.equals("h")) {
					System.out.println(player2.hit(myDeck.removeCard(index)));
				}

				else if (p2Choice.equals("S") || p2Choice.equals("s")) {
					player2.setMyTurn(false);
				}

				else {
					System.out.println("Invalid Input, please type H or S for hit or stay");
				}

			}
			
			if (didWin == false) {
				System.out.println(game.compareScores(player1, player2));

			}
			
			
			
		}
		System.out.println("Good Game");


	}

}
