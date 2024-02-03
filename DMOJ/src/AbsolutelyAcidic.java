import java.util.*;

/**
 * @author Kiko C
 * @version 1.0
 * 
 * Solves the CCC '12 S3 - Absolutely Acidic problem (https://dmoj.ca/problem/ccc12s3)
 */

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
		// added value as a buffer for the loop
		readings[numberOfSensors] = 1001;

		Arrays.sort(readings);
		HashMap<Integer, Integer> counted = new HashMap<Integer, Integer>();

		// count occurances and store in hashMap
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

		// find the two highest frequencies
		for (Integer value : counted.values()) {
			if (value > firstFrequency) {
				firstFrequency = value;
			}
		}
		int firstFrequencyOccurance = 0;
		for (Integer value : counted.values()) {
			if (value == firstFrequency) {
				firstFrequencyOccurance++;
			} else if (value > secondFrequency) {
				secondFrequency = value;
			}
		}

		int difference = 0;

		// if there are multiple highest frequencies, calculate difference from highest
		// and lowest number
		if (firstFrequencyOccurance > 1) {
			short lowestValue = readings[0];
			short highestValue = readings[0];
			for (Map.Entry<Integer, Integer> entry : counted.entrySet()) {
				if (entry.getValue() == firstFrequency) {
					short key = entry.getKey().shortValue();
					if (key < lowestValue) {
						lowestValue = key;
					} if (key > highestValue) {
						highestValue = key;
					}
				}
			}
			difference = highestValue - lowestValue;
		}
		// else compair difference between the highest frequency number with the
		// highest/lowest second highest frequency number to get the result
		else {
			short lowestValue = readings[0];
			short highestValue = readings[0];
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
					}
					if (key > highestValue) {
						highestValue = key;
					}
				}
			}
			difference = Math.max(Math.abs(firstValue - lowestValue), Math.abs(firstValue - highestValue));
		}

		System.out.println(difference);
	}
}
