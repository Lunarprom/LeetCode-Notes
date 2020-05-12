public class LC5LongestPalindromicSubstring {
	// 中心背离法，每个字母和它之后的空隙都可以分别作为中轴向两边扩散。如果是它自己做中轴，就先比较它和它自己，
	// 然后左右指针分别减和加。如果是空隙做中轴，就直接比较当前字母和下一个字母。
	// helper method返回当前substring的长度，然后当前字母的index - (len - 1)/2作为左边界，index + len/2作为右边界。
	// helper method记得要用right - left - 1.因为在最后一次循环执行后，正确的长度是right - left + 1.但左右指针又分别减和加了，
	// 因此是多出来两格，要减去2，right - left + 1 - 2 = right - left - 1.
	class Solution {
	    public String longestPalindrome(String s) {
	        if (s == null || s.length() == 0) {
	            return "";
	        }
	        
	        int start = 0;
	        int end = 0;
	        for (int i = 0; i < s.length(); i++) {
	            int len1 = expandFromCenter(s, i, i);
	            int len2 = expandFromCenter(s, i, i + 1);
	            int len = Math.max(len1, len2);
	            if (end - start < len) {
	                start = i - (len - 1) / 2;
	                end = i + len / 2;
	            }
	        }
	        
	        return s.substring(start, end + 1);
	    }
	    
	    private int expandFromCenter(String s, int left, int right) {
	        while (left >= 0
	              && right < s.length()
	              && s.charAt(left) == s.charAt(right)) {
	            left--;
	            right++;
	        }
	        
	        return right - left - 1;
	    }
	}
}