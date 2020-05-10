/**
 * 套用76题LeetCode的高票模板
 */
public class LC159LongestSubstringWithAtMostTwoDistinctCharacters {
	class Solution {
	    public int lengthOfLongestSubstringTwoDistinct(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        int[] chars = new int[128];
	        int counter = 0;
	        int left = 0;
	        int right = 0;
	        int maxLen = 0;
	        while (right < s.length()) {
	            char rightCh = s.charAt(right);
	            // Non-repeating chars
	            if (chars[rightCh] < 1) {
	                counter++;
	            }
	            chars[rightCh]++;
	            right++;
	            while(counter > 2) {
	                char leftCh = s.charAt(left);
	                if (chars[leftCh] <= 1) {
	                    counter--;
	                }
	                chars[leftCh]--;
	                left++;
	            }
	            maxLen = Math.max(maxLen, right - left);
	        }
	        
	        return maxLen;
	    }
	}
}