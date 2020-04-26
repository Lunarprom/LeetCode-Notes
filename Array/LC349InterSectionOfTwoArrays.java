public class LC349InterSectionOfTwoArrays {
	/**
	 * [1,1,2,2]
	 * [2,2]
	 * Time Complexity: if the array is already sorted, then O(M+N) since we have to visit all numbers.
	 * Space Complexity: Worst case O(M + N) for the extra HashSet
	 * 1. Hash Table calculates the count of each number in the shorter array and then traverse the second array. O(N)
	 * 2. Sort the two arrays and use two pointers O(NlogN) sorting O(2N) = O(N) two pointers traversal.
	 * 3. 这个题跟Binary Search有什么关系？？？（先sort一个list，然后在另一个list里去查找对应的value)
	Follow up: This is a Facebook interview question. They ask for the intersection, which has a trivial solution using a hash or a set.
	Then they ask you to solve it under these constraints:
	O(n) time and O(1) space (the resulting array of intersections is not taken into consideration).
	You are told the lists are sorted.
	Cases to take into consideration include:
	duplicates, negative values, single value lists, 0's, and empty list arguments.
	Other considerations might include sparse arrays.
	 */
	class Solution {
	    public int[] intersection(int[] nums1, int[] nums2) {
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        
	        
	        int p1 = 0;
	        int p2 = 0;
	        Set<Integer> set = new HashSet<>();
	        while (p1 < nums1.length && p2 < nums2.length) {
	            int left = nums1[p1];
	            int right = nums2[p2];
	            if (left == right) {
	                set.add(left);
	                while (p1 < nums1.length && nums1[p1] == left) {
	                    p1++;
	                }
	                while (p2 < nums2.length && nums2[p2] == right) {
	                    p2++;
	                }
	            } else if (nums1[p1] < nums2[p2]) {
	                while (p1 < nums1.length && nums1[p1] == left) {
	                    p1++;
	                }
	            } else {
	                while (p2 < nums2.length && nums2[p2] == right) {
	                    p2++;
	                }
	            }
	        }
	        int[] result = new int[set.size()];
	        int i = 0;
	        for (Integer num : set) {
	            result[i] = num;
	            i++;
	        }
	        
	        return result;
	    }
	}
}