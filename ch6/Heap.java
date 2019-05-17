class Heap {
	private int[] A;

    private int parent(int i) {
    	if (i == 0) {
    		return -1;
    	}
    	return i / 2;
    }

    private int left(int i) {
    	return i * 2;
    }

    private int right(int i) {
    	return i * 2 + 1;
    }

    // time O(logn)
	private void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;

		if (l < A.length && A[l] > A[i]) {
			largest = l;
		}

		if (r < A.length && A[r] > A[largest]) {
			largest = r;
		}

		if (largest != i) {
			int tmp = A[i];
			A[i] = A[largest];
			A[largest] = tmp;

			return maxHeapify(largest);
		}
	}

    // time O(n)
	public void buildMaxHeap() {
		// from the second lowest level to the top
		// there are n/2 + 1 leaves for a n node BT
		for (int i = A.length / 2; i >= 0; i--) {
			maxHeapify(i);
		}
	}
}