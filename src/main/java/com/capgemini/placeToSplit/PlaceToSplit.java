package com.capgemini.placeToSplit;

/**
 * Given a non-empty array, return true if there is a place to split the array
 * so that the sum of the numbers on one side is equal to the sum of the numbers
 * on the other side. Example: {{{ canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false canBalance({10, 10}) → true }}}
 */

public final class PlaceToSplit {

	public static boolean canBalance(int[] nums) {
		if (isLessThanTwoElementsInArray(nums) || isSumOfElementsNotEvenInArray(nums)) {
			return false;
		}

		int sumOfAllElements = sumOfElementsInArray(nums);
		int sum = 0;

		for (int number : nums) {
			sum += number;

			if (sum == sumOfAllElements/2)
				return true;
			if (sum > sumOfAllElements/2) {
				return false;
			}
		}

		return false;
	}

	private static int sumOfElementsInArray(int[] nums) {
		int sum = 0;
		for (int number : nums) {
			sum += number;
		}
		return sum;
	}

	private static boolean isSumOfElementsNotEvenInArray(int[] nums) {
		int sum = sumOfElementsInArray(nums);
		if (sum % 2 != 0) {
			return true;
		}
		return false;
	}

	private static boolean isLessThanTwoElementsInArray(int[] nums) {
		if (nums.length < 2) {
			return true;
		}
		return false;
	}
}
