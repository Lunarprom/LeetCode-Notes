public class LC41FirstMissingPositive {
	/**
	 * 直觉做法是先排序然后一直找到正负交界处。但题目要求是O(N) time + constant space
	 * 只能一遍scan然后maintain 最小的正数值？设置一个global min，初始化为Integer.MAX_VALUE，
	 * min = 1
	 * nums[i] <0 -> min = 1;
	 * nums[i] == min -> min++;
	 * nums[i] < min -> min = nums[i] + 1;
	 * 这道题作为Hard，坑在哪里呢？ -> 想想edge case
	 */
	public class Solution {

	    public int firstMissingPositive(int[] nums) {
	        int len = nums.length;
	        // 自己写Hash function，将数值为i的数映射到i-1的下标 (比如i=1应该在index=0)
	        for (int i = 0; i < len; i++) {
	            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
	                // 满足在指定范围内、并且没有放在正确的位置上，才交换
	                // 例如：数值 3 应该放在索引 2 的位置上
	                swap(nums, nums[i] - 1, i);
	            }
	        }

	        // [1, -1, 3, 4]
	        for (int i = 0; i < len; i++) {
	            if (nums[i] != i + 1) {
	                return i + 1;
	            }
	        }
	        
	        // 都正确则返回数组长度 + 1
	        return len + 1;
	    }

	    private void swap(int[] nums, int index1, int index2) {
	        int temp = nums[index1];
	        nums[index1] = nums[index2];
	        nums[index2] = temp;
	    }
	}
}