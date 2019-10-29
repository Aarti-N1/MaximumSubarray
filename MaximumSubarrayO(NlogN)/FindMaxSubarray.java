package maximum.subarray.calculation;

import java.util.ArrayList;

public class FindMaxSubarray {

	private MaxSubarrayDetails maxCrossingSubarray(ArrayList<Integer> A, int low, int mid, int high) {
		if ((A == null) || (A.size() == 0) || (low > high))
			return null;
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = mid;
		MaxSubarrayDetails ret;
		for (int i = mid; i >= low; i--) {
			sum = sum + (Integer) A.get(i);
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = mid + 1;
		for (int i = mid + 1; i <= high; i++) {
			sum = sum + (Integer) A.get(i);
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}
		Integer sumLR = leftSum + rightSum;
		ret = new MaxSubarrayDetails(maxLeft, maxRight, sumLR);
		return ret;
	}

	public MaxSubarrayDetails findMSS(ArrayList<Integer> A, int low, int high) {
		if ((A == null) || (A.size() == 0) || (low > high))
			return null;

		if (low < high) {
			int mid = (low + high) / 2;
			MaxSubarrayDetails left, right, cross;
			left = findMSS(A, low, mid);
			right = findMSS(A, mid + 1, high);
			cross = maxCrossingSubarray(A, low, mid, high);
			if (left.compareTo(right.getSum()) == 1 && left.compareTo(cross.getSum()) == 1)
				return new MaxSubarrayDetails(left.getStartIndex(), left.getEndIndex(), left.getSum());
			else if (right.compareTo(left.getSum()) == 1 && right.compareTo(cross.getSum()) == 1)
				return new MaxSubarrayDetails(right.getStartIndex(), right.getEndIndex(), right.getSum());
			else
				return new MaxSubarrayDetails(cross.getStartIndex(), cross.getEndIndex(), cross.getSum());
		} else
			return new MaxSubarrayDetails(low, high, A.get(low));
	}

}
