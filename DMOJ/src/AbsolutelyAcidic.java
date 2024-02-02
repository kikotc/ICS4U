import java.util.*;
import java.util.Map.Entry;

public class AbsolutelyAcidic {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		//uses amount of readings to make an array
		int numberOfSensors = input.nextInt();
		short[] readings = new short[numberOfSensors + 1];
		//turn all readings into an array
		for (int readingNum = 0; readingNum < numberOfSensors; readingNum++) {
			readings[readingNum] = input.nextShort();
		}
        input.close();
		readings[numberOfSensors] = 1001;

		Arrays.sort(readings);
		HashMap<Integer,Integer> counted = new HashMap<Integer,Integer>();

		int occurances = 1;
		for (int readingNum = 0; readingNum < numberOfSensors; readingNum++) {
			if (readings[readingNum] == readings[readingNum + 1]) {
				occurances++;
			} else {
				counted.put(Integer.valueOf(readings[readingNum]), occurances);
				occurances = 1;
			}
		}

        int highestFrequency = 0;
        int secondFrequency = 0;

        for (Integer value : counted.values()) {
            if (value > highestFrequency) {
                highestFrequency = value;
            } else if (value > secondFrequency) {
                secondFrequency = value;
            }
        }

		System.out.println(numberOfSensors + ": " + Arrays.toString(readings));
		System.out.println(counted);
        System.out.println(highestFrequency + ", " + secondFrequency);
	}
}
