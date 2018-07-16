/**
 * 
 */
package com.learning.basic.array;

/**
 * @author VINAY
 * 
 */
public class MaxSubArrSum {

	public static void main(String[] args) {
		// int [] array = {-2,1,-3,4,-1,2,1,-5,4};
		int[] array = { -5, 1, -3, 7, -1, 2, 1, -1, 5, -4, 6 };
		// int [] array = {-5,-3,-4,-8};

		int[] maxSumArray = MaxSubArrSum.getMaxSumArray(array);
		System.out.println("Maximum array has size of " + maxSumArray.length);
		for (int number : maxSumArray) {
			System.out.print(String.valueOf(number) + " ");
		}
	}

	private MaxSubArrSum() {
	}

	/**
	 * 
	 * @param startArray
	 * 
	 * @throws AssertionError
	 *             when array is null or array.lenght is 0.
	 * 
	 * @return first sub with the highest sum
	 */
	public static int[] getMaxSumArray(int[] startArray) {
		if (startArray == null || startArray.length == 0) {
			throw new AssertionError(
					"Precondition failed, null object or zero size array.");
		}
		if (startArray.length == 1) {
			return startArray;
		}
		return findMaxSumArray(startArray);
	}

	private static int[] findMaxSumArray(final int[] startArray) {
		SubArrayDetails highestSumSubArrayDetails = new SubArrayDetails(0, 0,
				startArray[0]);
		for (int counter = 0; counter < startArray.length; counter++) {
			highestSumSubArrayDetails = findHighestSubArray(startArray,
					counter, highestSumSubArrayDetails);
		}
		int[] resultArray = new int[highestSumSubArrayDetails.getEndIndex()
				- highestSumSubArrayDetails.getBeginIndex() + 1];
		System.arraycopy(startArray, highestSumSubArrayDetails.getBeginIndex(),
				resultArray, 0, resultArray.length);
		return resultArray;
	}

	private static SubArrayDetails findHighestSubArray(final int[] array,
			final int indexLowestBound,
			final SubArrayDetails highestSumSubArrayDetailsKnown) {
		long tempSum = 0;
		SubArrayDetails highestSumSubArrayDetails = highestSumSubArrayDetailsKnown;
		for (int counter = indexLowestBound; counter < array.length; counter++) {
			tempSum += array[counter];
			if (highestSumSubArrayDetailsKnown.getTotalSum() < tempSum) {
				highestSumSubArrayDetails = new SubArrayDetails(
						indexLowestBound, counter, tempSum);
			}
		}
		return highestSumSubArrayDetails;
	}

}

class SubArrayDetails {

	private int beginIndex;
	private int endIndex;
	private long totalSum;

	/**
	 * The only constructor for this class.
	 * 
	 * @param beginIndex
	 *            the beginIndex of the subArray.
	 * @param endIndex
	 *            the endIndex of the subArray.
	 * @param totalSum
	 *            the total sum of all objects from beginIndex to endIndex.
	 */
	public SubArrayDetails(int beginIndex, int endIndex, long totalSum) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.totalSum = totalSum;
	}

	/**
	 * Returns the beginIndex.
	 * 
	 * @return int beginIndex
	 */
	public int getBeginIndex() {
		return beginIndex;
	}

	/**
	 * Returns the endIndex.
	 * 
	 * @return int endIndex
	 */
	public int getEndIndex() {
		return endIndex;
	}

	/**
	 * Returns the totalSum.
	 * 
	 * @return long totalSum
	 */
	public long getTotalSum() {
		return totalSum;
	}
}