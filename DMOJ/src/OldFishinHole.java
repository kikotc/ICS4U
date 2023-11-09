import java.util.Scanner;

/**
 * @author Kiko C
 * @version 1.0
 * 
 * Solves the CCC '09 J2 - Old Fishin' Hole problem (https://dmoj.ca/problem/ccc09j2)
 */

public class OldFishinHole {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        //initiate variables from user input, byte is used because input will always be greater than 0 and smaller than 100
        byte troutPoints = input.nextByte(), pikePoints = input.nextByte(), pickerelPoints = input.nextByte(), totalPoints = input.nextByte();
        int possibilities = 0;

        //loops through all possible quantities of trout
        for (byte trout = 0; trout <= totalPoints / troutPoints; trout++) {
            //points left after catching that many trouts
            byte afterTrout = (byte) (totalPoints - (trout * troutPoints));
            //all possible quantities of pike with the points left
            for (byte pike = 0; pike <= afterTrout / pikePoints; pike++) {
                //points left after catching that many trouts and pikes
                byte afterPike = (byte) (afterTrout - (pike * pikePoints));
                //all possible quantities of pickerel with the points left
                for (byte pickerel = 0; pickerel <= afterPike / pickerelPoints; pickerel++) {
                    //skips iteration if no fish is caught
                    if (trout == 0 && pike == 0 && pickerel == 0) {
                        continue;
                    }
                    //outputs the possible combination and add one to the total number of possiblilites
                    System.out.println(trout + " Brown Trout, " + pike + " Northern Pike, " + pickerel + " Yellow Pickerel");
                    possibilities++;
                }
            }
        }

        //outputs total number of combinations
        System.out.println("Number of ways to catch fish: " + possibilities);
        input.close();
    }
}