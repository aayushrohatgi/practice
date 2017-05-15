import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Launcher {
	
	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int testCases = Integer.parseInt(reader.readLine());
			for (int i = 0; i < testCases; i++) {
				int friends = Integer.parseInt(reader.readLine());
				int[] chocolates = new int[friends];
				StringTokenizer token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < friends; j++) {
					chocolates[j] = Integer.parseInt(token.nextToken().trim());
				}
				ChocolateDistribution chocolateDistribution = new ChocolateDistribution();
				int operations = chocolateDistribution.distributionsForEquality(chocolates);
				System.out.println(operations);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}