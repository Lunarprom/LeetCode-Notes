public class LC75SortColors {
	class TwoPointersSolution {
	    public void sortColors(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return;
	        }
	        
	        int p0 = 0;
	        int p2 = nums.length - 1;
	        int curr = 0;
	        while (curr <= p2) {
	            if (nums[curr] == 0) {
	                swap(nums, curr, p0);
	                p0++;
	                curr++;
	            } else if (nums[curr] == 2) {
	                swap(nums, curr, p2);
	                p2--;
	            } else {
	                curr++;
	            }
	        }

	        return;
	    }
	    
	    private void swap(int[] nums, int p1, int p2) {
	        int tmp = nums[p1];
	        nums[p1] = nums[p2];
	        nums[p2] = tmp;
	    }
	}
}