public class LC76MinimumWindowSubstring {
	/**
	 * 可以用HashMap，也可以用长度为128的数组来存储字符的出现次数(char ASCII - int 互转)
	 * 同向双指针(sliding window)
	 * Similar to 438 https://leetcode.com/problems/find-all-anagrams-in-a-string/ 
	 * Runtime: 14 ms, faster than 40.32% of Java online submissions for Minimum Window Substring.
	 * Memory Usage: 40.4 MB, less than 24.47% of Java online submissions for Minimum Window Substring.
	 * 10 minute. Minor bug.
	 */
	class Solution {
	    public String minWindow(String s, String t) {
	        String result = "";
	        if (s == null || s.length() == 0 || s.length() < t.length()) {
	            return result;
	        }
	        Map<Character, Integer> mapT = new HashMap<>();
	        Map<Character, Integer> mapS = new HashMap<>();
	        for (Character c : t.toCharArray()) {
	            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
	        }
	        int left = 0;
	        int right = 0;
	        int match = 0;
	        int minLen = Integer.MAX_VALUE;
	        for (; right < s.length(); right++) {
	            Character rightChar = s.charAt(right);
	            if (mapT.containsKey(rightChar)) {
	                mapS.put(rightChar, mapS.getOrDefault(rightChar, 0) + 1);
	                
	                if (mapT.get(rightChar).equals(mapS.get(rightChar))) {
	                    match++;
	                }
	            }
	            
	            while (mapT.keySet().size() == match) {
	                if (right - left + 1 < minLen) {
	                    result = s.substring(left, right + 1);
	                    minLen = right - left + 1;
	                }
	                
	                // Move left pointer to the right;
	                Character leftChar = s.charAt(left);
	                if (mapT.containsKey(leftChar)) {
	                    mapS.put(leftChar, mapS.get(leftChar) - 1);
	                    if (mapS.get(leftChar) < mapT.get(leftChar)) {
	                        match--;
	                    }
	                }
	                left++;
	            }
	        }
	        
	        return result;
	    }
	}
}