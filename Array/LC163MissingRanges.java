public class LC163MissingRanges {
	/**
	 * Array is sorted. Given the lower and upper. 
	 * Use a pointer that starts from lower?
	 * compare the i with lower, if it is larger then missing (lower, first - 1);
	 * Consider more edge cases: What about the last one? (lower + 1, upper);
	lower upper
	                         lower   upper
	lower                         upper 
	             lower  upper        
	lower       upper
	                lower       upper
	           [..............]
	 */
	class Solution {
	    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	        if (lower > upper) {
	            return new ArrayList<>();
	        }
	        if (nums == null || nums.length == 0 || nums[0] > upper || nums[nums.length - 1] < lower) {
	            String result = buildRange(lower, upper);
	            return new ArrayList<String>(Arrays.asList(result));
	        }
	        List<String> list = new ArrayList<>();

	        // Lower boundary
	        if (nums[0] > lower) {
	            list.add(buildRange(lower, nums[0] - 1));
	        }
	        
	        for (int i = 0; i < nums.length - 1; i++){
	            if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1) {
	                list.add(buildRange(nums[i] + 1, nums[i + 1] - 1));
	            }
	        }
	        
	        // Upper boundary
	        if (nums[nums.length - 1] < upper) {
	            list.add(buildRange(nums[nums.length - 1] + 1, upper));
	        }
	        
	        
	        return list;
	    }
	    
	    private String buildRange(int left, int right) {
	        if (left == right) {
	            return String.valueOf(left);
	        }
	        return String.valueOf(left) + "->" + String.valueOf(right);
	    }
	}
}