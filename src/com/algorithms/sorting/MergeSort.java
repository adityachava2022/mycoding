package com.algorithms.sorting;

public class MergeSort {
	
	public static void main(String args[]) {
		MergeSort ms = new MergeSort();
		int[] numbers = new int[]{ 10, 30, 20 , 80, 40, 70, 60 };
		ms.mergeSort(numbers);
		System.out.println(" result is ");
		for (int i = 0 ; i < numbers.length ; i++)
			System.out.print(" " + numbers[i]);
	}
	
	public void mergeSort(int[] numbers) {
		divide(numbers, 0, numbers.length - 1);
	}

	public void divide(int[] numbers, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			divide(numbers, start, mid);
			divide(numbers, mid + 1, end);
			merge(numbers, start, mid, end);
		}
	}

	public void merge(int[] numbers, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int leftArrayStart = start;
		int rightArrayStart = mid + 1;
		int tempIndex = 0;
		while ((leftArrayStart <= mid) && (rightArrayStart <= end)) {
			if (numbers[leftArrayStart] <= numbers[rightArrayStart]) {
				temp[tempIndex] = numbers[leftArrayStart];
				leftArrayStart++;
				tempIndex++;
			} else {
				temp[tempIndex] = numbers[rightArrayStart];
				rightArrayStart++;
				tempIndex++;
			}
		}

		while (rightArrayStart <= end) {
			temp[tempIndex] = numbers[rightArrayStart];
			rightArrayStart++;
			tempIndex++;
		}

		while (leftArrayStart <= mid) {
			temp[tempIndex++] = numbers[leftArrayStart];
			leftArrayStart++;
			tempIndex++;
		}
		tempIndex = 0;
		for (int i = start; i <= end; i++)
			numbers[i] = temp[tempIndex++];
	}

}
