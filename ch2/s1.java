class SectionOne {
	// insertion sort
	// in-place, time O(N^2)
	public void insertionSort(int[] nums) {
	    for (int j = 1; j < nums.length; j++) {
	    	int replacement = nums[j];
	    	i = j - 1;
	    	while (i >= 0 && nums[i] > replacement) {
	    		nums[i + 1] = nums[i];
	    		i--;
	    	}
	    	nums[i + 1] = replacement;
	    }
	}
}