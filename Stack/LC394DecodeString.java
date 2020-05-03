public class LC394DecodeString {
	class StackIterationSolution {
	    public String decodeString(String s) {
	        if (s == null || s.length() == 0) {
	            return s;
	        }
	        StringBuilder sb = new StringBuilder();
	        LinkedList<Integer> timeStack = new LinkedList<>();
	        LinkedList<String> resultStack = new LinkedList<>();
	        int times = 0;
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if (c >= '0' && c <= '9') {
	                times = times * 10 + c - '0';
	            } else if (c == '[') {
	                if (times > 0) {
	                    timeStack.addLast(times);
	                }
	                resultStack.addLast(sb.toString());
	                // Finish up the previous String piece and initialze the current counter.
	                times = 0;
	                sb = new StringBuilder();
	            } else if (c == ']') {
	                StringBuilder tmp = new StringBuilder().append(resultStack.removeLast());
	                int currTimes = timeStack.removeLast();
	                for (int j = 0; j < currTimes; j++) {
	                    tmp.append(sb); // Attach the current String piece to the tmp StringBuilder for dedicated times.
	                }
	                sb = tmp;
	            } else {
	                sb.append(c);
	            }
	        }
	        
	        return sb.toString();
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