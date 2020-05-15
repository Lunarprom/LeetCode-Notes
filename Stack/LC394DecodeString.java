public class LC394DecodeString {
	/**
	 *  用栈来做:
	 *	1.如果字符是字母，加到StringBuilder;
	 *  2.如果是数字，就更新数字（原本的乘以10再加上当前的个位数）
	 *  3.如果是左括号[,就把数字压到栈里去,StringBuilder curr也变成字符串（candidate of result)压进栈里，再新建一个SB
	 *  4.如果是右括号,说明当前的完事了，用一个tmp接着当前的curr（待重复的）。弹出数字，弹出字符串用curr接着（这是全局字符串candidate of result),
	 * 		然后按次数重复tmp，append到curr后面。
	 */
	class StackSolution {
	    public String decodeString(String s) {
	        Stack<Integer> cntStack = new Stack<>();
	        Stack<StringBuilder> strStack = new Stack<>();
	        StringBuilder curr = new StringBuilder();
	        int count = 0;
	        for (char ch : s.toCharArray()) {
	            if (Character.isDigit(ch)) {
	                count = count * 10 + ch - '0';
	            } else if (ch == '[') {
	                cntStack.push(count);
	                count = 0;
	                strStack.push(curr);
	                curr = new StringBuilder();
	            } else if (ch == ']') {
	                StringBuilder tmp = curr;
	                curr = strStack.pop();
	                int times = cntStack.pop();
	                for (int i = 0; i < times; i++) {
	                    curr.append(tmp);
	                }
	            } else {
	                curr.append(ch);
	            }
	        }
	        
	        return curr.toString();
	    }
	}

	/**
	 * 总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：
	当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
	当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并拼接字符串。
	遍历完毕后返回 res。
	 */
	class RecursionSolution {
	    int idx;
	    public String decodeString(String s) {
	        idx = 0;
	        return dfs(s);
	    }
	    
	    String dfs(String s) {
	        StringBuilder ans = new StringBuilder();
	        int k = 0;
	        while (idx < s.length()) {
	            char ch = s.charAt(idx);
	            
	            if (ch == '[') {
	                ++idx;
	                String str = dfs(s);
	                while (k > 0) {
	                    ans.append(str);
	                    --k;
	                }
	            } else if (ch == ']') {
	                break; // Finish up the current layer of processing.
	            } else if (Character.isDigit(ch)) {
	                k = k * 10 + ch - '0';
	            } else {
	                ans.append(ch);
	            }
	            idx++;
	        }
	        return ans.toString();
	    }
	}
}