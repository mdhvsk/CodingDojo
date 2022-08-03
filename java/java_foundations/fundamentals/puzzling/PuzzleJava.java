package puzzling;
import java.nio.channels.NetworkChannel;
import java.util.Random;

public class PuzzleJava {
    public  int[] getTenRolls(){
        int [] myArray;
        myArray = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            myArray[i] = r.nextInt(10) + 1;
        }
        return myArray;
    }

    public char getRandomLetter(){
        int [] myArray;
        myArray = new int[26];
        int asciiValue = 97;
        for (int i = 0; i < 26; i++){
            myArray[i] = asciiValue;
            asciiValue++;
        }
        Random r = new Random();
        int randomAscii = r.nextInt(26);
        int chosenAscii = myArray[randomAscii];
        char convertedChar = (char)chosenAscii;
        return convertedChar;
    }

    public String generatePassword(){
        String password = "";
        for (int i = 0; i < 8; i++){
            password += getRandomLetter();
        }
        return password;
    }

    public String [] getNewPasswordSet(int length){
        String [] myArray;
        myArray = new String[length];
        for (int i = 0; i < length; i++){
            myArray[i] = generatePassword();
        }

        return myArray;
    }
}
