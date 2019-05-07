class SectionThree {
	// recursive insertion sort
	public void recursiveInsertionSort(int[] A, int n) {
		if (n  == 1) {
			return;
		}

		recursiveInsertionSort(A, n - 1);
		int replacement = A[n - 1];
		int i = n - 2;
		while (i >= 0 && A[i] > replacement) {
			A[i + 1] = A[i];
			i--;
		}
		A[i + 1] = replacement;
	}

	// binary search
	public int binarySearch(int[] A, int num) {
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (A[mid] == num) {
				return mid;
			} else if (A[mid] < num) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		if (A[lo] == num) {
			return lo;
		}
		return -1;
	}

	// binary search + insertion
	public void insertionBS(int[] A) {
		for (int j = 1; j < A.length; j++) {
			int i = j - 1;
			int key = A[j];
			int idx = findLatter(A, key, 0, i);
			while (i >= idx) {
				A[i + 1] = A[i];
				i--;
			}
			A[idx] = key;
		}
	}

	private int findLatter(int[] A, int key, int lo, int hi) {
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (A[mid] > key) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		if (A[lo] <= key) {
			return lo + 1;
		}
		return lo;
	}
}