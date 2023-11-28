import java.util.Scanner;

/**
 * @author Kiko C
 * @version 2.0 - Uses a modulo approach to determine the letter shift, instead of nested for loops, which was quickly scrapped
 * 
 * Solves the CCC '04 J4 - Simple Encryption problem (https://dmoj.ca/problem/ccc04j4)
 */

public class SimpleEncryption {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] keyword = input.nextLine().toCharArray();
        //removes all non alphabetic characters before turning into array
        char[] message = input.nextLine().replaceAll("[^A-Z]+", "").toCharArray();
        //loop though characters in the message
        for (int charPos = 0; charPos < message.length; charPos++){
            //matches the character with its letter shift (column) using modulo, then shift it using the method
            message[charPos] = shift(message[charPos],keyword[charPos % keyword.length]);
        }
        System.out.println(message);
        input.close();
    }

    //method that shifts letter by a letter shift
    public static char shift(int charNum, int shiftNum) {
        int shiftedNum = charNum + shiftNum - 65;
        //loops back to letter A if the shifted letter is "beyond" Z
        if (shiftedNum > 90) {
            shiftedNum -= 26;
        }
        return (char) shiftedNum;
    }
}