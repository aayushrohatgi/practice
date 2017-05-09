import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Generates all possible combinations of numbers using any number of digits of a given number
 * 
 * @author aayushrohatgi
 *
 */
public class PossibleCombinations {

	private int digitCounts[];

	private List<Integer> digits;

	private int totalDigitsCount;

	private Set<Integer> combinations;

	private HashMap<Integer, HashSet<Integer>> memory;

	private void setInitialData(int number) {
		digitCounts = new int[10];
		Set<Integer> uniqueDigits = new HashSet<>();
		totalDigitsCount = 0;
		digits = new ArrayList<>();
		while (number != 0) {
			int digit = number % 10;
			digitCounts[digit] += 1;
			number = number / 10;
			totalDigitsCount++;
			uniqueDigits.add(digit);
			digits.add(digit);
		}
		memory = new HashMap<>();
		memory.put(0, (HashSet<Integer>) uniqueDigits);
		combinations = new HashSet<>();
		combinations.addAll(uniqueDigits);
	}

	private boolean checkValidCombination(int number) {
		int[] counts = new int[10];
		while (number != 0) {
			int digitIndex = number % 10;
			counts[digitIndex] += 1;
			if (counts[digitIndex] > digitCounts[digitIndex]) {
				return false;
			}
			number = number / 10;
		}
		return true;
	}

	public Set<Integer> generateConbinations(int number) {
		setInitialData(number);
		for (int i = 1; i < getTotalDigitsCount(); i++) {
			generatePossibleCombinations(number, i);
		}
		return combinations;
	}

	private void generatePossibleCombinations(int number, int place) {
		Set<Integer> prevCombinations = memory.get(place - 1);
		Set<Integer> newCombination = new HashSet<>();
		for (int i = 0; i < digits.size(); i++) {
			for (int result : prevCombinations) {
				int combination = (int) (digits.get(i) * Math.pow(10, place) + result);
				if (checkValidCombination(combination)) {
					newCombination.add(combination);
				}
			}
		}
		memory.put(place, (HashSet<Integer>) newCombination);
		combinations.addAll(newCombination);
	}

	public HashMap<Integer, HashSet<Integer>> getMemory() {
		return memory;
	}

	public void setMemory(HashMap<Integer, HashSet<Integer>> memory) {
		this.memory = memory;
	}

	public Set<Integer> getCombinations() {
		return combinations;
	}

	public void setCombinations(Set<Integer> combinations) {
		this.combinations = combinations;
	}

	public int[] getDigitCounts() {
		return digitCounts;
	}

	public void setDigitCounts(int[] digitCounts) {
		this.digitCounts = digitCounts;
	}

	public int getTotalDigitsCount() {
		return totalDigitsCount;
	}

	public void setTotalDigitsCount(int totalDigitsCount) {
		this.totalDigitsCount = totalDigitsCount;
	}
}
