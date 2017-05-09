public class MergeSort extends ListArray {

	public static void main(String[] args) {

		int initial = 0;

		generateRandomList();

//		displayArray(array);

		long startTime = System.currentTimeMillis();
		listBreak(array, initial, size);
		long endTime = System.currentTimeMillis();
		System.out.println("Took " + (endTime - startTime) + " ns");

//		displayArray(array);
	}

	private static void listBreak(int[] array, int initial, int size) {

		if (size > 1) {
			int p = initial, q = initial + (size - size % 2) / 2;
			listBreak(array, p, (size - size % 2) / 2);
			listBreak(array, q, (size + size % 2) / 2);

			merge(array, p, q, size);
		}

	}

	private static void merge(int[] array, int p, int q, int r) {

		int[] tempArray = new int[r];

		int i = p, j = q;

		for (int k = p; k < p + r; k++) {

			if (i == q) {
				tempArray[k - p] = array[j];
				j++;
			} else if (j == p + r) {
				tempArray[k - p] = array[i];
				i++;
			} else {
				if (array[i] > array[j]) {
					tempArray[k - p] = array[j];
					j++;
				} else {
					tempArray[k - p] = array[i];
					i++;
				}
			}
		}
		transfer(tempArray, array, p);
	}

	private static void transfer(int[] tempArray, int[] array, int p) {

		for (int num : tempArray) {
			array[p] = num;
			p++;
		}
	}

}
