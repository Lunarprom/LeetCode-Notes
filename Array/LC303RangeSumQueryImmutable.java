public class LC303RangeSumQueryImmutable {
	/**
	 * Prefix sum: initialization needs O(N) time.
	 * After that, each query needs O(1) time
	 * Runtime: 6 ms, faster than 100.00% of Java online submissions for Range Sum Query - Immutable.
	 * Memory Usage: 42.4 MB, less than 48.78% of Java online submissions for Range Sum Query - Immutable.
	 * <10min, bug: 搞错了初始化时候的边界条件。
	 */
	class PrefixSumNumArray {

	    int[] prefix;
	    
	    public NumArray(int[] nums) {
	        prefix = new int[nums.length + 1];
	        prefix[0] = 0;
	        for (int i = 1; i <= nums.length; i++) {
	            prefix[i] = nums[i - 1] + prefix[i - 1];
	        }
	    }
	    
	    //   [-2, 0, 3, -5, 2, -1]
	    // [0,-2,-2, 1, -4,-2, -3]
	    //    (2,5) 
	    public int sumRange(int i, int j) {
	        int[] bla = prefix;
	        if (i > j) {
	            return -1;
	        }
	        return prefix[j + 1] - prefix[i];
	    }
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(i,j);
	 */
}