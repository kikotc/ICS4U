import java.util.Scanner;

public class SimpleEncryption {
    public static void main(String[] args) {
        //take string input and turn into character array
        Scanner input = new Scanner(System.in);
        char[] keyword = input.nextLine().toCharArray();
        //removes all non alphabetic characters before turning into array
        char[] message = input.nextLine().replaceAll("[^A-Z]+", "").toCharArray();
        //loop though all the characters in the message
        for (int charPos = 0; charPos < message.length; charPos++){
            //matches the character with its letter shift using modulo, then shift it using the method
            message[charPos] = shift(message[charPos],keyword[charPos % keyword.length]);
        }
        //encoded message
        System.out.println(message);
        input.close();
    }

    //method that shifts letter charNum by letter shiftNum
    //takes in char as it can be implictly casted to int
    public static char shift(int charNum, int shiftNum) {
        int shiftedNum = charNum + shiftNum - 65;
        //loops back to letter A if the shifted letter is "beyond" Z
        if (shiftedNum > 90) {
            shiftedNum -= 26;
        }
        return (char) shiftedNum;
    }
}