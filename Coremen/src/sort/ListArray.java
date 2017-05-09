package sort;

import java.util.Random;

public abstract class ListArray {
	
	protected static int size = 100000000;
	
	protected static int[] array = new int[size];

	protected static Random number = new Random();
	
	static void displayArray(int[] array){

		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	static void generateRandomList() {
		for (int i = 0; i < size; i++) {
			array[i] = number.nextInt(100);
		}
	}
}