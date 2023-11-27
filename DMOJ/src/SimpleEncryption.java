import java.util.Scanner;

public class SimpleEncryption {
    public static void main (String[] args) {
        //input
        Scanner input = new Scanner(System.in);
        char[] keyword = input.nextLine().toCharArray();
        //takes the message and remove all non alphabetic characters
        char[] rawMessage = input.nextLine().replaceAll("[^A-Z]+", "").toCharArray();
        int totalRow = rawMessage.length / keyword.length;
        char[][] table = new char[keyword.length][totalRow];

        for (int column = 0; column < keyword.length; column++) {
            System.out.println(column);
        }
    }
}
