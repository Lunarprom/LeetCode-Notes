public class LC658FindKClosestElements {
	/**
	 * 暴力做法是把整个array遍历一遍然后maintain一个delta值，从小到大往result里面塞
	 * 或者双指针对撞until right - left + 1 == k
	 * 优先队列做法:Customize a comparator.
	 * 二分法先找到离target最近的值然后从中心向两端双指针背离直到填满k个value
	 * 或者二分法找区间的起点
	 */
	class BinarySearchSolution {
	    public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        if (arr == null || arr.length == 0) {
	            return new ArrayList<Integer>();
	        }
	        int left = 0;
	        int right = arr.length - k;
	        // 左闭右开的写法
	        while (left < right) {
	            int mid = left + (right - left) / 2;
	            // Approach to the left since we want to pick smaller numbers.
	            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
	                left = mid + 1;
	            } else {
	                right = mid;
	            }
	        }
	        
	        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
	    }
	}
}