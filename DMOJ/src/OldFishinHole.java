import java.util.Scanner;

public class OldFishinHole {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        byte troutPoints = input.nextByte(), pikePoints = input.nextByte(), pickerelPoints = input.nextByte(), totalPoints = input.nextByte();
        byte possibilities = 0;

        for (byte trout = 0; trout <= totalPoints / troutPoints; trout++) {
            byte afterTrout = (byte) (totalPoints - (trout * troutPoints));
            for (byte pike = 0; pike <= afterTrout / pikePoints; pike++) {
                byte afterPike = (byte) (afterTrout - (pike * pikePoints));
                for (byte pickerel = 0; pickerel <= afterPike / pickerelPoints; pickerel++) {
                    if (trout == 0 && pike == 0 && pickerel == 0) {
                        continue;
                    }
                    System.out.println(trout + " Brown Trout, " + pike + " Northern Pike, " + pickerel + " Yellow Pickerel");
                    possibilities++;
                }
            }
        }

        System.out.println("Number of ways to catch fish: " + possibilities);
        input.close();
    }
}