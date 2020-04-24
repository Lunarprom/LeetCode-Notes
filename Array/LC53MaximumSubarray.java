public class LC53MaximumSubarray {

	/**
	 * Follow up: return the start and end index of the maximum subarray.
	 */
	class FollowUpSolution {
		public int maxSubArray(int[] nums) {
			if (nums == null) {
				return 0;
			}

			int start = 0;
			int end = 0;
			int subStart = 0;
			int subEnd = 0;
			int max = nums[0];
			int subMax = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (subMax > 0) {
					subMax = subMax + nums[i];
					subEnd++;
				} else {
					subMax = nums[i];
					subStart = i;
					subEnd = i;
				}

				if (subMax > max) {
					max = subMax;
					start = subStart;
					end = subEnd;
				}
			}

			System.out.println("[" + start + "," + end + "]");

			return max;
		}
	}

	/**
	 * Slice the array into three parts: left, right, cross middle
	 */
	class DivideAndConquerSolution {
		public int maxSubArray(int[] nums) {
			return divideAndConquer(nums, 0, nums.length - 1);
		}

		private int divideAndConquer(int[] nums, int start, int end) {
			if (start == end) {
				return nums[start];
			}

			int center = (start + end) / 2;
			int leftMax = divideAndConquer(nums, start, center);
			int rightMax = divideAndConquer(nums, center + 1, end);

			// calculate the max sum of the left subarray
			int leftCrossMax = Integer.MIN_VALUE;
			int leftCrossSum = 0;
			for (int i = center; i >= start; i--) {
				leftCrossSum += nums[i];
				leftCrossMax = Math.max(leftCrossSum, leftCrossMax);
			}

			int rightCrossMax = Integer.MIN_VALUE;
			int rightCrossSum = 0;
			for (int i = center + 1; i <= end; i++) {
				rightCrossSum = rightCrossSum + nums[i];
				rightCrossMax = Math.max(rightCrossSum, rightCrossMax);
			}

			int centermax = leftCrossMax + rightCrossMax;

			return Math.max(centermax, Math.max(leftCrossMax, rightCrossMax));
		}
	}

	/**
	 * Greedy solution
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
	 * Memory Usage: 39.3 MB, less than 9.39% of Java online submissions for Maximum Subarray.
	 */
	class GreedySolution {
	    public int maxSubArray(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        int bestSum = nums[0];
	        int curSum = nums[0];
	        for (int i = 1; i < nums.length; i++) {
	            curSum = Math.max(nums[i], curSum + nums[i]);
	            bestSum = Math.max(curSum, bestSum);
	        }
	        
	        return bestSum;
	    }
	}

	/**
	 * Failed solution:
	 * [-2, 1,-3,4,-1,2,1,-5,4]
	 * [-2,-1,-4,0,-1,1,2,-3,1]
	 * Brute force: O(N^2) loop
	 * Prefix sum: find the minimum and maximum, return the delta
	 * Corner case: nums.length == 1
	 * Also Math.max() doesnt't work well when there is Integer.MIN_VALUE and another negative number.
	 */
	class PrefixSumSolution {
	    public int maxSubArray(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        int len = nums.length;
	        int[] prefix = new int[len];
	        prefix[0] = nums[0];
	        for (int i = 1; i < len; i++) {
	            prefix[i] = nums[i] + prefix[i - 1];
	        }
	        int minSum = Integer.MAX_VALUE;
	        int maxSum = Integer.MIN_VALUE;
	        for (int i = 0; i < len; i++) {
	            minSum = Math.min(minSum, prefix[i]);
	            maxSum = Math.max(maxSum, prefix[i] - minSum);
	        }
	        
	        return maxSum;
	    }
	}
}