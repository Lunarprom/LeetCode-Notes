public class LC3LongestSubstringWithoutRepeatingCharacters {
	/**
	 * Typical sliding window solution
	 * Runtime: 2 ms, faster than 99.74% of Java online submissions for Longest Substring Without Repeating Characters.
	 * Memory Usage: 39.7 MB, less than 12.75% of Java online submissions for Longest Substring Without Repeating Characters.
	 */
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int maxLen = 0;
	        if (s == null || s.length() == 0) {
	            return maxLen;
	        }
	        int[] count = new int[128];
	        int left = 0;
	        int right = 0;
	        for (; right < s.length(); right++) {
	            count[s.charAt(right)]++;
	            while (count[s.charAt(right)] > 1) {
	                count[s.charAt(left)]--;
	                left++;
	            }
	            maxLen = Math.max(maxLen, right - left + 1);
	        }
	        
	        return maxLen;
	    }
	}
}