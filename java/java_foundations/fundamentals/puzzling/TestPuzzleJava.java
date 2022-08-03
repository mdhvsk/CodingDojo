package puzzling;

import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();

		System.out.println("-----getTenRolls-----");

		int [] randomRolls = generator.getTenRolls();
		for ( int i = 0; i < randomRolls.length; i ++){
			System.out.println(randomRolls[i]);
		}

		System.out.println("-----getRandomLetters-----");

		char randomLetter = generator.getRandomLetter();
		System.out.println(randomLetter);

		System.out.println("-----getPassword-----");
		String password = generator.generatePassword();
		System.out.println(password);
	
		System.out.println("-----getNewPasswordSet-----");
		int length = 9;
		String [] passwordList = generator.getNewPasswordSet(length);

		for (int i = 0; i < passwordList.length; i++){
			System.out.println(passwordList[i]);
		}

	}
}

