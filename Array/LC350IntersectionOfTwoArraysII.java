public class LC350IntersectionOfTwoArraysII {
	/**
	 * Two pointers solution: Time Complexity O(N), Space Complexity: worst case O(M), M is the size of the shorter array.
	 * 1. Given array is already sorted: skip the sorting part. 
	 */
	class TwoPointersSolution {
	    public int[] intersect(int[] nums1, int[] nums2) {
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);      
	        int p1 = 0;
	        int p2 = 0;
	        List<Integer> numbers = new ArrayList<>();
	        while (p1 < nums1.length && p2 < nums2.length) {
	            int left = nums1[p1];
	            int right = nums2[p2];
	            if (left == right) {
	                numbers.add(left);
	                p1++;
	                p2++;
	            } else if (nums1[p1] < nums2[p2]) {
	                p1++;
	            } else {
	                p2++;
	            }
	        }
	        int[] result = new int[numbers.size()];
	        int i = 0;
	        for (Integer num : numbers) {
	            result[i] = num;
	            i++;
	        }
	        
	        return result;
	    }
	}

	/**
	 * 2. If one array is smaller than the other, then only store the number-count in one HashMap.
	 * 3. If elements of nums2 are sorted on disk: this solution can also solve the problem.
	 */
	class HashMapSolution {
	    public int[] intersect(int[] nums1, int[] nums2) {
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        Map<Integer, Integer> map1 = new HashMap<>();
	        for (int num : nums1) {
	            map1.put(num, map1.getOrDefault(num, 0) + 1);
	        }
	        
	        List<Integer> list = new ArrayList<>();
	        for (int num : nums2) {
	            if (map1.containsKey(num) && map1.get(num) > 0) {
	                list.add(num);
	                map1.put(num, map1.get(num) - 1);
	            }
	        }
	        int[] result = new int[list.size()];
	        int i = 0;
	        for (Integer num : list) {
	            result[i] = num;
	            i++;
	        }
		        
		    return result;
	    }
	}
}