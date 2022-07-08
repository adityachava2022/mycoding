package com.sorting;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
		sort.quicksort(nums);
		for (int n : nums)
			System.out.print(" " + n);
	}

	public void quicksort(int[] nums) {
		divide(nums, 0, nums.length - 1);
	}

	public void divide(int[] nums, int left, int right) {
		if (left < right) {
			int pIndex = partition(nums, left, right);
			divide(nums, left, pIndex - 1);
			divide(nums, pIndex + 1, right);
		}
	}

	public int partition(int[] nums, int left, int right) {
		int pIndex = left;
		int pivot = nums[right];
		for (int i = left; i <= right; i++) {
			if (nums[i] < pivot) {
				int temp = nums[i];
				nums[i] = nums[pIndex];
				nums[pIndex] = temp;
				pIndex++;
			}
		}
		int temp = nums[right];
		nums[right] = nums[pIndex];
		nums[pIndex] = temp;
		return pIndex;
	}

}
