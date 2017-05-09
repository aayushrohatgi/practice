public class InsertionSort extends ListArray {

	public static void main(String[] args) {

		generateRandomList();

		displayArray(array);

		long startTime = System.currentTimeMillis();
		sortByInsertion(array, size);
		long endTime = System.currentTimeMillis();
		System.out.println("Took " + (endTime - startTime) + " ns");

		displayArray(array);
	}

	private static void sortByInsertion(int[] array, int count) {

		for (int i = 1; i < count; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					insert(array, i, j);
					break;
				}
			}
		}
	}

	private static void insert(int[] array, int i, int j) {

		int temp = array[i];
		while (i != j) {
			array[i] = array[i - 1];
			i--;
		}
		array[j] = temp;
	}

}
