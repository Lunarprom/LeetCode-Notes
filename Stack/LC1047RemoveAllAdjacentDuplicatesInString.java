public class LC1047RemoveAllAdjacentDuplicatesInString {
	/**
	 * 用Stack就解决了的事儿。Tricky part is 直接遍历栈内元素的话实际上是会按顺序输出的。
	 */
	class Solution {
	    public String removeDuplicates(String S) {
	        if (S == null || S.length() < 2) {
	            return S;
	        }
	        StringBuilder sb = new StringBuilder();
	        Stack<Character> stack = new Stack<>();
	        for (int i = 0; i < S.length(); i++) {
	            char c = S.charAt(i);
	            if (!stack.isEmpty() && stack.peek() == c) {
	                stack.pop();
	            } else {
	                stack.push(c);
	            }
	        }
	        
	        for (char c : stack) {
	            sb.append(c);
	        }
	        
	        return sb.toString();
	    }
	}
}