public class LC1213IntersectionOfThreeSortedArrays {
	/**
	 * 对于K个array找intersection的情况，可以写个merge K helper method to divide and conquer.
	 * For 3 arrays, HashMap or three pointers can still work. 
	 */
	class Solution {
	    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
	        int p1 = 0;
	        int p2 = 0;
	        int p3 = 0;
	        List<Integer> result = new ArrayList<>();
	        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
	            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
	                result.add(arr1[p1]);
	                p1++;
	                p2++;
	                p3++;           
	            } else {
	                int min = Math.min(arr1[p1], Math.min(arr2[p2], arr3[p3]));
	                if (arr1[p1] == min) {
	                    p1++;
	                }
	                if (arr2[p2] == min) {
	                    p2++;
	                }
	                if (arr3[p3] == min) {
	                    p3++;
	                }
	            }
	        }

	        return result;
	    }
	}
}