public class LC1249MinimumRemoveToMakeValidParentheses {
	/**
	 * 思路：遍历Character, 遇到'('就把它的index压进stack，遇到')'就peek stack: if stack is empty, then remove the current index; else. pop out the index of '()';
	 * At the end, pop the indices of remaining '(' and remove them from the String
	 * Runtime: 17 ms, faster than 67.00% of Java online submissions for Minimum Remove to Make Valid Parentheses.
	 * Memory Usage: 40.3 MB, less than 100.00% of Java online submissions for Minimum Remove to Make Valid Parentheses.
	 * 15min? 10min? No logic issue, only tricky part was the String building.
	 */
	class Solution {
	    public String minRemoveToMakeValid(String s) {
	        Stack<Integer> stack = new Stack<>();
	        char[] chars = s.toCharArray();
	        for (int i = 0; i < chars.length; i++) {
	            if (chars[i] == '(') {
	                stack.push(i);
	            }
	            if (chars[i] == ')') {
	                if (stack.isEmpty()) {
	                    chars[i] = ' ';
	                } else {
	                    stack.pop();
	                }
	            }
	        }
	        while (!stack.isEmpty()) {
	            chars[stack.pop()] = ' ';
	        }
	        String charS = new String(chars);
	        
	        return charS.replaceAll(" ", "");
	    }
	}
}