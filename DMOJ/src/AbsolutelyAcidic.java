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
        for (int readingNum = 0; readingNum < numberOfSensors - 1; readingNum++) {
            if (readings[readingNum] == readings[readingNum + 1]) {
                occurances++;
            } else if (lastOccurances <= occurances) {
                sorted.add(Integer.valueOf(readings[readingNum]));
                lastOccurances = occurances;
                occurances = 0;
            } else {
                break;
            }
        }
        
        System.out.println(numberOfSensors + ": " + Arrays.toString(readings));
        System.out.println(sorted);
    }
}
