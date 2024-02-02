import java.util.*;
import java.util.Map.Entry;

public class AbsolutelyAcidic {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// uses amount of readings to make an array
		int numberOfSensors = input.nextInt();
		short[] readings = new short[numberOfSensors + 1];
		// turn all readings into an array
		for (int readingNum = 0; readingNum < numberOfSensors; readingNum++) {
			readings[readingNum] = input.nextShort();
		}
		input.close();
		readings[numberOfSensors] = 1001;

		Arrays.sort(readings);
		HashMap<Integer, Integer> counted = new HashMap<Integer, Integer>();

		int occurances = 1;
		for (int readingNum = 0; readingNum < numberOfSensors; readingNum++) {
			if (readings[readingNum] == readings[readingNum + 1]) {
				occurances++;
			} else {
				counted.put(Integer.valueOf(readings[readingNum]), occurances);
				occurances = 1;
			}
		}

		int firstFrequency = 0;
		int secondFrequency = 0;

		for (Integer value : counted.values()) {
			if (value > firstFrequency) {
				firstFrequency = value;
			} else if (value > secondFrequency) {
				secondFrequency = value;
			}
		}

		int difference = 0;

		if (firstFrequency == secondFrequency) {
			short lowestValue = 1001;
			short highestValue = 0;
			for (Map.Entry<Integer, Integer> entry : counted.entrySet()) {
				if (entry.getValue() == firstFrequency) {
					short key = entry.getKey().shortValue();
					if (key < lowestValue) {
						lowestValue = key;
					} else if (key > highestValue) {
						highestValue = key;
					}
				}
			}
			difference = highestValue - lowestValue;
		} else {
			if (secondFrequency > firstFrequency) {
				int temp = firstFrequency;
				firstFrequency = secondFrequency;
				secondFrequency = temp;
			}
			short lowestValue = 1001;
			short highestValue = 0;
			short firstValue = 0;
			short key;
			for (Map.Entry<Integer, Integer> entry : counted.entrySet()) {
				key = entry.getKey().shortValue();
				if (entry.getValue() == firstFrequency) {
					firstValue = key;
				}
				if (entry.getValue() == secondFrequency) {
					if (key < lowestValue) {
						lowestValue = key;
					} else if (key > highestValue) {
						highestValue = key;
					}
				}
			}
			difference = Math.max(Math.abs(firstValue - lowestValue), Math.abs(firstValue - highestValue));
		}

		/*
		 * System.out.println(numberOfSensors + ": " + Arrays.toString(readings));
		 * System.out.println(counted);
		 * System.out.println(firstFrequency + ", " + secondFrequency);
		 */
		System.out.println(difference);
	}
}
