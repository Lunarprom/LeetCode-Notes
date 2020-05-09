/**
 * 套用第76题的Top Voted template.
 */
public class LC340LongestSubstringwithAtMostKDistinctCharacters {
	class Solution {
	    public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        int[] map = new int[128];
	        int counter = 0;
	        int left = 0;
	        int right = 0;
	        int maxLen = 0;
	        while (right < s.length()) {
	            char rightCh = s.charAt(right);
	            if (map[rightCh] < 1) {
	                counter++;
	            }
	            map[rightCh]++;
	            right++;
	            while (counter > k) {
	                char leftCh = s.charAt(left);
	                if (map[leftCh] <= 1) {
	                    counter--;
	                }
	                map[leftCh]--;
	                left++;
	            }
	            
	            maxLen = Math.max(maxLen, right - left);
	        }
	        
	        return maxLen;
	    }
	}
}