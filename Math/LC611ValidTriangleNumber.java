public class LC611ValidTriangleNumber {
	/**
	 * 先排序，然后从最后一个数开始从前启动~~DFS~~，找俩数之和>最后一个数
	 * 等一下这道题可不就是3Sum吗？-> O(N^2) time
	 * 排序之后，假设a<=b<=c，则如果找到一组a+b>c, 此时a+c>b和b+c>都一定满足
	 */
	class Solution {
	    public int triangleNumber(int[] nums) {
	        int count = 0;
	        Arrays.sort(nums); // O(NLogN) time;
	        for (int i = nums.length - 1; i >= 2; i--) {
	            int left = 0;
	            int right = i - 1;
	            while (left < right) {
	                if (nums[left] + nums[right] > nums[i]) {
	                    count += right - left; // 最小边为left一直到right - 1都满足
	                    right--;
	                } else {
	                    left++;
	                }
	            }
	        }
	        
	        return count;
	    }
	}
}