class MaximumSubarray {
	// divide and conquer
	// time O(nlogn)
	public int[] findMaxSubarray(int[] A, int lo, int hi) {
		if (lo == hi) {
			return new int[]{lo, hi, A[lo]};
		}

		int mid = lo + (hi - lo) / 2;
		int[] left = findMaxSubarray(A, lo, mid);
		int[] right = findMaxSubarray(A, mid + 1, hi);
		int[] crossMid = findCrossMid(A, lo, mid, hi);

		if (left[2] >= right[2] && left[2] >= crossMid[2]) {
			return left;
		} else if (right[2] >= left[2] && right[2] >= crossMid[2]) {
			return right;
		} else {
			return crossMid;
		}
	}

	private int[] findCrossMid(int[] A, int lo, int mid, int hi) {
		int l = mid;
		int leftMax = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= lo; i--) {
			sum += A[i];
			if (sum > leftMax) {
				leftMax = sum;
				l = i;
			}
		}

        int r = mid + 1;
		int rightMax = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid + 1; i <= hi; i++) {
			sum += A[i];
			if (sum > rightMax) {
				rightMax = sum;
				r = i;
			}
		}

		return new int[]{l, r, leftMax + rightMax};
	}

    // non-recursive, linear time
	public int[] findMaxSubarrayLinear(int[] A, int lo, int hi) {
		int l = lo;
		int r = lo;
		int sum = A[lo]; // the maxSubArray
		int tmpSum = A[lo]; // the maxSubarray including right end
		int tmpL = lo; // the start index of the right end maxSubarray

		for (int i = lo + 1; i <= hi; i++) {
			tmpSum = Math.max(A[i], A[i] + tmpSum);
			if (tmpSum == A[i]) {
				tmpL = i;
			}

			if (tmpSum > sum) {
				sum = tmpSum;
				l = tmpL;
				r = i;
			}
		}
		return new int[]{l, r, sum};
	}
}