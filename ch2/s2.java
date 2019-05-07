class SectionTwo {
	public void mergeSort(int[] A, int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			mergeSort(A, l, mid);
			mergeSort(A, mid + 1, r);
			merge(A, l, mid, r);
		}
	}

	private void merge(int[] A, int l, int mid, int r) {
		int[] L = new int[mid - l + 2];
		int[] R = new int[r - mid + 1];

		for (int i = l; i <= mid; i++) {
			L[i - l] = A[i];
		}
		L[mid + 1 - l] = Integer.MAX_VALUE;

		for (int i = mid + 1; i <= r; i++) {
			R[i - mid - 1] = A[i];
		}
		R[r - mid] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		for (int k = l; k <= r; k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
	}
}