import java.util.Scanner;

public class SimpleEncryption {
    public static void main(String[] args) {
        //input
        Scanner input = new Scanner(System.in);
        char[] keyword = input.nextLine().toCharArray();
        //takes the message and remove all non alphabetic characters
        char[] message = input.nextLine().replaceAll("[^A-Z]+", "").toCharArray();
        for (int charPos = 0; charPos < message.length; charPos++){
            message[charPos] = shift(message[charPos],keyword[charPos % keyword.length]);
        }
        System.out.println(message);
        
        input.close();
    }

    public static char shift(int charNum, int shiftNum) {
        System.out.println(charNum + "," + shiftNum);
        int shiftedNum = charNum + shiftNum - 65;
        if (shiftedNum > 90) {
            shiftedNum -= 26;
        }
        return (char) shiftedNum;
    }
}
