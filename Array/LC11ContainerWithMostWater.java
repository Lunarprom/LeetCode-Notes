public class LC11ContainerWithMostWater {
	/**
	 * Brute force solution: compare each two and get the max. O(N^2)
	 * area = Math.min(height[i], height[j]) * (j - i)
	 * 关键是要证明可以往左，或者往右挪动
	 * 
	 */
	class TwoPointersSolution {
	    public int maxArea(int[] height) {
	        if (height == null || height.length < 2) {
	            return 0;
	        }
	        int max = 0;
	        int left = 0;
	        int right = height.length - 1;
	        while (left < right) {
	            int area = Math.min(height[left], height[right]) * (right - left);
	            max = Math.max(max, area);
	            if (height[left] <= height[right]) {
	                left++;
	            } else {
	                right--;
	            }
	        }
	        
	        return max;
	    }
	}
}