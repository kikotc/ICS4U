import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Kiko C
 * @version 2.0 - took use of modulo and division to find location of letters
 *          
 * Solves the CCC '06 J3 - Cell-Phone Messaging problem (https://dmoj.ca/problem/ccc06j3)
 */

public class PhoneTime {
    public static void main(String[] args) {
        //init variables
        Scanner input = new Scanner(System.in);
        String word, keypad = "abc def ghi jkl mno pqrstuv wxyz";
        ArrayList<String> wordList = new ArrayList<String>();

        //turn user input into an ArrayList and stops when "halt" is inputted
        while (input.hasNextLine()) {
            word = input.nextLine();
            if (word.equals("halt")) {
                System.out.println("");
                break;
            }
            wordList.add(word);
        }

        //close scanner
        input.close();

        //take the words one by one in the ArrayList until all words are used
        for (int wordLoop = 0; wordLoop < wordList.size(); wordLoop++) {
            //resets the time for each new word
            int time = 0;
            word = wordList.get(wordLoop);
                //go letter by letter in the word
                for (int charLoop = 0; charLoop < word.length(); charLoop++) {
                    char letter = word.charAt(charLoop);
                    //make sure the letter isn't a space
                    if (letter != ' ') {
                        //check how many presses are needed to type letter by using modulo
                        int presses = (keypad.indexOf(letter) + 1) % 4;
                        if (presses == 0) {
                            presses = 4;
                        }
                        time += presses;
                        //if it is not the first letter in the word, check if it is on the same button using division
                        if (charLoop >= 1) {
                            char lastLetter = word.charAt(charLoop - 1);
                            if (keypad.indexOf(letter) / 4 == keypad.indexOf(lastLetter) / 4) {
                                time += 2;
                            }
                        }
                    }
                }
            //print time needed for each word
            System.out.println(time);
        }
    }
}