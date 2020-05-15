public class LC139WordBreak {

	/**
	 * dp[i] 取决于第j个字符和j~i之间substring的状态
	 */
	class DPSolution {
	    public boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> dict = new HashSet<>(wordDict);
	        boolean[] dp = new boolean[s.length() + 1];
	        dp[0] = true;
	        for (int i = 1; i <= s.length(); i++) {
	            for (int j = 0; j < i; j++) {
	                if (dp[j] && dict.contains(s.substring(j, i))) {
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        
	        return dp[s.length()];
	    }
	}

	/**
	 * Added memoization for DFS.
	 * Runtime: 5 ms, faster than 78.94% of Java online submissions for Word Break.
	 * Memory Usage: 39.6 MB, less than 5.08% of Java online submissions for Word Break.
	 */
	class MemorizedDFSSolution {
	    public boolean wordBreak(String s, List<String> wordDict) {
	        if (s == null || s.length() == 0) {
	            return true;
	        }
	        Set<String> dict = new HashSet<String>(wordDict);
	        Map<Integer, Boolean> memo = new HashMap<>();
	        return helper(s, dict, memo, 0);
	    }
	    
	    private boolean helper(String s, 
	                        Set<String> dict,
	                        Map<Integer, Boolean> memo,
	                        int start) {
	        if (start == s.length()) {
	            return true;
	        }
	        if (memo.containsKey(start)) {
	            return memo.get(start);
	        }
	        for (int i = start; i < s.length(); i++) {
	            if (dict.contains(s.substring(start, i + 1))) {
	                if (helper(s, dict, memo, i + 1)) {
	                    memo.put(start, true);
	                    return true;
	                }
	            }
	        }
	        memo.put(start, false);
	        return false;
	    }
	}

	/**
	 * Optimization: Added memoization for DFS.
	 * Optimization: If the substring is longer than the longest word in the dictionary, then the substring won't match anything in the dictionary.
	 * Runtime: 1 ms, faster than 98.74% of Java online submissions for Word Break.
	 * Memory Usage: 38.1 MB, less than 17.39% of Java online submissions for Word Break.
	 */
	class OptimizedDFSSolution2 {
	    public boolean wordBreak(String s, List<String> wordDict) {
	        if (s == null || s.length() == 0) {
	            return true;
	        }
	        int max = Integer.MIN_VALUE;
	        Set<String> dict = new HashSet<String>();
	        for (String word : wordDict) {
	            max = Math.max(max, word.length());
	            dict.add(word);
	        }
	        Map<Integer, Boolean> memo = new HashMap<>();
	        return helper(s, dict, memo, 0, max);
	    }
	    
	    private boolean helper(String s, 
	                        Set<String> dict,
	                        Map<Integer, Boolean> memo,
	                        int start,
	                        int max) {
	        if (start == s.length()) {
	            return true;
	        }
	        if (memo.containsKey(start)) {
	            return memo.get(start);
	        }
	        for (int i = start; i < start + max && i < s.length(); i++) {
	            if (dict.contains(s.substring(start, i + 1))) {
	                if (helper(s, dict, memo, i + 1, max)) {
	                    memo.put(start, true);
	                    return true;
	                }
	            }
	        }
	        memo.put(start, false);
	        return false;
	    }
	}
}