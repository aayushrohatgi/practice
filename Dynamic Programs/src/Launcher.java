import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Launcher {

	public static void main(String[] args) {

		int number = 1091545;

		PossibleCombinations combinations = new PossibleCombinations();
		long startTime = System.currentTimeMillis();
		List<Integer> results = new ArrayList<>(combinations.generateConbinations(number));
		long endTime = System.currentTimeMillis();
		System.out.println("Took " + (endTime - startTime) + " ns");
		Collections.sort(results);
		for (int result : results) {
			System.out.println(result);
		}
		System.out.println(results.size());
	}
}
