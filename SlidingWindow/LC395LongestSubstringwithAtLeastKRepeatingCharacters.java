/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739/Java-Strict-O(N)-Two-Pointer-Solution
 * 还是用到了substring问题的模板。唯一不同的是需要对26个字母进行遍历循环，因为题目的要求是，对于每个字母，都必须得出现至少K次。
 * 时间复杂度O(26N)->O(N)
 */
public class LC395LongestSubstringwithAtLeastKRepeatingCharacters{
	class TwoPointersSolution {
	    public int longestSubstring(String s, int k) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        int maxLen = 0;
	        for (int i = 1; i <= 26; i++) {
	            maxLen = Math.max(maxLen, longestSubStringWithNUniqueChars(s, k, i));
	        }
	            
	        return maxLen;
	    }
	    
	    private int longestSubStringWithNUniqueChars(String s, int k, int numUniqueTarget) {
	        int[] chars = new int[128];
	        int left = 0;
	        int right = 0;
	        int kOrMore = 0;
	        int unique = 0;
	        int maxLen = 0;
	        while (right < s.length()) {
	            char rightCh = s.charAt(right);
	            if (chars[rightCh] == 0) {
	                unique++;
	            }
	            chars[rightCh]++;
	            if (chars[rightCh] == k) {
	                kOrMore++;
	            }
	            right++;
	            
	            while (unique > numUniqueTarget) {
	                char leftCh = s.charAt(left);
	                if (chars[leftCh] == k) {
	                    kOrMore--;
	                }
	                chars[leftCh]--;
	                if (chars[leftCh] == 0) {
	                    unique--;
	                }
	                left++;
	            }
	            if (unique == numUniqueTarget && unique == kOrMore) {
	                maxLen = Math.max(maxLen, right - left);
	            }
	        }
	        
	        return maxLen;
	    }
	}
}