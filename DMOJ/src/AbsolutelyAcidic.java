import java.util.*;

public class AbsolutelyAcidic {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
       
        int numberOfSensors = input.nextInt();
        short[] readings = new short[numberOfSensors];
        for (int readingNum = 0; readingNum < numberOfSensors; readingNum++) {
            readings[readingNum] = input.nextShort();
        }

        ArrayList<Integer> sorted = new ArrayList<Integer>();

        Arrays.sort(readings);
        int occurances = 0;
        int lastOccurances = 0;
        boolean twoFrequencies = false;
        for (int readingNum = 0; readingNum < numberOfSensors - 1; readingNum++) {
            if (readings[readingNum] == readings[readingNum + 1]) {
                occurances++;
            //multiple one frequency
            } else if ((lastOccurances == occurances) && sorted.size() != 1) {
                sorted.add(Integer.valueOf(readings[readingNum]));
                lastOccurances = occurances;
                occurances = 0;
            } else if (sorted.size() == 1) {
                twoFrequencies = true;
                sorted.add(Integer.valueOf(readings[readingNum]));
                lastOccurances = occurances;
                occurances = 0;
            }
        }
        
        System.out.println(numberOfSensors + ": " + Arrays.toString(readings));
        System.out.println(sorted);
    }
}
