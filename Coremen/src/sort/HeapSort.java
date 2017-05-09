package sort;

import java.util.Arrays;

public class HeapSort extends ListArray {

	public static void main(String[] args) {

		generateRandomList();

		int[] heap = new int[size];
		Arrays.fill(heap, new Integer(-1));

//		displayArray(array);

		long startTime = System.currentTimeMillis();
		heapSort(array, heap);
		long endTime = System.currentTimeMillis();
		System.out.println("Took " + (endTime - startTime) + " ns");

//		displayArray(array);
	}

	private static void heapSort(int[] array, int[] heap) {

		makeHeap(array, heap);
		distroyHeapToSort(array, heap);
	}

	private static void distroyHeapToSort(int[] array, int[] heap) {
		int index = size - 1;

		while (index >= 0) {
			array[index] = heap[0];
			index--;
			heap[0] = -1;
			int position = 0;
			for (int i = 0; i <= Math.log(size) / Math.log(2); i++) {
				if (2 * position + 1 < size && 2 * (position + 1) < size) {
					if (heap[2 * position + 1] > heap[2 * (position + 1)]) {
						int temp = heap[2 * position + 1];
						heap[2 * position + 1] = heap[position];
						heap[position] = temp;
						position = 2 * position + 1;
					} else {
						int temp = heap[2 * (position + 1)];
						heap[2 * (position + 1)] = heap[position];
						heap[position] = temp;
						position = 2 * (position + 1);
					}
				} else if (2 * position + 1 < size && 2 * (position + 1) >= size) {
					int temp = heap[2 * position + 1];
					heap[2 * position + 1] = heap[position];
					heap[position] = temp;
					position = 2 * position + 1;
				} else {
					break;
				}
			}
		}
	}

	private static void makeHeap(int[] array, int[] heap) {

		int currentHeapSize = 0;

		for (int nextNum : array) {
			int position = currentHeapSize;
			heap[currentHeapSize] = nextNum;

			while (position > 0) {
				if (position % 2 == 0) {
					if (heap[position] > heap[position / 2 - 1]) {
						int temp = heap[position / 2 - 1];
						heap[position / 2 - 1] = heap[position];
						heap[position] = temp;
						position = position / 2 - 1;
					} else {
						break;
					}
				} else {
					if (heap[position] > heap[(position - 1) / 2]) {
						int temp = heap[(position - 1) / 2];
						heap[(position - 1) / 2] = heap[position];
						heap[position] = temp;
						position = (position - 1) / 2;
					} else {
						break;
					}
				}
			}
			currentHeapSize++;
		}
	}
}
